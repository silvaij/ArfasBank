package br.com.arfas.utils;



import br.com.arfas.tipoDeContas.Conta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Gerenciador {

    List<Conta> listaDeConta = new ArrayList<>();
    
	public static void clearConsole() throws InterruptedException, IOException  {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
	}
}
