package br.com.bgames.dao;

import br.com.bgames.modelos.CadCliente;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CadClienteDAO {
    private Session session;

    public CadClienteDAO() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<CadCliente> listarClientes(){
        Transaction t = session.beginTransaction();
        List<CadCliente> lista = session.createQuery("FROM cadcliente ORDER BY nome").list();
        t.commit();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }

    public boolean adicionar(CadCliente cliente) {
        Transaction t = session.beginTransaction();
        session.save(cliente);
        t.commit();
        return true;
    }

    public boolean alterar(CadCliente cliente) {
        Transaction t = session.beginTransaction();
        session.update(cliente);
        t.commit();
        return true;
    }

    public boolean deletar(CadCliente cliente) {
        Transaction t = session.beginTransaction();
        session.delete(cliente);
        t.commit();
        return true;
    }
    
    public CadCliente consultarPorEmail(String email) {
        Transaction t =session.beginTransaction();
        List lista = session.createQuery("FROM CadCliente WHERE email='" +email+"'").list();
        t.commit();
        if (lista.isEmpty()) {
            return null;
        } else {
            return (CadCliente)lista.get(0);
        }
    }
}