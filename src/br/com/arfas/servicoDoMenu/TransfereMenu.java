package br.com.arfas.servicoDoMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.arfas.menu.Menu;
import br.com.arfas.menu.MenuBanco;
import br.com.arfas.tipoDeContas.Conta;

public class TransfereMenu {
	public static void efetuaTransferencia(Conta origem, Conta destino , Double valor) throws IOException {
		origem.transfere(valor);
		destino.depositar(valor);	
	}
		
	public static Conta retornaContaDeOrigem() throws Throwable {
		String banco;
		String numeroAgencia = null;
		String numeroConta;
		MenuBanco escolhaDoBanco = new MenuBanco();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("SELECIONE SEU BANCO");
		banco = escolhaDoBanco.selecionarNomeDoBanco();
		System.out.println("Digite numero da Agencia");
		numeroAgencia = input.readLine();
		System.out.println("Digite numero da Conta ");
		numeroConta = input.readLine();
		return Menu.autenticaConta(banco, numeroAgencia, numeroConta);
	}
	
    public static Conta retornaContaDeDestino() throws Throwable {
    	String banco;
		String numeroAgencia = null;
		String numeroConta;
		MenuBanco escolhaDoBanco = new MenuBanco();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("SELECIONE O BANCO PARA QUAL DESEJA TRANSFERIR");
		banco = escolhaDoBanco.selecionarNomeDoBanco();
		System.out.println("Digite numero da Agencia");
		numeroAgencia = input.readLine();
		System.out.println("Digite numero da Conta ");
		numeroConta = input.readLine();
		return Menu.autenticaConta(banco, numeroAgencia, numeroConta);
	}
}
