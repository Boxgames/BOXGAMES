package br.com.testes;

import br.com.modelos.*;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TesteAdicaoCadastro {
    
   public static void main(String[] args) {
      
     AnnotationConfiguration configuration = new AnnotationConfiguration();
     configuration.configure();
     
     SessionFactory factory = configuration.buildSessionFactory();
     Session session = factory.openSession();     
     
       Usuario teste = new Usuario();
//     teste.setEmail(JOptionPane.showInputDialog("email"));
//     teste.setSenha(JOptionPane.showInputDialog("senha")); 
//     session.save(teste);  
//     Transaction tx = session.beginTransaction();
//     tx.commit();  
     boolean validador;
     boolean validador2;
     String email;
     do{
         validador = false;
         validador2 = false;
         do{
            email = (JOptionPane.showInputDialog("email"));
            for (int i=0;i<email.length(); i++){        
            char res = email.charAt(i);
                if (res == '@'){
                    i = email.length();
                    validador = true;
                }        
            }
         }while(validador == false);
   String resultado; 
    try{ 
     resultado = session.createSQLQuery("Select EMAIL from banco.usuario where (email = '"+email+"')").uniqueResult().toString();               
    }
    catch(NullPointerException npe){
        resultado = "";                               
    }            
    if (resultado.isEmpty()){
         validador2 = true;
     }       
   }while(validador2 == false);
   }
   
 public static void Usuario (String email, String senha){ 
     AnnotationConfiguration configuration = new AnnotationConfiguration();
     configuration.configure();     
     SessionFactory factory = configuration.buildSessionFactory();
     Session session = factory.openSession(); 
     Usuario teste = new Usuario();
     teste.setEmail(email);
     teste.setSenha(senha);       
     Transaction tx = session.beginTransaction();
     session.save(teste);        
     tx.commit();  
   
 }
 
 public static void consultaUsuario (String email){
     AnnotationConfiguration configuration = new AnnotationConfiguration();
     configuration.configure();     
     SessionFactory factory = configuration.buildSessionFactory();
     Session session = factory.openSession(); 
     String resultado = session.createSQLQuery("Select EMAIL from banco.usuario where (email = '"+"a"+"')").uniqueResult().toString();               
     if (resultado.equals(email)){
         System.out.print("Cliente ja Cadastrado");
     }
     else{
         System.out.print("Cliente Cadastrado");
     }
   }
 }
 
 
 
 


