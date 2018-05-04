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

/**
 *
 * @author alexa
 */

@ManagedBean
public class CadastroMB {
    
    private Cadastro cadastro;
    private List<Cadastro> lista;

    /**
     * @return the cadastro
     */
    public Cadastro getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @return the lista
     */
    public List<Cadastro> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Cadastro> lista) {
        this.lista = lista;
    }
    
    public void salvar(){
        CadastroDAO dao = new CadastroDAO();
        dao.salvar(cadastro);
        
        inicializar();
    }
    
    @PostConstruct
    public void inicializar(){
        CadastroDAO dao = new CadastroDAO();
        lista = dao.listar();
        
        cadastro = new Cadastro();
    }
    
}
