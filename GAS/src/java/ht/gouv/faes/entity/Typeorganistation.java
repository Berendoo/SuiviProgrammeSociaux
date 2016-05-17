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
@Table(name = "TYPEORGANISTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeorganistation.findAll", query = "SELECT t FROM Typeorganistation t"),
    @NamedQuery(name = "Typeorganistation.findByIdtypeorganisation", query = "SELECT t FROM Typeorganistation t WHERE t.idtypeorganisation = :idtypeorganisation"),
    @NamedQuery(name = "Typeorganistation.findByNomtype", query = "SELECT t FROM Typeorganistation t WHERE t.nomtype = :nomtype"),
    @NamedQuery(name = "Typeorganistation.findByDescription", query = "SELECT t FROM Typeorganistation t WHERE t.description = :description")})
public class Typeorganistation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDTYPEORGANISATION")
    private Integer idtypeorganisation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMTYPE")
    private String nomtype;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypeorganisation")
    private List<Organisation> organisationList;

    public Typeorganistation() {
    }

    public Typeorganistation(Integer idtypeorganisation) {
        this.idtypeorganisation = idtypeorganisation;
    }

    public Typeorganistation(Integer idtypeorganisation, String nomtype) {
        this.idtypeorganisation = idtypeorganisation;
        this.nomtype = nomtype;
    }

    public Integer getIdtypeorganisation() {
        return idtypeorganisation;
    }

    public void setIdtypeorganisation(Integer idtypeorganisation) {
        this.idtypeorganisation = idtypeorganisation;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Organisation> getOrganisationList() {
        return organisationList;
    }

    public void setOrganisationList(List<Organisation> organisationList) {
        this.organisationList = organisationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeorganisation != null ? idtypeorganisation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeorganistation)) {
            return false;
        }
        Typeorganistation other = (Typeorganistation) object;
        if ((this.idtypeorganisation == null && other.idtypeorganisation != null) || (this.idtypeorganisation != null && !this.idtypeorganisation.equals(other.idtypeorganisation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Typeorganistation[ idtypeorganisation=" + idtypeorganisation + " ]";
        return nomtype;
    }
    
}
