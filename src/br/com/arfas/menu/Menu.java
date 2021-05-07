package br.com.arfas.menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.arfas.cliente.Cliente;
import br.com.arfas.servicoDoMenu.AberturaDeConta;
import br.com.arfas.servicoDoMenu.CadastroCliente;
import br.com.arfas.servicoDoMenu.DepositoMenu;
import br.com.arfas.servicoDoMenu.TransfereMenu;
import br.com.arfas.tipoDeContas.Conta;
import br.com.arfas.utils.Gerenciador;

import static br.com.arfas.servicoDoMenu.SaqueMenu.efetuaSaque;

public class Menu {
	static List<Cliente> listaDeCliente = new ArrayList<>();
	static List<Conta> listaDeConta = new ArrayList<>();
	Cliente cliente = new Cliente();
	static Conta conta = null;
	static Conta contaDestino = null;
	Double valor;

	public static List<Cliente> getListaDeCliente() {
		return listaDeCliente;
	}

	public static List<Conta> getListaDeConta() {
		return listaDeConta;
	}

	public void imprimeMenu() throws Throwable {
		boolean repetidor = true;
		while (repetidor) {
			System.out.println(" ** BANCO ARFASBANK **");
			System.out.println("ESCOLHA A OPCAO : ");
			System.out.println("DIGITE '1' : Abrir Conta");
			System.out.println("DIGITE '2' : Cadastro do Cliente");
			System.out.println("DIGITE '3' : Depositar");
			System.out.println("DIGITE '4' : Sacar");
			System.out.println("DIGITE '5' : Transferir valores");
			System.out.println("DIGITE '6' : Mostrar montante disponivel nas contas");
			System.out.println("DIGITE '7' : Sair do sistema");
			BufferedReader menu = new BufferedReader(new InputStreamReader(System.in));
			String opcao = menu.readLine();

			switch (opcao) {
			case "1":
				System.out.println("ABERTURA DE CONTA");
				AberturaDeConta inicio = new AberturaDeConta();
				conta = inicio.abrirConta(conta);
				adicionaContaNaLista(conta);
				break;
			case "4":
				System.out.println("EFETUAR SAQUE");
				conta = efetuaSaque();
				try {
					if (!(conta == null)) {
						System.out.println("INFORME VALOR DO SAQUE");
						valor = Double.parseDouble(menu.readLine());
						conta.sacar(valor);
					}
				} catch (NumberFormatException e) {
					System.out.println("Valor incorreto");
				}
				break;
			case "3":
				System.out.println("EFETURAR DEPOSITO");
				conta = DepositoMenu.efetuaDeposito();
				try {
					if (!(conta == null)) {
						System.out.println("INFORME VALOR DE DEPOSITO");
						valor = Double.parseDouble(menu.readLine());
						conta.depositar(valor);
					}
				} catch (NumberFormatException e) {
					System.out.println("Valor incorreto");
				}
				break;
			case "2":
				System.out.println("CADASTRO CLIENTE");
				CadastroCliente novoCadastro = new CadastroCliente();
				cliente = novoCadastro.CadastrarCliente(cliente);
				adicionaClienteNaLista(cliente);
				break;
			case "5":
				System.out.println("TRANSFERENCIA");
				conta = TransfereMenu.retornaContaDeOrigem();
				contaDestino = TransfereMenu.retornaContaDeDestino();
				try {
					if (!(conta == null)) {
						System.out.println("INFORME VALOR DE DEPOSITO");
						valor = Double.parseDouble(menu.readLine());
						TransfereMenu.efetuaTransferencia(conta, contaDestino, valor);
					}
				} catch (NumberFormatException e) {
					System.out.println("Valor incorreto");
				}
				break;
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

	public static void adicionaClienteNaLista(Cliente cliente) {
		listaDeCliente.add(cliente);
	}

	public static boolean autenticaCliente(String doc, String senha) {
		boolean autenticado = false;
		if (!listaDeCliente.isEmpty()) {
			int cont;
			for (cont = 0; cont <= listaDeCliente.size() - 1; cont++) {
				boolean validadorDoc = listaDeCliente.get(cont).getDoc().equals(doc);// pegando a conta da lista e
																						// comparando com que foi
																						// digitado
				boolean validadorPass = listaDeCliente.get(cont).getSenha().equals(senha);
				if (((validadorDoc) && (validadorPass))) {
					System.out.println("Seja Bem Vindo " + listaDeCliente.get(cont).getNomeCompleto());
					System.out.println("SELECIONE SEU BANCO :");
					autenticado = true;
					break;
				} else if (cont == listaDeCliente.size() - 1) {
					System.out.println("Documento e senha invalidos");
					autenticado = false;
				}
			}
		} else {
			System.out.println("Nenhum cliente cadastrado");
			autenticado = false;
		}
		return autenticado;
	}

	public static void adicionaContaNaLista(Conta conta) {
		listaDeConta.add(conta);
	}

	public static Conta autenticaConta(String banco, String nAgencia, String nConta) {
		if (!listaDeConta.isEmpty()) {
			int cont;
			for (cont = 0; cont <= listaDeConta.size() - 1; cont++) {
				boolean validadorBanco = listaDeConta.get(cont).getBanco().equals(banco);
				boolean validadorNAgencia = listaDeConta.get(cont).getNumeroAgencia().equals(nAgencia);
				boolean validadorNConta = listaDeConta.get(cont).getNumeroConta().equals(nConta);
				if (((validadorBanco) && (validadorNAgencia)) && (validadorNConta)) {
					break;
				} else if (cont == listaDeConta.size() - 1) {
					System.out.println("AGENCIA E CONTA INVALIDOS TENTE NOVAMENTE");
				}
			}
		} else {
			System.out.println("Nenhuma conta cadastrada");
		}
		return conta;
	}

}
