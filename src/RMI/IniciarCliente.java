package RMI;

import Enuns.Jogada;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class IniciarCliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("endereço de ip da máquina", 1099);
            JokenPoService jokenPoService = (JokenPoService) registry.lookup("JokenPo");

            Scanner sc = new Scanner(System.in);

            System.out.println("Informe o número do jogador: ");
            int nmrJogador = sc.nextInt();

            System.out.println("__JokenPo__");
            System.out.println("");
            System.out.println("1 - Pedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tesoura");
            System.out.println("4 - Sair");
            System.out.println("Digite uma opção desejada: ");
            int jogada = sc.nextInt();
            Jogada numeroJogada = null;
            switch (jogada) {
                case 1:
                        numeroJogada = Jogada.PEDRA;
                    break;
                case 2:
                        numeroJogada = Jogada.PAPEL;
                    break;
                case 3:
                    numeroJogada = Jogada.TESOURA;
                    break;
                case 4:
                    System.out.println("Jogador está saindo do jogo..");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
            if (nmrJogador == 1) {
                jokenPoService.sincronizarJogada(numeroJogada);
                System.out.println("Jogador " + nmrJogador + " jogou : " + numeroJogada);
            } else {
                jokenPoService.sincronizarJogada(numeroJogada);
                System.out.println("Jogador " + nmrJogador + " jogou : " + numeroJogada);
            }
            System.out.println(jokenPoService.quantidadeRodadas());
            System.out.println(jokenPoService.vencedorPartida());
            System.out.println(jokenPoService.placar());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



