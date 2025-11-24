//Classe Transacao [Auxiliar]


//Importando
import java.util.Date;


//Criando a classe
public class Transacao {

    // Delcarando atributos
    Date data = new Date();
    String tipo;
    double valor;

//================ Construtor ===========================

    //Construtor da Classe - Transacao
    public Transacao(Date data, String tipo,double valor) {

        this.data = data;
        this.tipo = tipo;
        this.valor = valor;

    } //Fim do canstrutor

//================= Get e Set ==========================

    //Getters
    public Date getData() {return data;}
    public String getTipo() {return tipo;}
    public double getValor() {return valor;}

    //Setters
    public void setData(Date data) {this.data = data;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public void setValor(double valor) {this.valor = valor;}

}
