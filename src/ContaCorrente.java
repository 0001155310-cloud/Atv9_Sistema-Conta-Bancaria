// Criando Classe
public class ContaCorrente extends Conta {


    //Decalrando Variáveis
    double limiteChequeEspecial;
    // double saldoTotalDisponivel; <-- Variável desnecessária como campo, pode ser local no método.


    //Construtor daClasse
    public ContaCorrente(String numero, String titular, double saldoInicial, double limiteChequeEspecial) {
        super(numero, titular, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    } //Fim do construtor


//Métodos

    // Sacar (CORRIGIDO: Apenas uma versão, com a assinatura correta)
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {

        // Cálculo deve usar this.saldo (herdado) e this.limiteChequeEspecial
        double saldoTotalDisponivel = this.saldo + this.limiteChequeEspecial;

        // Verifica se o  valor do saque excede o saldo total disponível
        if (valor > saldoTotalDisponivel) {
            // Lança a exceção diretamente
            throw new SaldoInsuficienteException("[ERRO] - Não foi possível realizar o saque: O valor excedeu o seu saldo total disponível (R$" + saldoTotalDisponivel + ")!");
        } else {
            this.saldo -= valor;
            // REGISTRO DO SAQUE
            registrarTransacao("SAQUE", valor); // Assumindo que registrarTransacao é protected na Conta
            System.out.println("Sucesso - Um saque de R$" + valor + " foi realizado!");
            System.out.println("Novo Saldo: R$" + this.saldo);
        }
    }

    // Depositar (Já estava correta, mas não precisa do @Override se já estava implementada na Conta)
    // Se a Conta for abstrata, o depositar deve ser implementado, ou ser abstrato lá.
    // Como você já implementou ele na Conta, esta sobrescrita é opcional.
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            registrarTransacao("DEPOSITO", valor);
            System.out.println("Sucesso - Depósito de R$" + valor + " realizado.");
        } else {
            System.out.println("[ERRO] - O valor do depósito deve ser positivo.");
        }
    }
}