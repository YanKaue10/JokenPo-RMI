package RMI.Cliente;

import Enuns.Jogada;
import RMI.Interface.JokenPoService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class IniciarCliente {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("ip da maquina", 1099);
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
            System.out.println("");
            int jogada = sc.nextInt();

            switch (jogada) {
                case 1:
                    System.out.println("Jogador escolheu: " + Jogada.PEDRA);
                    break;
                case 2:
                    System.out.println("Jogador escolheu: " + Jogada.PAPEL);
                    break;
                case 3:
                    System.out.println("Jogador escolheu: " + Jogada.TESOURA);
                    break;
                case 4:
                    System.out.println("Jogador está saindo do jogo..");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
            Jogada numeroJogada = null;
            if (nmrJogador == 1) {
                jokenPoService.setJogador1(numeroJogada);
                System.out.println("Jogador " + nmrJogador + "jogou : " + numeroJogada);
            } else {
                jokenPoService.setJogador2(numeroJogada);
                System.out.println("Jogador " + nmrJogador + "jogou : " + numeroJogada);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



