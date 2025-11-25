import java.util.ArrayList; // Necessário para inicializar a lista
import java.util.List;
import java.util.InputMismatchException; // Manteve a importação, mas não é usada aqui

// Classe Transacao e SaldoInsuficienteException devem ser definidas em arquivos separados.

public abstract class Conta {

    // 1. Declarações Corrigidas e Encapsulamento
    private final String numero; // Adicionado final, pois o número da conta não deve mudar
    private String titular;
    protected double saldo; // Alterado para protected para acesso por subclasses

    // Lista de histórico de transações
    private List<Transacao> historicoTransacoes;


//================ Construtor ===========================

    public Conta (String numero, String titular, double saldoInicial) {

        // 2. Inicialização do saldo e da lista
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial; // Usa o saldoInicial após validação
        this.historicoTransacoes = new ArrayList<>(); // **CORREÇÃO: Inicializa a lista**

        // Tratando Exceção no Construtor (IllegalArgumentException)
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("[ERRO] - O valor do saldo inicial não pode ser negativo!");
        }
    }


//================= Get e Set ==========================

    // Getters
    public String getNumero() { return numero; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    // Setters
    public void setTitular(String titular) { this.titular = titular; }
    // Não há setNumero() conforme boa prática (número da conta não muda)

//================= Métodos de Registro e Operação ==========================

    // Método para registrar uma transação (Usado internamente)
    protected void registrarTransacao(String tipo, double valor) {
        // Assume que a classe Transacao está definida corretamente
        Transacao novaTransacao = new Transacao(tipo, valor);
        this.historicoTransacoes.add(novaTransacao);
    }

    // Depositar (Implementação concreta na classe base)
    public void depositar(double valor) {

        if (valor <= 0) { // Simplificado para capturar zero e negativos
            throw new IllegalArgumentException("[ERRO] - O valor depositado deve ser positivo!");
        } else {
            this.saldo += valor;
            registrarTransacao("DEPOSITO", valor);
            System.out.println("Sucesso - Um depósito de R$" + valor + " foi realizado!");
            System.out.println("Novo Saldo: R$" + this.saldo);
        }
    } // Fim do método depositar

    // Sacar (Método Abstrato - Deve ser implementado na subclasse)
    public abstract void sacar(double valor) throws SaldoInsuficienteException;

    // Método para visualizar o histórico
    public List<Transacao> getHistoricoTransacoes() {
        return this.historicoTransacoes;
    }
}