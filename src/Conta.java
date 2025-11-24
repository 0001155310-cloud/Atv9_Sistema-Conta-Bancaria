//Classe Conta [Abstrata]


//Importando
import java.util.List;
import java.util.InputMismatchException;


//Criando a classe
public abstract class Conta {

    // Delcarando atributos (privados)
    private String numero;
    private String titular;
    private double saldo;

    //Vetor para exibir o histórico de transações - Pega informações da classe "Transacao"
    private List<Transacao> historicoTransacoes;


//================ Construtor ===========================

    //Construtor da Classe - Conta
    public Conta (String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;


        //Tratando Exceção no Construtor (IllegalArgumentException)
        if (saldoInicial < 0) {
            //Caso o valor inicial seja negativo
            throw new IllegalArgumentException("[ERRO] - O valor do saldo inicial não pode ser negativo!");
        }


    } //Fim do construtor

//================= Get e Set ==========================

    // Getters
    public String getNumero() {return numero;}
    public String getTitular() {return titular;}
    public double getSaldo() {return saldo;}

    //Setters
    public void setTitular(String titular) {this.titular = titular;}
    public void setNumero(String numero) {this.numero = numero;}
    //(i) Sem setSaldo() - Instruções da atividade

//================= Metodos ==========================

    //Depositar
    public void depositar(double valor) {

        if (valor < 0) {
            throw new IllegalArgumentException("[ERRO] - O valor depositado não pode ser negativo!");
        } else if (valor == 0) {
            throw new IllegalArgumentException("[ERRO] - Não é possível realizar um deposito com valor zero!");
        } else {
            saldo += valor;

            //Regitrando a operação
            //Fica pra depois - resolva isso
        }
    } //fim do


    //Sacar
    public abstract void sacar(double valor);


}
	

	
	