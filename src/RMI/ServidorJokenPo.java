package RMI;

import Enuns.Jogada;
import Enuns.Resultado;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorJokenPo extends UnicastRemoteObject implements JokenPoService {

    protected ServidorJokenPo() throws RemoteException {
        super();
    }

    private Jogada jogador1;
    private Jogada jogador2;
    private int nmrVitoria = 0;
    private int nmrDerrota = 0;
    private int nmrEmpate = 0;
    private final int totalRodadas = 5;
    private int rodadaAtual = 1;

    @Override
    public synchronized void sincronizarJogada(Jogada jogada) throws RemoteException {
        if (jogador1 == null) {
            setJogador1(jogada);
        } else if (jogador2 == null) {
            setJogador2(jogada);
            quantidadeRodadas();
        }
    }

    public Resultado resultadoPartida() {
        if ((jogador1.equals(Jogada.PEDRA) && jogador2.equals(Jogada.TESOURA)) ||
                (jogador1.equals(Jogada.PAPEL) && jogador2.equals(Jogada.PEDRA)) ||
                (jogador1.equals(Jogada.TESOURA) && jogador2.equals(Jogada.PAPEL))) {
            return Resultado.VITORIA;
        } else if (jogador1.equals(jogador2)) {
            return Resultado.EMPATE;
        } else {
            return Resultado.DERROTA;
        }
    }

    public String quantidadeRodadas() {
        Resultado resultado = resultadoPartida();
        StringBuilder sb = new StringBuilder();
        // StrinbBuilder... Configuar.
        if (resultado.equals(Resultado.VITORIA)) {
            sb.append("Rodada: ").append(rodadaAtual).append( " Jogador 1 venceu");
            nmrVitoria++;
        } else if (resultado.equals(Resultado.DERROTA)) {
            sb.append("Rodada: ").append(rodadaAtual).append( " Jogador 2 venceu");
            nmrDerrota++;
        } else {
            sb.append("Rodada ").append(rodadaAtual).append( " Empate!");
            nmrEmpate++;
        }
        rodadaAtual++;
        jogador1 = null;
        jogador2 = null;
        if (rodadaAtual > totalRodadas) {
            vencedorPartida();
            placar();
        }
        return sb.toString();
    }

    public String vencedorPartida() {
        System.out.println("Resultado: ");
        if (nmrVitoria > nmrDerrota) {
            return "Jogador 1 venceu";
        } else if (nmrDerrota > nmrVitoria) {
            return "Jogador 2 venceu";
        } else {
            return "Empate";
        }
    }

    public String placar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placar do jogo: ");
        sb.append("Vitórias do jogador 1: ").append(nmrVitoria).append("\n"); // appendLine()?
        sb.append("Vitórias do jogador 2: ").append(nmrDerrota).append("\n"); // appendLine()?
        sb.append("Empates: ").append(nmrEmpate).append("\n"); // appendLine()?
        return sb.toString();
    }

    public void setJogador1(Jogada jogador1) {
        this.jogador1 = jogador1;
    }

    public void setJogador2(Jogada jogador2) {
        this.jogador2 = jogador2;
    }
}


