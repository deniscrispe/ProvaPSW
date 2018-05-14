/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.prova;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
@WebServlet(name = "RegistraServlet", urlPatterns = {"/RegistraServlet"})
public class RegistraServlet extends HttpServlet {
    boolean achou = false;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        boolean formValido = true;
               
        
        String codigo = req.getParameter("codigo").trim();
        float valorRealizado = 0;
        
                  
            if (codigo.isEmpty()){
                req.setAttribute("msgErroCodigo", "Este campo é obrigatório");
                formValido = false;
                String validadeCodigo = "is-invalid";
                req.setAttribute("validadeCodigo", validadeCodigo);
            }else{
                String validadeCodigo= "is-valid";
                req.setAttribute("validadeCodigo", validadeCodigo);
            }            
            
        try {
                        
            if (req.getParameter("valorRealizado").trim().isEmpty()){
                req.setAttribute("msgErroValorRealizado", "Este campo é obrigatório");
                formValido = false;
                String validadeValorRealizado = "is-invalid";
                req.setAttribute("validadeValorRealizado", validadeValorRealizado);
            }else{
                valorRealizado = Float.parseFloat(req.getParameter("valorRealizado").trim());
                String validadeValorRealizado= "is-valid";
                req.setAttribute("validadeValorRealizado", validadeValorRealizado);
            }
            
            if(valorRealizado < 0){
                req.setAttribute("msgErroValorRealizado", "O valor realizado deve ser de ponto flutuante positivo");
                formValido = false;
                String validadeValorRealizado = "is-invalid";
                req.setAttribute("validadeValorRealizado", validadeValorRealizado);
                
            }
            
        } catch (NumberFormatException e) {
            req.setAttribute("msgErroValorRealizado", "O valor realizado deve ser de ponto flutuante positivo");
            formValido = false;
            String validadeValorRealizado = "is-invalid";
            req.setAttribute("validadeValorRealizado", validadeValorRealizado);
        }
        
        
        
        Orcamento o = (Orcamento)req.getServletContext().getAttribute("orcamento");
        if (formValido) {
            for(ContaOrcamento c: o.getContas()){
                if(c.getCod().equals(codigo+".")){
                    c.setValorRealizado(valorRealizado);
                    achou = true;                   
                }
                procuraSub(c,codigo,valorRealizado);
            }
            
            
        }
        
        if(formValido && !achou){
                req.setAttribute("msgErroCodigo", "Código não encontrado");
                String validadeCodigo = "is-invalid";
                req.setAttribute("validadeCodigo", validadeCodigo);
            }
        
       req.getRequestDispatcher("form.jsp").forward(req, resp);
        
        
    }
    
    public void procuraSub(ContaOrcamento c, String codigo,float valorRealizado){
        if(c.possuiSubConta()){
            for(ContaOrcamento x : c.getSubContasO()){
                if(x.getCod().equals(codigo+".")){
                    x.setValorRealizado(valorRealizado);
                    achou = true;                    
                }
                procuraSub(x, codigo, valorRealizado);
            }
        }
    }

}
