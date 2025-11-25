// Criando a classe
public class ContaPoupanca extends Conta {

    // Construtor da Classe
    public ContaPoupanca (String numero, String titular, double saldoInicial) {
        // A Poupança não tem cheque especial, então o construtor só chama o construtor pai
        super(numero, titular, saldoInicial);
    } // Fim do construtor

    // Métodos

    // Sacar (Assinatura correta: Apenas um parâmetro "valor")
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {

        // 1. Validação de valor
        if (valor <= 0) {
            throw new IllegalArgumentException("[ERRO] - O valor do saque deve ser positivo.");
        }

        // 2. Verifica se o valor do saque excede o saldo disponível
        if (valor > this.saldo) {
            // Lança a exceção
            throw new SaldoInsuficienteException("[ERRO] - Não foi possível realizar o saque: O valor excedeu o seu saldo atual!");
        } else {
            // 3. Realiza a operação
            this.saldo -= valor;

            // 4. Registra a transação
            registrarTransacao("SAQUE", valor);

            System.out.println("Sucesso - Um saque de R$" + valor + " foi realizado!");
            System.out.println("Novo Saldo: R$" + this.saldo);
        }
    }
}