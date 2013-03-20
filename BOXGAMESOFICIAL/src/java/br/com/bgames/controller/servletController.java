package br.com.bgames.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletController extends HttpServlet {

    @Override
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         String parametro = request.getParameter("encaminhar");
        String nomeDaClasse = "br.com.bgames.controller." + parametro;
         
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class classe = Class.forName(nomeDaClasse);
            EncaminharDados servlet = (EncaminharDados) classe.newInstance();
            servlet.executa(request, response);
            
        } 
        catch (Exception e) {
            throw new ServletException("A logica de negócios causou uma exceção", e);
        }finally {            
            out.close();
        }
    }    
     
}