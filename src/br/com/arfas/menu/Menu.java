package br.com.arfas.menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import br.com.arfas.servicoDoMenu.AberturaDeConta;
import br.com.arfas.servicoDoMenu.CadastroCliente;

import static br.com.arfas.servicoDoMenu.SaqueMenu.efetuaSaque;

public class Menu {

	public void imprimeMenu() throws Throwable {
		boolean repetidor = true;
		while (repetidor) {
			System.out.println(" ** BANCO ARFASBANK **");
			System.out.println("ESCOLHA A OPCAO : ");
			System.out.println("DIGITE '1' : Abrir Conta");
			System.out.println("DIGITE '2' : Sacar");
			System.out.println("DIGITE '3' : Depositar");
			System.out.println("DIGITE '4' : Cadastro do Cliente");
			System.out.println("DIGITE '5' : Transferir valores");
			System.out.println("DIGITE '6' : Mostrar montante disponível nas contas");
			System.out.println("DIGITE '7' : Sair do sistema");

			BufferedReader menu = new BufferedReader(new InputStreamReader(System.in));
			String opcao = menu.readLine();

			switch (opcao) {
				case "1":
					System.out.println("ABERTURA DE CONTA");
					AberturaDeConta conta  = new AberturaDeConta();
					conta.abrirConta();
					break;
				case "2":
					System.out.println("EFETUAR SAQUE");
					efetuaSaque();
					break;
				case "3":
					System.out.println("EFETURAR DEPOSITO");
					break;
				case "4":
					System.out.println("CADASTRO CLIENTE");
					CadastroCliente novoCadastro = new CadastroCliente();
					novoCadastro.CadastrarCliente();
					break;
				case "5":
					System.out.println("TRANSFERENCIA");
				case "6":
					System.out.println("MOSTRAR MONTANTE DISPONIVEL NAS CONTAS");
				case "7":
					System.out.println("########################");
					System.out.println("########################");
					System.out.println("SAINDO DO SISTEMA.....");
					System.exit(0);
					break;
				default: {
					System.out.println();
					System.out.println();
					System.out.println("OPCAO INVALIDA");
				}
			}
		}
	}
}
