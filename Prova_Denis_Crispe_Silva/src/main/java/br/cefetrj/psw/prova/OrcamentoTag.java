/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.prova;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author denis
 */
public class OrcamentoTag extends SimpleTagSupport {
    
    private ContaOrcamento conta;
    
    private String info;
    
    /***
     * Método que faz uma tag e imprime no JSP
     * @throws JspException para indicar que ocorreu um erro durante o processamento dessa tag.
     * @throws IOException se um erro de entrada ou saída for detectado.
     */
    
    
    public void setConta(ContaOrcamento conta) {
        
        this.conta = conta;
    }

    public ContaOrcamento getConta() {
        return conta;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    

    public void doTag() throws JspException, IOException {
        String info = "<tr>" + 
                        "<th>"+conta.getCodigo() +". "+ conta.getNome()+"</th>" +
                        "<td>"+conta.getValorOrcado()+"</td>" + 
                        "<td>"+conta.getValorRealizado()+"</td>" + 
                        "<td>"+conta.getValorComprometido()+"</td>" + 
                        "<td>"+conta.getValorDisponivel()+"</td>" +
                    "</tr>";
        
        conta.setCod(String.valueOf(this.conta.getCodigo()) + ".");
        getJspContext().getOut().print(info);
        if (this.conta.possuiSubConta()) {
            String codigo = String.valueOf(this.conta.getCodigo()) + ".";
            for (int i = 0; i < this.conta.getSubContasO().size(); i++) {
                print(this.conta.getSubContasO().get(i), codigo);
                
            }
            
            
        }else {
            System.out.println("A conta não possui subcontas");
            
        }
        
        
        
        
    }
    
    public void print(ContaOrcamento sconta,String codigo) throws JspException, IOException{
       codigo = codigo + String.valueOf(sconta.getCodigo())+ ".";
       sconta.setCod(codigo);
       
       String info2 = "<tr>" + 
                        "<th>"+codigo+" "+sconta.getNome()+"</th>" +
                        "<td>"+sconta.getValorOrcado()+"</td>" + 
                        "<td>"+sconta.getValorRealizado()+"</td>" + 
                        "<td>"+sconta.getValorComprometido()+"</td>" + 
                        "<td>"+sconta.getValorDisponivel()+"</td>" +
                    "</tr>";
       getJspContext().getOut().print(info2);
       if (sconta.possuiSubConta()) {
            for (int i=0; i < sconta.getSubContasO().size(); i++) {
                print(sconta.getSubContasO().get(i), codigo);
            }
            
        }else {
            System.out.println("Não possui mais subContas.");
            
        }
        
       
        
    }  
}
