/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acdemicci.dao;

import br.com.academicci.entity.Disciplina;
import br.com.academicci.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alexa
 */
public class DisciplinaDAO {
    
    public void salvar(Disciplina disciplina){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.persist(disciplina);
        
        sessao.getTransaction().commit();
        sessao.close();
    }
    
    public List<Disciplina> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Disciplina> lista = sessao.getNamedQuery("Disciplina.findAll").list();
        sessao.close();
        
        return lista;
    }
}
