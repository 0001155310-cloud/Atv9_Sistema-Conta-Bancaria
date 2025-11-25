import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Cria a conta corrente com saldo inicial de 1000 e limite de 500
        ContaCorrente minhaConta = new ContaCorrente("12345-6", "Alice", 1000.00, 500.00);

        // 2. Realiza transações
        minhaConta.depositar(200.00); // Saldo vai para 1200.00

        try {
            minhaConta.sacar(1700.00); // Excede o saldo (1200), mas usa cheque especial
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Histórico de Transações ---");

        // 3. Imprime o histórico
        for (Transacao t : minhaConta.getHistoricoTransacoes()) {
            System.out.println(t);
        }
    }
}
