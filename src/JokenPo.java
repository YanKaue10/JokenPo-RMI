import Enuns.Jogada;

import java.util.Scanner;

public class JokenPo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jogador1, jogador2;

        System.out.println("__JokenPo__");
        System.out.println("");
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
        System.out.println("4 - Sair");
        System.out.println("Digite uma opção desejada: ");
        System.out.println("");
        int jogada = sc.nextInt();

        switch (jogada){
            case 1:
                System.out.println("Jogador escolheu: " + Jogada.PAPEL);
                break;
            case 2:
                System.out.println("Jogador escolheu: " + Jogada.PEDRA );
                break;
            case 3:
                System.out.println("Jogador escolheu: " + Jogada.TESOURA);
                break;
            case 4:
                System.out.println("Jogador está saindo do jogo");
                break;
            default:
                System.out.println("Opção Inválida");
                break;
        }

    }
    }

