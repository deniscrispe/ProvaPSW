<%-- 
    Document   : form
    Created on : 16/04/2018, 19:05:22
    Author     : denis
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="WEB-INF/tag.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <title>Tabela de Orçamento</title>
    </head>
    <body>

        <form action="BuscaServlet" method="POST">

            <div class="form-group">
                Empresa: <select name="empresa" class="custom-select col-3" id="empresa" > 
                    <option value= ""> </option>
                    <option value="CEFET" ${param.empresa eq "CEFET"? "selected" : ""}>CEFET</option>
                    

                </select>${msgErroEmpresa} <br>
                <br>
                Ano: <select name="ano" class="custom-select col-3" id="ano" > 
                    <option value= ""> </option>
                    <option value="2018" ${param.ano eq "2018"? "selected" : ""}>2018</option>

                </select>${msgErroAno} <br>
                <br>            
                <button type="submit" class="btn btn-primary"> Solicitar Orçamento </button>

            </div>
        </form>


        <table border="1" class="table table-striped">
            <thead>
                <tr>
                    
                    <th scope="col">Orçamento</th>
                    <th scope="col">Orçado</th>
                    <th scope="col">Realizado</th>
                    <th scope="col">Comprometido</th>
                    <th scope="col">Disponível</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${applicationScope.orcamento.getContas()}" var="conta" varStatus="statusOrcamento"> 
                    <tag:OrcamentoTag conta="${conta}"/>   
                </c:forEach>
                
            </tbody>
        </table>


        <form action="RegistraServlet" method="POST">

            <div class="form-group">
                <h5>Valores</h5>

                <label for="codigo">Código:</label>
                <input type ="text" class="form-control col-5 ${requestScope.validadeCodigo}" name="codigo" id="codigo" value="${param.codigo}" required >
                <div class="invalid-feedback">
                    ${requestScope.msgErroCodigo}
                </div>

                <label for="valorRealizado">Valor Realizado:</label>
                <input type ="text" class="form-control col-5 ${requestScope.validadeValorRealizado}" name="valorRealizado" id="valorRealizado" value="${param.valorRealizado}" required >
                <div class="invalid-feedback">
                    ${requestScope.msgErroValorRealizado}
                </div>
                <br>         
                <br>
                <button type="submit" class="btn btn-primary"> Registrar </button>
            </div>
        </form>

    </body>
</html>
