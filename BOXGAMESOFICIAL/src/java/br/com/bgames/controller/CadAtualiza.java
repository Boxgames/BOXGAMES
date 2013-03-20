package br.com.bgames.controller;

import br.com.bgames.dao.CadClienteDAO;
import br.com.bgames.metodosajudantes.Ajudantes;
import br.com.bgames.modelos.CadCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadAtualiza extends HttpServlet {
  protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        java.sql.Date dtSQL = new java.sql.Date(System.currentTimeMillis());
        
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String dataEmTexto = request.getParameter("data");
        Long cpf = Ajudantes.conversorCpf(request.getParameter("cpf"));
        Long telefone = Ajudantes.conversorTel(request.getParameter("telefone"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexo");
      
        //Fazendo converção da data
        try {
            dtSQL = new java.sql.Date( new java.text.SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto).getTime());
        } catch (ParseException e) {
            out.println("Erro de converção da data." +e);
        }
        //Monta um objeto contato
        CadCliente cliente = new CadCliente();
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setDatanascimento(dtSQL);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setSexo(sexo);
        
        
        CadClienteDAO dao = new CadClienteDAO();
        if (dao.alterar(cliente)) {
            //Imprime messagem comfirmando o cadastro
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>O cadastro foi atualizado com sucesso!<h3></br>");
            out.println("Cliente " + cliente.getNome() + " atualizado com sucesso</br>");
            out.println("<br><br><a href='Principal.jsp'>Voltar para a HOME</a>");
            out.println("</body>");
            out.println("</html>");
        } else{
            //Exibe mensagem de erro.
            out.println("<html>");
            out.println("<body>");
            out.println("Erro ao realizar a atualização!</br>");
            out.println("Tente novamente");
            out.println("</body>");
            out.println("</html>");
        }
    }
}