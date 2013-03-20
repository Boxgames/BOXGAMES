package br.com.bgames.controller;
import br.com.bgames.dao.CadClienteDAO;
import br.com.bgames.metodosajudantes.Ajudantes;
import br.com.bgames.modelos.CadCliente;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wesley
 */
public class ActionCliente implements EncaminharDados{
    
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        response.setContentType("text/html;charset=ISO-8859-9");
        PrintWriter out = response.getWriter();
        
        try {
            String metodo = request.getParameter("metodo");           
            if (metodo.equals("cadastrar")) {
                out.println(cadastrar(request));
                RequestDispatcher proxima = request.getRequestDispatcher("index.jsp");  
                proxima.forward(request, response);
            
        }} finally {
            out.close();
        }
    }
    
    //  Cadastrar  /////////////////////////////////////////////////////////////
    private String cadastrar (HttpServletRequest request) throws ParseException{
        StringBuilder sb = new StringBuilder();  
               
        
         //Pegando os parametros do request
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String dataEmTexto = request.getParameter("data");
        Long cpf = Ajudantes.conversorCpf(request.getParameter("cpf"));
        Long telefone = Ajudantes.conversorTel(request.getParameter("telefone"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexo");
        
   
        //Monta um objeto contato
        CadCliente cliente = new CadCliente();
        cliente.setEmail(email);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setDatanascimento(new java.sql.Date( new java.text.SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto).getTime()));        
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);  
        cliente.setSenha(senha);
        cliente.setSexo(sexo);
        
        

        //Grave nessa conexão!!!
        CadClienteDAO dao = new CadClienteDAO();
        if (dao.adicionar(cliente)) {
            //Imprime messagem comfirmando o cadastro
            sb.append("<h1>O seu cadastro foi concluido com sucesso!</h1></br>");
            sb.append("Seja Bem Vindo ").append(cliente.getNome()).append("<br>"); 
            sb.append("<form method='post' action='Principal.jsp'> ");
            sb.append("</br><input type='submit' style='height: 40px; width: 150px; ' value='Home Page'/>");            
            sb.append("</form>");
        } else{
           //Exibe mensagem de erro.
            sb.append("Erro ao realizar cadastro!<br/>");
            sb.append("Tente novamente");
       
                  
        }
        return sb.toString();
    }
    
    }
    

