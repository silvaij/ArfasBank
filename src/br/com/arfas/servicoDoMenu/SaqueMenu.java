package br.com.arfas.servicoDoMenu;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.arfas.menu.Menu;
import br.com.arfas.menu.MenuBanco;
import br.com.arfas.tipoDeContas.Conta;

public class SaqueMenu {
     public static Conta efetuaSaque() throws IOException {
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         String doc ;
         String senha;
         String banco;
         String numeroAgencia = null;
         String numeroConta;
         boolean auxiliar;
         MenuBanco escolhaDoBanco = new MenuBanco();
        
         System.out.println(" Digite o cpf no  *FORMATO* : XXX.XXX.XXX-XX  use o (' - ') no final");
         System.out.println(" OU ");
         System.out.println(" Digite o cnpj no *FORMATO* : XX.XXX.XXX/0001-XX use o (' / ') e (' - ') no final ");
         doc = input.readLine();

         System.out.println(" ('INFORME A SENHA :') ");
         senha = input.readLine();
         
         auxiliar = Menu.autenticaCliente(doc, senha);
         
         if(auxiliar){    	 
             banco = escolhaDoBanco.selecionarNomeDoBanco();      
             System.out.println("Digite numero da Agencia");
             numeroAgencia = input.readLine();            
             System.out.println("Digite numero da Conta ");
             numeroConta = input.readLine(); 
             return Menu.autenticaConta(banco,numeroAgencia,numeroConta);
         }else {
        	 System.out.println("CPF ou SENHA inválido tente novamente");
         }
		       
         return null;
     }        
        
}
