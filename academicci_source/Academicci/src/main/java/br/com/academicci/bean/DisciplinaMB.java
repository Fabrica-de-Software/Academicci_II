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

/**
 *
 * @author alexa
 */

@ManagedBean
public class DisciplinaMB {
    
    private Disciplina disciplina;
    private List<Disciplina> lista;

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the lista
     */
    public List<Disciplina> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Disciplina> lista) {
        this.lista = lista;
    }
    
    public void salvar(){
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.salvar(disciplina);
        
        inicializar();
    }
    
    @PostConstruct
    public void inicializar(){
        DisciplinaDAO dao = new DisciplinaDAO();
        lista = dao.listar();
        
        disciplina = new Disciplina();
    }
    
}
