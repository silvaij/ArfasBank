package br.com.arfas.tipoDeContas;

public interface Tributavel {

	public default double getImposto(double valor) {
		double valorDoImposto = valor*0.38;
		return valorDoImposto ;
	}
	
}
