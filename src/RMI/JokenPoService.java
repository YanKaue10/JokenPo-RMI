package RMI;

import Enuns.Jogada;
import Enuns.Resultado;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JokenPoService extends Remote {

    void sincronizarJogada(Jogada jogada) throws RemoteException;

    Resultado resultadoPartida() throws RemoteException;

    void quantidadeRodadas() throws RemoteException;

    String vencedorPartida() throws RemoteException;

    String placar() throws RemoteException;
}
