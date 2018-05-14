/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.prova;

import java.util.ArrayList;

/**
 *Classe Empresa
 * @author denis
 * @version 2.0
 */
public class Empresa {
    
     /**
     * Atributo nome é do tipo String e é responsável por armazenar o nome da
     * Empresa.
     */
    private String nome;
    
    /**
     * Atributo orcamentos é uma lista de Orcamento e é responsável por
     * armazenar os orcamentos da Empresa.
     */
    private ArrayList<Orcamento> orcamento;
    
    /**
     * Atributo planoDeContas é uma lista de PlanoDeContas e é responsável por
     * armazenar os planos de contas da Empresa.
     */
    private ArrayList<PlanoDeContas> planoDeContas;
    
    /**
     * Método construtor
     * @param nome
     * @param orcamento 
     */
    
    public Empresa(String nome,ArrayList<Orcamento> orcamento){
        this.nome = nome;
        this.orcamento = orcamento;
        
    }
    
     /**
     * Método que retorna o nome da Empresa.
     * @return o atributo {@link #nome}
     */
    public String getNome() {
        return nome;
    }
    
     /**
     * Método para atribuir valor ao atributo nome.
     * @param nome variável com String a ser inserida no atributo {@link #nome}
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método que retorna os orcamentos da Empresa.
     * @return o atributo {@link #orcamentos}
     */
    public ArrayList<Orcamento> getOrcamento() {
        return orcamento;
    }
    
    /**
     * Método para atribuir valor ao atributo orcamentos.
     * @param orcamentos variável com a lista de orcamentos a ser inserida no atributo {@link #orcamentos}
     */
    public void setOrcamento(ArrayList<Orcamento> orcamento) {
        this.orcamento = orcamento;
    }
    
    /**
     * Método que retorna os planos de contas da Empresa.
     * @return o atributo {@link #planoDeContas}
     */
    public ArrayList<PlanoDeContas> getPlanoDeContas() {
        return planoDeContas;
    }
    
    
    /**
     * Método para atribuir valor ao atributo planoDeContas.
     * @param planoDeContas variável com a lista de planos de contas a ser inserida no atributo {@link #planoDeContas}
     */
    public void setPlanoDeContas(ArrayList<PlanoDeContas> planoDeContas) {
        this.planoDeContas = planoDeContas;
    }
    
    
    
}
