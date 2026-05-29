package RMI;

import Enuns.Jogada;
import Enuns.Resultado;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JokenPoService extends Remote {

    void registrarJogador(int numeroJogador) throws RemoteException;

    String jogar(int numeroJogador, Jogada jogada) throws RemoteException;

    String obterPlacar() throws RemoteException;
}
