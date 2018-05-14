/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.prova;

import java.util.ArrayList;

/**
 * Classe PlanoDeContas
 * @author denis
 * @version 2.0
 */
public class PlanoDeContas {
    
    
    /**
     * Atributo nome é do tipo String e é responsável por armazenar o nome do Plano de contas.
     */
    private String nome;
    
    
    /**
     * Atributo contas é uma lista de contas e é responsável por armazenar as contas do PlanoDeContas.
     */
    private ArrayList<Conta> conta;
    
    /**
     * Método que retorna se o plano de contas é do tipo Orcamento ou não.
     * @return retorna verdadeiro se for um Orcamento e falso se nao for
     */
    public boolean isOrcamento() {
        if (this instanceof Orcamento) {
            return true;
        }
        return false;
    } 
    
}
