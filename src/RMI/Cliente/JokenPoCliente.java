package RMI.Cliente;

import RMI.Interface.JokenPoService;

public class JokenPoCliente {

    private JokenPoService jokenPoService;

    public JokenPoCliente(JokenPoService jokenPoService) {
        this.jokenPoService = jokenPoService;
    }
    public void comecarPartida() throws Exception {
        jokenPoService.quantidadeRodadas();
        jokenPoService.placar();
        jokenPoService.resultadoPartida();
        jokenPoService.vencedorPartida();
    }
}


