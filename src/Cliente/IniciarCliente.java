package Cliente;

import Enuns.Jogada;
import RMI.JokenPoService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class IniciarCliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("10.8.185.18", 1099);
            JokenPoService jokenPoService = (JokenPoService) registry.lookup("JokenPo");

            Scanner sc = new Scanner(System.in);

            System.out.println("JOKENPO");
            System.out.print("Informe o numero do jogador (1 ou 2): ");
            int numeroJogador = sc.nextInt();

            jokenPoService.registrarJogador(numeroJogador);
            System.out.println("Conectado! Aguardando o proximo jogador");

            Thread.sleep(2000);

            for (int i = 1; i <= 5; i++) {
                System.out.println(" RODADA " + i + " : ");
                System.out.println("1 - Pedra");
                System.out.println("2 - Papel");
                System.out.println("3 - Tesoura");
                System.out.print("Escolha: ");

                int escolha = sc.nextInt();
                Jogada jogada = null;

                switch (escolha) {
                    case 1:
                        jogada = Jogada.PEDRA;
                        break;
                    case 2:
                        jogada = Jogada.PAPEL;
                        break;
                    case 3:
                        jogada = Jogada.TESOURA;
                        break;
                    default:
                        System.out.println("Inválido!");
                        i--;
                        continue;
                }

                String resultado = jokenPoService.jogar(numeroJogador, jogada);
                System.out.println(resultado);
            }

            System.out.println(jokenPoService.obterPlacar());
            sc.close();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}




