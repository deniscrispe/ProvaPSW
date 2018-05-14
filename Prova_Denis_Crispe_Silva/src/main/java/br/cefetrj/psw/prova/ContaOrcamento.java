/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.prova;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe ContaOrcamento
 * @author denis
 * @vesion 2.0
 */
public class ContaOrcamento extends Conta {
    
    private String nome;
     /**
     * Atributo valorOrcado é do tipo double e é responsável por armazenar o valor orçado da ContaOrcamento.
     */
    private double valorOrcado;
    /**
     * Atributo valorRealizado é do tipo double e é responsável por armazenar o valor realizado da ContaOrcamento.
     */
    private double valorRealizado;
    /**
     * Atributo valorComprometido é do tipo double e é responsável por armazenar o valor comprometido da ContaOrcamento.
     */
    private double valorComprometido;
    /**
     * Atributo subContas é uma lista de ContaOrcamento e é responsável por armazenar as subcontas da ContaOrcamento.
     */
    private ArrayList<ContaOrcamento> subContas = null;
    /**
     * Atributo cod é do tipo String e é responsável por armazenar o todo o código da ContaOrcamento.
     */
    private String cod;
    
    
   
    /**
     * Método construtor
     * @param nome
     * @param valorOrcado
     * @param valorRealizado
     * @param valorComprometido 
     */
    public ContaOrcamento(String nome,float valorOrcado, float valorRealizado, float valorComprometido){
       super();
       this.nome = nome;
       this.valorComprometido = valorComprometido;
       this.valorOrcado = valorOrcado;
       this.valorRealizado = valorRealizado;
    
    }
    
    /**
     * Método que retorna o nome da ContaOrcamento
     * @return o atributo {@link #nome}
     */
    public String getNome() {
        return this.nome;
    }  
      
     
    /**
     * Método que retorna o valor orçado da ContaOrcamento.
     * @return o atributo {@link #valorOrcado}
     */
    
    public double getValorOrcado(){        
            if(this.possuiSubConta()){
            double valor=0;
            for(ContaOrcamento a: subContas){
                valor+=a.getValorOrcado();
            }
            return valor;
        }else{    
        return valorOrcado;
        }  
        
    }
    
    /**
     * Método que retorna o valor realizado da ContaOrcamento.
     * @return o atributo {@link #valorRealizado}
     */
    
    public double getValorRealizado(){        
          if(this.possuiSubConta()){
            double valor=0;
            for(ContaOrcamento a: subContas){
                valor+=a.getValorRealizado();
            }
            return valor;
        }else{    
        return valorRealizado;
        }  
        
    }
    
    /**
     * Método que retorna o valor comprometido da ContaOrcamento.
     * @return o atributo {@link #valorComprometido}
     */
    
    public double getValorComprometido(){
        if(this.possuiSubConta()){
            double valor=0;
            for(ContaOrcamento a: subContas){
                valor+=a.getValorComprometido();
            }
            return valor;
        }else{    
        return valorComprometido;
        }      
    }
    
    /**
     * Método que retorna o valor disponivel da ContaOrcamento.
     * @return valorDisponivel
     */
    
    public double getValorDisponivel(){
        
            return this.getValorOrcado() - this.getValorComprometido() - this.getValorRealizado();
    }
    
    /**
     * Método que retorna uma lista de subContaOrcamento.
     * @return o atributo {@link #subContasOrcamento}
     */

    public ArrayList<ContaOrcamento> getSubContasO() {
        return subContas;
    }
    
    /**
     * Método para atribuir valor ao atributo subContasOrcamento.
     * @param subContas  variável com a lista de subContasOrcamento a ser inserida no atributo {@link #subContasOrcamento}
     */

    public void setSubContasO(ArrayList<ContaOrcamento> subContas) {
        this.subContas = subContas;
    }
    
    /**
     * Método para saber se a ContaOrcamento possui sub contas.
     * @return boolean
     */
    public boolean possuiSubConta () {
        if (this.subContas == null) {
            return false;
        }else {
            return true;
        }
        
    }
    
    /**
     * Método para atribuir valor ao atributo valorRealizado.
     * @param valorRealizado  variável com o valor relizado a ser inserida no atributo {@link #valorRealizado}
     */
    public void setValorRealizado(double valorRealizado) {
        this.valorRealizado = valorRealizado;
    }
    
     /**
     * Método que retorna o código da ContaOrcamento.
     * @return  atributo {@link #cod}
     */
    public String getCod() {
        return cod;
    }
    
    /**
     * Método para atribuir valor ao atributo cod.
     * @param cod  variável com o valor relizado a ser inserida no atributo {@link #cod}
     */
    public void setCod(String cod) {
        this.cod = cod;
    }
   
}
