package Logica;

import Enuns.Jogada;
import Enuns.Resultado;

public class Partida {
    private Jogada jogador1;
    private Jogada jogador2;
    private int nmrVitoria =0;
    private int nmrDerrota=0;
    private int nmrEmpate=0;

    public Resultado resultadoPartida()  {
        if ((jogador1.equals(Jogada.PEDRA) && jogador2.equals(Jogada.TESOURA)) ||
                (jogador1.equals(Jogada.PAPEL) && jogador2.equals(Jogada.PEDRA)) ||
                (jogador1.equals(Jogada.TESOURA) && jogador2.equals(Jogada.PAPEL))){
            return Resultado.VITORIA;
        } else if (jogador1.equals(jogador2)){
            return Resultado.EMPATE;
        } else {
            return Resultado.DERROTA;
        }
    }
    public void quantidadeRodadas(){
        int rodadas = 1;
        do {
            Resultado resultado = resultadoPartida();
            if (resultado.equals(Resultado.VITORIA)){
                System.out.println("Rodada " + rodadas + ": " + "Jogador 1 venceu");
                nmrVitoria++;
            } else if (resultado.equals(Resultado.DERROTA)){
                System.out.println("Rodada " + rodadas + ": " + "Jogador 2 venceu");
                nmrDerrota++;
            } else {
                System.out.println("Rodada:" + rodadas + ": " + "Empate");
                nmrEmpate++;
            }
            rodadas++;
        } while (rodadas <= 5);
    }

    public void vencedorPartida(){
        System.out.println("");
        System.out.println("Resultado Da rodada:");
        if (nmrVitoria > nmrDerrota){
            System.out.println("Jogador 1 venceu a rodada");
        } else if(nmrDerrota > nmrVitoria) {
            System.out.println("Jogador 2 venceu a rodada");
        } else {
            System.out.println("Empate!");
        }
    }
    public void placar(){
        System.out.println("Placar do jogo: ");
        System.out.println("Número de vitórias na rodada: " + nmrVitoria);
        System.out.println("Número de derrotas na rodada: " + nmrDerrota);
        System.out.println("Número de empates na rodada: " + nmrEmpate);
    }

    public void setJogador1(Jogada jogador1) {
        this.jogador1 = jogador1;
    }

    public void setJogador2(Jogada jogador2) {
        this.jogador2 = jogador2;
    }
}
