package br.com.arfas.servicoDoMenu;

import br.com.arfas.cliente.Cliente;
import br.com.arfas.utils.Gerenciador;
import br.com.arfas.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static br.com.arfas.cliente.Cliente.autenticaCliente;

public class SaqueMenu {


     public static void efetuaSaque() throws IOException {

         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         String doc ;
         String senha;

         System.out.println(" Digite o cpf no  *FORMATO* : XXX.XXX.XXX-XX  use o (' - ') no final");
         System.out.println(" OU ");
         System.out.println(" Digite o cnpj no *FORMATO* : XX.XXX.XXX/0001-XX use o (' / ') e (' - ') no final ");
         doc = input.readLine();

         System.out.println("'INFORME A SENHA :')");
         senha = input.readLine();

         autenticaCliente(doc,senha);
         if(cliente != null){
             System.out.println("SEJA BEM VINDO "+cliente.getNomeCompleto());
         }else{
             System.out.println("Cliente não cadastrado");
         }

     }
}
