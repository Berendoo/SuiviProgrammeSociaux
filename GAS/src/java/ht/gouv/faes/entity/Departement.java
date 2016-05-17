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
@Table(name = "DEPARTEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByIddepartement", query = "SELECT d FROM Departement d WHERE d.iddepartement = :iddepartement"),
    @NamedQuery(name = "Departement.findByNomdepartement", query = "SELECT d FROM Departement d WHERE d.nomdepartement = :nomdepartement")})
public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDDEPARTEMENT")
    private Integer iddepartement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMDEPARTEMENT")
    private String nomdepartement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepartement")
    private List<Commune> communeList;

    public Departement() {
    }

    public Departement(Integer iddepartement) {
        this.iddepartement = iddepartement;
    }

    public Departement(Integer iddepartement, String nomdepartement) {
        this.iddepartement = iddepartement;
        this.nomdepartement = nomdepartement;
    }

    public Integer getIddepartement() {
        return iddepartement;
    }

    public void setIddepartement(Integer iddepartement) {
        this.iddepartement = iddepartement;
    }

    public String getNomdepartement() {
        return nomdepartement;
    }

    public void setNomdepartement(String nomdepartement) {
        this.nomdepartement = nomdepartement;
    }

    @XmlTransient
    public List<Commune> getCommuneList() {
        return communeList;
    }

    public void setCommuneList(List<Commune> communeList) {
        this.communeList = communeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartement != null ? iddepartement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.iddepartement == null && other.iddepartement != null) || (this.iddepartement != null && !this.iddepartement.equals(other.iddepartement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Departement[ iddepartement=" + iddepartement + " ]";
        return nomdepartement;
    }
    
}
