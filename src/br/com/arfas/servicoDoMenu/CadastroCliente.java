package br.com.arfas.servicoDoMenu;

import br.com.arfas.cliente.Cliente;
import br.com.arfas.tipoDeContas.Conta;
import br.com.arfas.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static br.com.arfas.menu.MenuBanco.validaAgencia;

public class CadastroCliente {

    //cpf e numero da Conta
    HashMap<String,String> clienteConta = new HashMap<String,String>();
    BufferedReader cadastroCli = new BufferedReader(new InputStreamReader(System.in));

    public void CadastrarCliente() throws IOException {
        while (true) {
            System.out.println("DIGITE : '1' PARA CADASTRAR PESSOA FISICA (CPF)");
            System.out.println("DIGITE : '2' PARA CADASTRAR PESSOA JURIDICA (CNPJ)");
            Cliente cliente = new Cliente();
            String str = cadastroCli.readLine();
            switch (str) {
                case "1":
                    cliente.criaClientecpf().adicionaClienteNaLista(cliente);
                    System.out.println("SEJA BEM VINDO: "+cliente.toString());
                    break;
                case "2":
                    cliente.criaClientecnpj().adicionaClienteNaLista(cliente);
                    System.out.println("SEJA BEM VINDO: "+cliente.toString());
                    break;
                default: {
                    System.out.println("Opcao Invalida tente novamente");
                }
            }
        break;
        }


    }
}
