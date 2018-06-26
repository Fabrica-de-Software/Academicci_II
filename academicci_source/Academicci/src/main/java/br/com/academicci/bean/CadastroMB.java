/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academicci.bean;

import br.com.academicci.entity.Cadastro;
import br.com.acdemicci.dao.CadastroDAO;
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
public class CadastroMB {

    private Cadastro cadastro;
    private List<Cadastro> lista;
    private CadastroDAO dao;
    
    
    public Cadastro getCadastro() {
        return cadastro;
    }


    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }


    public List<Cadastro> getLista() {
        return lista;
    }


    public void setLista(List<Cadastro> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void inicializarTela(){
        dao = new CadastroDAO();
        lista = dao.listar();
        
        limpar();
    }
    
    public void limpar(){
        cadastro = new Cadastro();
    }
    
    public void salvar(){
        dao = new CadastroDAO();
        dao.salvar(cadastro);
        
        inicializarTela();
    }
    
}
