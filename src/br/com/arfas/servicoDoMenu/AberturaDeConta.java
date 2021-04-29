package br.com.arfas.servicoDoMenu;

import br.com.arfas.menu.MenuBanco;

import br.com.arfas.tipoDeContas.ContaCorrente;
import br.com.arfas.tipoDeContas.ContaPoupanca;
import br.com.arfas.tipoDeContas.ContaSalario;
import br.com.arfas.utils.Gerenciador;
import br.com.arfas.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import static br.com.arfas.menu.MenuBanco.validaAgencia;


public class AberturaDeConta {

	BufferedReader dadosDaConta = new BufferedReader(new InputStreamReader(System.in));
    ContaCorrente contaCorrente;
    ContaPoupanca contaPoupanca;
    ContaSalario contaSalario;

	public void abrirConta() throws IOException {
		MenuBanco menuBanco = new MenuBanco();
		String bancoEscolhido = menuBanco.selecionarNomeDoBanco();
		String numeroAgencia;
		String numeroConta;
		String tipoDeConta;
		System.out.println("O banco Escolhido foi : "+bancoEscolhido);// remover depois

		while (true){
			System.out.println("DIGITE NUMERO DA AGENCIA COM 4 DIGITOS EXEMPLO: '4071' ");
			numeroAgencia = dadosDaConta.readLine();
			boolean validaAgencia = validaAgencia(numeroAgencia);
			if((StringUtils.isEmpty(numeroAgencia))||(!validaAgencia)) {
				System.out.println("OPCAO INVALIDA TENTE NOVAMENTE ");
			}else {
				System.out.println("AGENCIA REGISTRADA COM SUCESSO");
				break;
			}
		}
		while (true){
			System.out.println("DIGITE NUMERO DA CONTA COM 5 DIGITOS MAIS O DIGITO VERIFICADOR EXEMPLO : '23099-01'");
			numeroConta = dadosDaConta.readLine();
			boolean validaConta = MenuBanco.validaConta(numeroConta);
			if((StringUtils.isEmpty(numeroConta))||(!validaConta)) {
				System.out.println("OPCAO INVALIDA TENTE NOVAMENTE ");
			}else {
				System.out.println("CONTA REGISTRADA COM SUCESSO");
				break;
			}
		}
		while(true) {
			System.out.println("-- QUAL TIPO DA CONTA ? : ");
			System.out.println("DIGITE NUMERO -> 1 - PARA ATRIBUIR (** CONTA CORRENTE **) ");
			System.out.println("DIGITE NUMERO -> 2 - PARA ATRIBUIR (** CONTA POUPANÇA **) ");
			System.out.println("DIGITE NUMERO -> 3 - PARA ATRIBUIR (** CONTA SALARIO **) ");
			tipoDeConta = dadosDaConta.readLine();
			boolean validaTipoDeConta = MenuBanco.validaTipoDeConta(tipoDeConta);
			if((StringUtils.isEmpty(tipoDeConta))||(!validaTipoDeConta)){
				System.out.println("TIPO DE CONTA INVALIDA");
			}else{
				int validador = Integer.parseInt(tipoDeConta);
				if(validador == 1){
					contaCorrente = new ContaCorrente(bancoEscolhido,numeroAgencia,numeroConta,0.0,1000.00);
					System.out.println("DADOS DA CONTA ABERTA:");
					System.out.println(contaCorrente.toString());
					Gerenciador armazem = new Gerenciador();
					armazem.adicionaConta(contaCorrente);
					break;
				}
				if(validador == 2){
					contaPoupanca = new ContaPoupanca(bancoEscolhido,numeroAgencia,numeroConta,0.0,10L);
					System.out.println("DADOS DA CONTA ABERTA:");
					System.out.println(contaPoupanca.toString());
					Gerenciador armazem = new Gerenciador();
					armazem.adicionaConta(contaPoupanca);
					break;
				}else{
					contaSalario = new ContaSalario(bancoEscolhido,numeroAgencia,numeroConta,0.0,3);
					System.out.println("DADOS DA CONTA ABERTA:");
					System.out.println(contaSalario.toString());
					Gerenciador armazem = new Gerenciador();
					armazem.adicionaConta(contaSalario);
					break;
				}
			}
		}
	}


}
