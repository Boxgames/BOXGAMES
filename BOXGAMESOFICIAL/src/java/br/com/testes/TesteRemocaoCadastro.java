package br.com.testes;

import br.com.modelos.CadCliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TesteRemocaoCadastro {

    public static void main(String[] args) {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        // carrega o produto do banco de dados
        CadCliente teste = (CadCliente) session.load(CadCliente.class, 1L);

        Transaction tx = session.beginTransaction();
        session.delete(teste);
        tx.commit();
    }
}
