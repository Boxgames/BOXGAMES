package br.com.bgames.controller;

import br.com.bgames.dao.CadClienteDAO;
import br.com.bgames.modelos.CadCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PreecherFormDeAtualizacaoAutomatico extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        //Pegando os parametros do request
        String email = request.getParameter("email");
        
        //Pesquisando cliente para preecher o form
        CadClienteDAO dao = new CadClienteDAO();
        CadCliente cliente = dao.consultarPorEmail(email);
        
        //Convertendo data para String
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String dataString = sdf.format(cliente.getDatanascimento());
        
         String rSexo;
        if(cliente.getSexo().equalsIgnoreCase("masculino")){
            rSexo = "Sexo: <input required type=\"radio\" name=\"sexo\" value =\"masculino\" required checked>Masculino"
                    + "<input required type=\"radio\" name=\"sexo\" value =\"feminino\" required>Feminino<br/><br/>";          
             }
        else{ 
            rSexo = "Sexo: <input required type=\"radio\" name=\"sexo\" value =\"masculino\" required >Masculino"
                    + "<input required type=\"radio\" name=\"sexo\" value =\"feminino\" required checked>Feminino<br/><br/>";
        }
 
        out.println("<html>");
        out.println("    <head>\n" +
"        <title>BOX GAMES - TESTANDO A ATUALIZACAO...</title>\n" +
"        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"        <script src=\"js/jquery-1.9.1.js\" type=\"text/javascript\"></script>\n" +
"        <script src=\"js/jquery.maskedinput.js\" type=\"text/javascript\"></script>\n" +
"        <script type=\"text/javascript\">\n" +
"            $(function() {\n" +
"                $('input[name=data]').mask('99/99/9999'),\n" +
"                $('input[name=cep]').mask('99999-999'),\n" +
"                $('input[name=cpf]').mask('999.999.999-99'),\n" +
"                $('input[name=telefone]').mask('(99) 9999-9999')                               \n" +
"});		\n" +
"                                          \n" +
"        </script>\n" +
"    </head>");
        out.println("<body>");
        out.println("<h1 style=\"color: red; text-align: center\">Atualização de Cadastro Box Games - Teste Funcional</h1>");
        out.println("<div style=\"text-align: center; width: 1200px; margin: 0 auto;\">");
        out.println("<form method=\"post\" action=\"PreencheFormAtualAuto\">" + "<h4 style=\"color: blue; text-decoration: underline\">Consultar o cadastro pelo Email:<input autofocus required type=\"email\" name=\"email\" value=\"\" required/><br/>\n" +
"<input type=\"submit\" style='height: 30px; width: 100px;' value=\"Consultar\" name=\"\"> </h4></form>");               
        out.println("<form method='post' action='CadAtualiza'>"
                    + "<b>"
                    + "Nome: <input  required type='text' name='nome' value='"+cliente.getNome()+"'/> <br/>"
                    + "Sobrenome: <input required type='text' name='sobrenome' value='"+cliente.getSobrenome()+"'/> <br/>"
                    + "Data de nascimento: <input required type='text' name='data' value='"+dataString+"' /><br/>"
                    + "CPF: <input required readonly='readonly' type=\"text\" name=\"cpf\" value='" +cliente.getCpf()+ "' /><br/>"
                    + "Telefone: <input required type='text' name='telefone' value='"+cliente.getTelefone()+"'/><br/>"
                    + "Email: <input required type='text' name='email' value='"+cliente.getEmail()+"' readonly='readonly' /> <br/>"
                    + "Senha: <input required type=\"text\" name=\"senha\" value='"+cliente.getSenha()+"' /><br/>"
                    + rSexo
                    + "</b>"                    
                    + "<input type='submit' style=\"height: 40px; width: 150px;\" value='Atualizar'/>"                    
                    + "</form>");
        out.println("<br><a href='Principal.jsp'>Cancelar</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}     
  