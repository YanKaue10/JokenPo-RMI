package RMI.Interface;

import Enuns.Jogada;
import Enuns.Resultado;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JokenPoService extends Remote {

    void setJogador1(Jogada jogada) throws RemoteException;
    void setJogador2(Jogada jogada) throws RemoteException;

    Resultado resultadoPartida() throws RemoteException;

    void quantidadeRodadas() throws RemoteException;

    void vencedorPartida() throws RemoteException;
    void placar() throws RemoteException;
}
