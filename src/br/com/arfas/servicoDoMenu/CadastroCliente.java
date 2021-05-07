package br.com.arfas.servicoDoMenu;

import br.com.arfas.cliente.Cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CadastroCliente {
    
    public CadastroCliente(){}
	
	BufferedReader cadastroCli = new BufferedReader(new InputStreamReader(System.in));
	
    public Cliente CadastrarCliente(Cliente cliente) throws IOException {
        while (true) {
            System.out.println("DIGITE : '1' PARA CADASTRAR PESSOA FISICA (CPF)");
            System.out.println("DIGITE : '2' PARA CADASTRAR PESSOA JURIDICA (CNPJ)");
            String str = cadastroCli.readLine();
            switch (str) {
                case "1":
                    cliente.criaClientecpf(cliente);     
                    System.out.println("SEJA BEM VINDO: "+cliente.getNomeCompleto());
                    break;             
                case "2":
                    cliente.criaClientecnpj(cliente);
                    System.out.println("SEJA BEM VINDO: "+cliente.getNomeCompleto());
                    break;              
                default: {
                    System.out.println("Opcao Invalida tente novamente");
                }
            }
        break;
        }
		return cliente;
    }
}
