//Classe Transacao
import java.time.LocalDateTime;

public class Transacao {

    private String tipo; // Ex: "DEPOSITO", "SAQUE"
    private double valor;
    private LocalDateTime dataHora;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now(); // Pega a data e hora atual
    }

    // Métodos getters (getTipo, getValor, getDataHora)
    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Valor: R$" + valor + ", Data/Hora: " + dataHora.toString();
        }
    }


