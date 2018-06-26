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
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
    , @NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.id = :id")
    , @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome")
    , @NamedQuery(name = "Disciplina.findByPeriodo", query = "SELECT d FROM Disciplina d WHERE d.periodo = :periodo")
    , @NamedQuery(name = "Disciplina.findBySemestre", query = "SELECT d FROM Disciplina d WHERE d.semestre = :semestre")
    , @NamedQuery(name = "Disciplina.findByAno", query = "SELECT d FROM Disciplina d WHERE d.ano = :ano")
    , @NamedQuery(name = "Disciplina.findByStatus", query = "SELECT d FROM Disciplina d WHERE d.status = :status")})
public class Disciplina implements Serializable {

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
    @Column(name = "periodo")
    private Serializable periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private Serializable semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private Serializable ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Serializable status;

    public Disciplina() {
    }

    public Disciplina(Long id) {
        this.id = id;
    }

    public Disciplina(Long id, Serializable nome, Serializable periodo, Serializable semestre, Serializable ano, Serializable status) {
        this.id = id;
        this.nome = nome;
        this.periodo = periodo;
        this.semestre = semestre;
        this.ano = ano;
        this.status = status;
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

    public Serializable getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Serializable periodo) {
        this.periodo = periodo;
    }

    public Serializable getSemestre() {
        return semestre;
    }

    public void setSemestre(Serializable semestre) {
        this.semestre = semestre;
    }

    public Serializable getAno() {
        return ano;
    }

    public void setAno(Serializable ano) {
        this.ano = ano;
    }

    public Serializable getStatus() {
        return status;
    }

    public void setStatus(Serializable status) {
        this.status = status;
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
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.academicci.entity.Disciplina[ id=" + id + " ]";
    }
    
}
