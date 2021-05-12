package br.com.arfas.tipoDeContas;

public class ContaCorrente extends Conta implements Tributavel {

	private Double limiteDeCreditoPreAprov;
	
	public ContaCorrente(String banco, String numeroAgencia, String numeroConta, Double saldo, Double limiteDeCreditoPreAprov) {
		super(banco, numeroAgencia, numeroConta, saldo);
		this.limiteDeCreditoPreAprov = limiteDeCreditoPreAprov;	
		
	}
	
	@Override
	public double getImposto(double valor) {		
		return Tributavel.super.getImposto(valor);
	}
	
		
	@Override
	public Double getSaldo() {		
		saldo = saldo + limiteDeCreditoPreAprov;
		return saldo;
	}

	@Override
	public double depositar(double valor) {
		if((valor != 0.00)&&(valor > 0.00)){
			saldo+=valor;
		}else {
			System.out.println("Valor invalido");
		}
		return saldo;
	}

	@Override
	public double transfere(double valor) {
		if((valor != 0.00)&&(valor > 0.00)){
			saldo-=valor;
			System.out.println("Transferido"+" "+valor);
			System.out.println("Saldo Atual"+" "+saldo);
		}else {
			System.out.println("Valor invalido");
		}
		return saldo;
	}

	@Override
	public double sacar(double valor) {
		if((valor != 0.00)&&(valor > 0.00)){
			if(valor <= saldo) {
				saldo-=valor;
			}else {
				System.out.println("Saldo insuficiente!");
			}					
		}else {
			System.out.println("Valor invalido");
		}
		return saldo;
	}

	@Override
	public String toString() {
	 return "ContaCorrente [limiteDeCreditoPreAprov=" + limiteDeCreditoPreAprov + ", banco=" + banco + ", numeroAgencia=" + numeroAgencia + ", "
			+ "numeroConta= " + numeroConta + ",saldo = " + saldo + "]";
	}
	
	
}
