/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.prova;

import java.util.ArrayList;

/**
 * Classe Orcamento
 * @author denis
 * @version 2.0
 */
public class Orcamento extends PlanoDeContas {
    
    /**
     * Atributo ano é do tipo int e é responsável por armazenar o ano do Orcamento.
     */
    private int ano;
    
    /**
     * Atributo ano é uma lista de ContaOrcamento e é responsável por armazenar as contas do Orcamento.
     */
    private ArrayList<ContaOrcamento> contaOrcamento = null;
    
    
    /**
     * Método construtor
     * @param ano
     * @param contaOrcamento 
     */
    public Orcamento(int ano,ArrayList<ContaOrcamento> contaOrcamento){
        this.ano = ano;
        this.contaOrcamento = contaOrcamento;
    }
    
     /**
     * Método que retorna as contas do Orcamento.
     * @return o atributo {@link #contaOrcamento}
     */
    public ArrayList<ContaOrcamento> getContas(){
        return contaOrcamento;
        
    }
    
}
