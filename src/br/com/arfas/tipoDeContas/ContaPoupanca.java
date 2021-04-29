package br.com.arfas.tipoDeContas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContaPoupanca extends Conta {

	private Long diaAniversario;
	private double taxaDeJuros=0.05;

	public ContaPoupanca(String banco, String numeroAgencia, String numeroConta, Double saldo, Long diaAniversario) {
		super(banco, numeroAgencia, numeroConta, saldo);
		this.diaAniversario = diaAniversario;		
		verificaAniversario();
	}

	public double verificaAniversario() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd");
		LocalDate hoje = LocalDate.now();
		String dataEmString = hoje.format(formato);
		Integer converteDia = Integer.valueOf(dataEmString);

		if ((this.diaAniversario != 0) && (this.diaAniversario <= 31)) {
			if (this.diaAniversario >= converteDia) {
				saldo = (saldo * taxaDeJuros) + saldo;
			}
		} else {
			System.out.println("Dia inv�lido");
		}

		return saldo;
	}

	@Override
	public Double getSaldo() {
		return this.saldo;
	}

	@Override
	public double depositar(double value) {
		if (value > 0) {
			saldo += value;
		} else {
			System.out.println("Valor invalido");
		}
		return saldo;
	}

	@Override
	public double sacar(double value) {
		if (value <= saldo) {
			saldo -= value;
		} else {
			System.out.println("Saldo insuficiente verfique seu saldo");
		}
		return saldo;
	}

	@Override
	public double transfere(double value) {
		if (value <= saldo) {
			saldo -= value;
			System.out.println("Transferido o valor de R$"+" "+value);
		} else {
			System.out.println("Saldo insuficiente verfique seu saldo");
		}
		return saldo;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [diaAniversario=" + diaAniversario + ", taxaDeJuros=" + taxaDeJuros + ",banco=" + banco + ", numeroAgencia=" + numeroAgencia + ", \"\r\n"
				+ "			+ numeroConta= " + numeroConta + ",saldo = " + saldo + "]";
	}
	
}
