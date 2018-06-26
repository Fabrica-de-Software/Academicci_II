/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academicci.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "cadastro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadastro.findAll", query = "SELECT c FROM Cadastro c")
    , @NamedQuery(name = "Cadastro.findById", query = "SELECT c FROM Cadastro c WHERE c.id = :id")
    , @NamedQuery(name = "Cadastro.findByNome", query = "SELECT c FROM Cadastro c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cadastro.findByMatricula", query = "SELECT c FROM Cadastro c WHERE c.matricula = :matricula")
    , @NamedQuery(name = "Cadastro.findByEmail", query = "SELECT c FROM Cadastro c WHERE c.email = :email")
    , @NamedQuery(name = "Cadastro.findByCpf", query = "SELECT c FROM Cadastro c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Cadastro.findBySenha", query = "SELECT c FROM Cadastro c WHERE c.senha = :senha")
    , @NamedQuery(name = "Cadastro.findByRg", query = "SELECT c FROM Cadastro c WHERE c.rg = :rg")
    , @NamedQuery(name = "Cadastro.findBySexo", query = "SELECT c FROM Cadastro c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Cadastro.findByNivelAcesso", query = "SELECT c FROM Cadastro c WHERE c.nivelAcesso = :nivelAcesso")})
public class Cadastro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nome")
    private Serializable nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private Serializable matricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email")
    private Serializable email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf")
    private Serializable cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "senha")
    private Serializable senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rg")
    private Serializable rg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private Serializable sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelAcesso")
    private Serializable nivelAcesso;

    public Cadastro() {
    }

    public Cadastro(Long id) {
        this.id = id;
    }

    public Cadastro(Long id, Serializable nome, Serializable matricula, Serializable email, Serializable cpf, Serializable senha, Serializable rg, Serializable sexo, Serializable nivelAcesso) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.rg = rg;
        this.sexo = sexo;
        this.nivelAcesso = nivelAcesso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Serializable getNome() {
        return nome;
    }

    public void setNome(Serializable nome) {
        this.nome = nome;
    }

    public Serializable getMatricula() {
        return matricula;
    }

    public void setMatricula(Serializable matricula) {
        this.matricula = matricula;
    }

    public Serializable getEmail() {
        return email;
    }

    public void setEmail(Serializable email) {
        this.email = email;
    }

    public Serializable getCpf() {
        return cpf;
    }

    public void setCpf(Serializable cpf) {
        this.cpf = cpf;
    }

    public Serializable getSenha() {
        return senha;
    }

    public void setSenha(Serializable senha) {
        this.senha = senha;
    }

    public Serializable getRg() {
        return rg;
    }

    public void setRg(Serializable rg) {
        this.rg = rg;
    }

    public Serializable getSexo() {
        return sexo;
    }

    public void setSexo(Serializable sexo) {
        this.sexo = sexo;
    }

    public Serializable getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(Serializable nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadastro)) {
            return false;
        }
        Cadastro other = (Cadastro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.academicci.entity.Cadastro[ id=" + id + " ]";
    }
    
}
