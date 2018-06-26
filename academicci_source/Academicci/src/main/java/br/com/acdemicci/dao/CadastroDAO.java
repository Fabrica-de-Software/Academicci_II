/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acdemicci.dao;

import br.com.academicci.entity.Cadastro;
import br.com.academicci.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alexa
 */
public class CadastroDAO {
    
    public void salvar(Cadastro cadastro){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.persist(cadastro);
        
        sessao.getTransaction().commit();
        sessao.close();
    }
    
    public List<Cadastro> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Cadastro> cadastro = sessao.getNamedQuery("Cadastro.findAll").list();
        sessao.close();
        return cadastro;
    }
    
    public void alterar(Cadastro cadastro){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.merge(cadastro);
        
        sessao.getTransaction().commit();
        sessao.close();
    }    
    
    public void deletar(Long id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.delete(sessao.get(Cadastro.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
    }
    
}
