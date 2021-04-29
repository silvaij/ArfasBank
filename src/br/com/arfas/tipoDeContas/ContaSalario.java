package br.com.arfas.tipoDeContas;

public class ContaSalario extends Conta {
    private int limiteDeSaques;
    private static int count=0;
	public ContaSalario(String banco, String numeroAgencia, String numeroConta, Double saldo, int limiteDeSaques ) {
		super(banco, numeroAgencia, numeroConta, saldo);
		this.limiteDeSaques=limiteDeSaques;
	}

	@Override
	public double depositar(double valor) {
		if(valor>0){
			this.saldo+=valor;		
		}else {
			System.out.println("Valor invalido");
		}
		return saldo;
	}

	@Override
	public double transfere(double valor) {
		if(valor>0) {
			saldo+=valor;
			System.out.println("Transferido o valor de R$"+valor);
		}else {
			System.out.println("Valor invalido");
		}
		return saldo ;
	}

	@Override
	public double sacar(double valor) {
		if(valor>0&&count<limiteDeSaques){
			saldo-=valor;
			count++;
		}
		return saldo;
	}

	@Override
	public Double getSaldo() {		
		return this.saldo;
	}

	@Override
	public String toString() {
		return "ContaSalario [limiteDeSaques=" + limiteDeSaques + ", banco=" + banco + ", numeroAgencia="
				+ numeroAgencia + ", numeroConta=" + numeroConta + ", saldo=" + saldo + "]";
	}
	
}
