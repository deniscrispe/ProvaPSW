/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.prova;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
@WebServlet("/BuscaServlet")
public class BuscaServlet extends HttpServlet {


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
        
        ContaOrcamento gerais = new ContaOrcamento("Despesas Gerais",20000, 5000, 3000);
        gerais.setCodigo(1);
        ContaOrcamento vendedores = new ContaOrcamento("Vendedores",80000, 60000, 20000);
        vendedores.setCodigo(2);
        
        ContaOrcamento administradores = new ContaOrcamento("Administradores",20000, 10000, 10000);
        administradores.setCodigo(1);
        
        ArrayList<ContaOrcamento> subGerais = new ArrayList();        
        subGerais.add(administradores);
        subGerais.add(vendedores);
        ContaOrcamento pagamento = new ContaOrcamento("Folha de Pagamento",100000, 70000, 30000);
        pagamento.setSubContasO(subGerais);
        pagamento.setCodigo(2);
        ContaOrcamento venda = new ContaOrcamento("Ponto de Venda",15000, 15000, 0);
        venda.setCodigo(2);
        
        ContaOrcamento escritorio = new ContaOrcamento("Escritorio",5000, 2000, 0);
        escritorio.setCodigo(1);
        
        ArrayList<ContaOrcamento> subObras = new ArrayList();
        
        subObras.add(escritorio);
        subObras.add(venda);
        ContaOrcamento obra = new ContaOrcamento("Obras e Reformas",20000, 17000, 0);
        obra.setSubContasO(subObras);
        obra.setCodigo(1);
        
        ArrayList<ContaOrcamento> subInvestimento = new ArrayList();
        subInvestimento.add(obra);
        ContaOrcamento investimento = new ContaOrcamento("Investimentos",20000, 17000, 0);
        investimento.setSubContasO(subInvestimento);
        investimento.setCodigo(3);
        ArrayList<ContaOrcamento> contaOrcamentos = new ArrayList();        
        contaOrcamentos.add(gerais);
        contaOrcamentos.add(pagamento);
        contaOrcamentos.add(investimento);
        
        Orcamento orcamento = new Orcamento(2018,contaOrcamentos);
        
        ArrayList<Orcamento> o = new ArrayList();
        o.add(orcamento);
                
        Empresa cefet = new Empresa("CEFET",o);
        
        
        
        
        //Captando valores dos campos
        int ano = 0;
        String empresa = req.getParameter("empresa");
        try{
        ano = Integer.parseInt(req.getParameter("ano"));
        }catch(NumberFormatException e){
            
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        }
        
        if(empresa.equals("")){
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        }
        if(empresa.equals("CEFET") && ano == 2018){
            req.getServletContext().setAttribute("empresaSelecionada", cefet);
            req.getServletContext().setAttribute("orcamento", orcamento);
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        }            
        
    }

    

}
