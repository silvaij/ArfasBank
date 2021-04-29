package br.com.arfas.utils;

public class StringUtils {
    public static boolean isEmpty(String str){
        if (str == null){
            return true;
        }
        return str.trim().length() == 0;
    }

    public static void main(String[] args) {
        String teste = "";
        boolean strTeste = StringUtils.isEmpty(teste);
        System.out.println(strTeste);
        System.out.println(teste.isEmpty());
    }
}
