package RMI;

import Enuns.Jogada;
import Enuns.Resultado;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorJokenPo extends UnicastRemoteObject implements JokenPoService {

    protected ServidorJokenPo() throws RemoteException {
        super();
    }

    private Jogada jogada1;
    private Jogada jogada2;
    private int vitorias1 = 0;
    private int vitorias2 = 0;
    private int empates = 0;
    private int rodada = 1;
    private final int TOTAL_RODADAS = 5;

    private boolean jogador1Conectado = false;
    private boolean jogador2Conectado = false;

    @Override
    public synchronized void registrarJogador(int numeroJogador) throws RemoteException {
        if (numeroJogador == 1) {
            jogador1Conectado = true;
            System.out.println("Jogador 1 conectado!");
        } else {
            jogador2Conectado = true;
            System.out.println("Jogador 2 conectado!");
        }

        if (jogador1Conectado && jogador2Conectado) {
            System.out.println("Ambos os jogadores conectados");
        }
    }

    @Override
    public synchronized String jogar(int numeroJogador, Jogada jogada) throws RemoteException {

        while (!jogador1Conectado || !jogador2Conectado) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (numeroJogador == 1) {
            jogada1 = jogada;
            System.out.println("Jogador 1 jogou: " + jogada);
        } else {
            jogada2 = jogada;
            System.out.println("Jogador 2 jogou: " + jogada);
        }

        if (jogada1 != null && jogada2 != null) {
            String resultado = calcularResultado();

            jogada1 = null;
            jogada2 = null;

            return resultado;
        }

        return "Aguardando outro jogador...";
    }

    private String calcularResultado() {
        String msg = "Rodada " + rodada + ": ";

        if ((jogada1 == Jogada.PEDRA && jogada2 == Jogada.TESOURA) ||
                (jogada1 == Jogada.PAPEL && jogada2 == Jogada.PEDRA) ||
                (jogada1 == Jogada.TESOURA && jogada2 == Jogada.PAPEL)) {

            vitorias1++;
            msg += "Jogador 1 venceu!";

        } else if ((jogada2 == Jogada.PEDRA && jogada1 == Jogada.TESOURA) ||
                (jogada2 == Jogada.PAPEL && jogada1 == Jogada.PEDRA) ||
                (jogada2 == Jogada.TESOURA && jogada1 == Jogada.PAPEL)) {

            vitorias2++;
            msg += "Jogador 2 venceu!";

        } else {
            empates++;
            msg += "Empate";
        }

        System.out.println(msg);
        rodada++;
        return msg;
    }

    @Override
    public String obterPlacar() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("Placar Final");
        sb.append("Jogador 1: ").append(vitorias1).append(" vitórias");
        sb.append("Jogador 2: ").append(vitorias2).append(" vitórias");
        sb.append("Empates: ").append(empates);

        if (vitorias1 > vitorias2) {
            sb.append("Jogador 1 venceu!");
        } else if (vitorias2 > vitorias1) {
            sb.append("Jogador 2 venceu!");
        } else {
            sb.append("Empate");
        }
        return sb.toString();
    }
}


