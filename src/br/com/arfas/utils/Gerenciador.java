package br.com.arfas.utils;


import br.com.arfas.cliente.Cliente;
import br.com.arfas.tipoDeContas.Conta;

import java.util.ArrayList;
import java.util.List;


public class Gerenciador {

    List<Conta> listaDeConta = new ArrayList<>();


    public void adicionaConta(Conta conta){
        listaDeConta.add(conta);
    }



  public Conta autenticaConta(String banco,String nConta, String nAgencia){
        int i ;
        for (i= 0 ; i<listaDeConta.size()-1;i++) {
          if(listaDeConta.get(i).getBanco().equals(banco)){
              if(listaDeConta.get(i).getNumeroConta().equals(nConta)){
                  if(listaDeConta.get(i).getNumeroAgencia().equals(nAgencia)){
                      break;
                  }else{
                      System.out.println("Esta conta nao existe");
                  }
              }else{
                  System.out.println("Esta conta nao existe");
              }
          }else{
              System.out.println("Esta conta nao existe");
          }
      }
      return  listaDeConta.get(i);
  }



}
