package br.com.arfas.tipoDeContas;

public interface Tributavel {

	public default double getImposto(double saldoDaConta) {
		double valorDoImposto = saldoDaConta*0.38;
		return valorDoImposto ;
	}
	
}
