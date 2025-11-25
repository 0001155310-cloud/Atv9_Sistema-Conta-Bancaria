import java.util.HashMap;
import java.util.Map;

public class Banco {

    // Declara e inicializa o mapa de contas.
    private Map<String, Conta> contas;

    public Banco() {
        this.contas = new HashMap<>();
    }

    // Buscar conta
    public void buscarConta(String numero) {

    }



    //** ===========  Caixinha de menssagens ===========//
    //                                                  //
    //                                                  //
    //         Consertar o Saldo negativo               //
    //                                                  //
    //                                                  //
    //||||||||||||||||||||||||||||||||||||||||||||||||||\\
    //                                                   \\
    //                                                    \\
    //                                                     \\                       .
    //                                                     // oi!, ele é doido
    //                                                    //
    //                                                   //
    //                                                  //
    //                                                  //
    //                                                  //
    //                                                  //
    //  =============================================== //


    // Método auxiliar para adicionar contas
    public void adicionarConta(Conta conta) {
        this.contas.put(conta.getNumero(), conta);
    }

    // realizar transferencia
    public void realizarTransferencia(String origem, String destino, double valor){

    }

}
