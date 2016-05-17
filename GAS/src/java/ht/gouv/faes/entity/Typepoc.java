/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benucci
 */
@Entity
@Table(name = "TYPEPOC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typepoc.findAll", query = "SELECT t FROM Typepoc t"),
    @NamedQuery(name = "Typepoc.findByIdtypepoc", query = "SELECT t FROM Typepoc t WHERE t.idtypepoc = :idtypepoc"),
    @NamedQuery(name = "Typepoc.findByFonction", query = "SELECT t FROM Typepoc t WHERE t.fonction = :fonction"),
    @NamedQuery(name = "Typepoc.findByDescription", query = "SELECT t FROM Typepoc t WHERE t.description = :description")})
public class Typepoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDTYPEPOC")
    private Integer idtypepoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "FONCTION")
    private String fonction;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypepoc")
    private List<Personnereference> personnereferenceList;

    public Typepoc() {
    }

    public Typepoc(Integer idtypepoc) {
        this.idtypepoc = idtypepoc;
    }

    public Typepoc(Integer idtypepoc, String fonction) {
        this.idtypepoc = idtypepoc;
        this.fonction = fonction;
    }

    public Integer getIdtypepoc() {
        return idtypepoc;
    }

    public void setIdtypepoc(Integer idtypepoc) {
        this.idtypepoc = idtypepoc;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Personnereference> getPersonnereferenceList() {
        return personnereferenceList;
    }

    public void setPersonnereferenceList(List<Personnereference> personnereferenceList) {
        this.personnereferenceList = personnereferenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypepoc != null ? idtypepoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typepoc)) {
            return false;
        }
        Typepoc other = (Typepoc) object;
        if ((this.idtypepoc == null && other.idtypepoc != null) || (this.idtypepoc != null && !this.idtypepoc.equals(other.idtypepoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Typepoc[ idtypepoc=" + idtypepoc + " ]";
        return fonction;
    }
    
}
