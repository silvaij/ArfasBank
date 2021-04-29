package br.com.arfas.cliente;

import br.com.arfas.utils.Gerenciador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
     private String nomeCompleto;
     private String cpf;
     private String cnpj;
     private String senha ;
     private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 public static List<Cliente> listaDeCliente = new ArrayList<>();


    public  Cliente(){};

    public Cliente (String nomeCompleto,String doc,String senha) {
    	 this.nomeCompleto = nomeCompleto;
    	 this.cpf = doc;
    	 this.cnpj= doc;
    	 this.senha=senha;
     }

     public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"nomeCompleto='" + nomeCompleto + '\'' +
				", cpf='" + cpf + '\'' +
				", cnpj=" + cnpj +
				", senha='" + senha + '\'' +
				'}';
	}

	public Cliente criaClientecpf() throws IOException {
		while (true){
			System.out.println(" Digite o nome completo exemplo -> : 'João Francisco da Silva' ");
			nomeCompleto = input.readLine();
			boolean verificaNome = validaNomeCompleto(nomeCompleto);
			if ((nomeCompleto.isEmpty()) || (!verificaNome)) {
				System.out.println("Nome Invalido !.Digite novamente");
			}else{
				while(true) {
					System.out.println(" Digite o cpf no formato : XXX.XXX.XXX-XX  use o (' - ') no final");
					cpf = input.readLine();
					boolean verificaCpf = validaCpf(cpf);
					if (cpf.isEmpty() || !verificaCpf) {
						System.out.println("CPF Invalido !.Digite novamente");
					}else{
						while(true){
							System.out.println("Digite uma senha numerica de 4 digitos exemplo: '9050'");
							senha = input.readLine();
							boolean verificaSenha = validaSenha(senha);
							if (senha.isEmpty() || !verificaSenha) {
								System.out.println("Senha Invalida !.Digite novamente");
							}else{
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}//fim do primeiro laço
		Cliente cliente = new Cliente(nomeCompleto,cpf,senha);
		return cliente;
	}

	public Cliente criaClientecnpj() throws IOException {
		while (true){
			System.out.println(" Digite o nome da empresa exemplo: 'Mutante Tecnologia ltda' ");
			nomeCompleto = input.readLine();
			boolean verificaNome = validaNomeCompleto(nomeCompleto);
			if (nomeCompleto.isEmpty() || !verificaNome) {
				System.out.println("Nome da empresa invalido !.Digite novamente");
			}else{
				while(true) {
					System.out.println(" Digite o cnpj no *FORMATO* :' XX.XXX.XXX/0001-XX ' ");
					cnpj = input.readLine();
					boolean verificaCnpj = validaCnpj(cnpj);
					if (cnpj.isEmpty() || !verificaCnpj) {
						System.out.println(" Cnpj Invalido !.Digite novamente");
					}else{
						while(true){
							System.out.println("Digite uma senha numerica de 4 digitos exemplo: '9050'");
							senha = input.readLine();
							boolean verificaSenha = validaSenha(senha);
							if (senha.isEmpty() || !verificaSenha) {
								System.out.println("Senha Invalida !.Digite novamente");
							}else{
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}//fim do primeiro laço
		Cliente cliente = new Cliente(nomeCompleto,cnpj,senha);
		return cliente;
	}

	public static boolean validaNomeCompleto(String nome){
     	String regexNome = "\\b([a-zA-Z])";
     	Pattern padrao = Pattern.compile(regexNome);
     	Matcher combine = padrao.matcher(nome);
     	return combine.find();
	}

	public static boolean validaCpf(String cpf){
		String regexNome = "\\b([0-9]{3})\\.([0-9]{3})\\.([0-9]{3}\\-([0-9]{1,2}))";
		Pattern padrao = Pattern.compile(regexNome);
		Matcher combine = padrao.matcher(cpf);
		return combine.find();
	}

	public static boolean validaCnpj(String cnpj){
		String regexNome = "\\b([0-9]{2})\\.([0-9]{3})\\.([0-9]{3}\\/([0001]{4})\\-([0-9]{2}))";
		Pattern padrao = Pattern.compile(regexNome);
		Matcher combine = padrao.matcher(cnpj);
		return combine.find();
	}

	public static boolean validaSenha(String senha){
		String regexNome = "\\b([0-9]{4})";
		Pattern padrao = Pattern.compile(regexNome);
		Matcher combine = padrao.matcher(senha);
		return combine.find();
	}

	public static boolean autenticaCliente(String doc,String senha){
		int cont ;
		for(cont = 0 ; cont<=listaDeCliente.size()-1; cont++){
			boolean validadorDocCpf = listaDeCliente.get(cont).getCpf().equals(doc);
			boolean validadorDocCnpj = listaDeCliente.get(cont).getCnpj().equals(doc);
			boolean validadorPass = listaDeCliente.get(cont).getSenha().equals(senha);
			if(((validadorDocCpf)&&(validadorPass))||((validadorDocCnpj)&&(validadorPass))){
				return true;
			}
		}
		return false;
	}

	public void adicionaClienteNaLista(Cliente cliente){
    	listaDeCliente.add(cliente);
	}

}
//