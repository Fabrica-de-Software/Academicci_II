/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academicci.bean;

import br.com.academicci.entity.Disciplina;
import br.com.acdemicci.dao.DisciplinaDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author alexa
 */
@ManagedBean
@ViewScoped
public class DisciplinaMB {

    private Disciplina disciplina;
    private List<Disciplina> lista;
    private DisciplinaDAO dao;
    
    
    public Disciplina getDisciplina() {
        return disciplina;
    }


    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }


    public List<Disciplina> getLista() {
        return lista;
    }


    public void setLista(List<Disciplina> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void inicializarTela(){
        dao = new DisciplinaDAO();
        lista = dao.listar();
        
        limpar();
    }
    
    public void limpar(){
        disciplina = new Disciplina();
    }
    
    public void salvar(){
        dao = new DisciplinaDAO();
        dao.salvar(disciplina);
        
        inicializarTela();
    }
    
}
