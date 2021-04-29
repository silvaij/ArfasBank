package br.com.arfas.tipoDeContas;

public abstract class Conta {
    protected String  banco;
    protected String numeroAgencia;
    protected String numeroConta;
    protected Double  saldo;
    
    public abstract double depositar(double valor);
    
    public abstract double transfere(double valor) ;
    
    public abstract double sacar(double valor);
    
    public String getBanco() {
    	return banco;
    }
    
    public void setBanco(String banco) {
    	this.banco = banco;
    }

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public abstract Double getSaldo();

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
    
    public Conta (String  banco, String numeroAgencia, String numeroConta, Double saldo) {
    	super();
    	this.banco = banco;
    	this.numeroAgencia = numeroAgencia;
    	this.numeroConta = numeroConta;
    	this.saldo = saldo;   	
    }
    	
}
