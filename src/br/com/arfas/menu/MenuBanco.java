package br.com.arfas.menu;


import br.com.arfas.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuBanco {

    Map<Integer,String> nomesDeBanco = new HashMap<Integer,String>();
    BufferedReader opcao = new BufferedReader(new InputStreamReader(System.in));
    String opcaoUsuario=null;

    public String selecionarNomeDoBanco() throws IOException{
        //Coleção de nomes de banco
        nomesDeBanco.put(1,"Banco do Brasil");
        nomesDeBanco.put(2,"Bradesco");
        nomesDeBanco.put(3,"Santander Brasil");
        nomesDeBanco.put(4,"Caixa Economica Federal");
        nomesDeBanco.put(5,"BTG Pactual");
        nomesDeBanco.put(6,"Safra");
        nomesDeBanco.put(7,"Sicoob");
        nomesDeBanco.put(8,"Banco Votorantim");
        nomesDeBanco.put(9,"Citibank");
        nomesDeBanco.put(10,"Banrisul");
        nomesDeBanco.put(11,"Banco do Nordeste");
        nomesDeBanco.put(12,"Itau Unibanco");

        while(true){
            System.out.println("ESCOLHA O BANCO : ");
            // linha abaixo imprimindo a colecao para o cliente
            nomesDeBanco.forEach((key,value) -> System.out.println(" DIGITE " + key +" - "+value ));
            // linha abaixo captura entrada do usuario
            opcaoUsuario = opcao.readLine();

            String regex = "\\b([0-9]{1,2})";// intervalo mais o tamanho neste caso intervalo 0-9 e 1 ou 2 digitos
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(opcaoUsuario);

            if(StringUtils.isEmpty(opcaoUsuario)) {
                  System.out.println("OPCAO INVALIDA TENTE NOVAMENTE ");
                  selecionarNomeDoBanco();
                  break;
            }else if (!matcher.find()){
                System.out.println("OPCAO INVALIDA TENTE NOVAMENTE ");
                selecionarNomeDoBanco();
                break;
            }

            Integer chaveDaOpcao = Integer.parseInt(opcaoUsuario);

            if((chaveDaOpcao > 12)||(chaveDaOpcao<=0)){
                System.out.println("OPCAO INVALIDA TENTE NOVAMENTE ");
            }else{
                opcaoUsuario = nomesDeBanco.get(chaveDaOpcao);
                break;
            }
        }
        
        return opcaoUsuario;
    }

    public static boolean validaAgencia(String str) {
        String regex = "\\b([0-9]{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static boolean validaConta(String str) {
        String regex = "\\b([0-9]{5})-\\b([0-9]{1,2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static boolean validaTipoDeConta(String str){
        String regex = "\\b([1-3]{1})";
        Pattern padrao = Pattern.compile(regex);
        Matcher matcher = padrao.matcher(str);
        return matcher.find();
    }
}
