package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class IniciarServidor {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "172.16.19.2");
            ServidorJokenPo servidorJokenPo = new ServidorJokenPo();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("JokenPo", servidorJokenPo);
            System.out.println("Servidor iniciado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
