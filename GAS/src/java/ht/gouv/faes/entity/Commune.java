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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COMMUNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commune.findAll", query = "SELECT c FROM Commune c"),
    @NamedQuery(name = "Commune.findByIdcommune", query = "SELECT c FROM Commune c WHERE c.idcommune = :idcommune"),
    @NamedQuery(name = "Commune.findByNomcommune", query = "SELECT c FROM Commune c WHERE c.nomcommune = :nomcommune")})
public class Commune implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDCOMMUNE")
    private Integer idcommune;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMCOMMUNE")
    private String nomcommune;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcommune")
    private List<Institution> institutionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcommune")
    private List<Organisation> organisationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcommune")
    private List<Personnereference> personnereferenceList;
    @JoinColumn(name = "IDDEPARTEMENT", referencedColumnName = "IDDEPARTEMENT")
    @ManyToOne(optional = false)
    private Departement iddepartement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcommune")
    private List<Detailsprestation> detailsprestationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcommune")
    private List<Distributeur> distributeurList;

    public Commune() {
    }

    public Commune(Integer idcommune) {
        this.idcommune = idcommune;
    }

    public Commune(Integer idcommune, String nomcommune) {
        this.idcommune = idcommune;
        this.nomcommune = nomcommune;
    }

    public Integer getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(Integer idcommune) {
        this.idcommune = idcommune;
    }

    public String getNomcommune() {
        return nomcommune;
    }

    public void setNomcommune(String nomcommune) {
        this.nomcommune = nomcommune;
    }

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    @XmlTransient
    public List<Organisation> getOrganisationList() {
        return organisationList;
    }

    public void setOrganisationList(List<Organisation> organisationList) {
        this.organisationList = organisationList;
    }

    @XmlTransient
    public List<Personnereference> getPersonnereferenceList() {
        return personnereferenceList;
    }

    public void setPersonnereferenceList(List<Personnereference> personnereferenceList) {
        this.personnereferenceList = personnereferenceList;
    }

    public Departement getIddepartement() {
        return iddepartement;
    }

    public void setIddepartement(Departement iddepartement) {
        this.iddepartement = iddepartement;
    }

    @XmlTransient
    public List<Detailsprestation> getDetailsprestationList() {
        return detailsprestationList;
    }

    public void setDetailsprestationList(List<Detailsprestation> detailsprestationList) {
        this.detailsprestationList = detailsprestationList;
    }

    @XmlTransient
    public List<Distributeur> getDistributeurList() {
        return distributeurList;
    }

    public void setDistributeurList(List<Distributeur> distributeurList) {
        this.distributeurList = distributeurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommune != null ? idcommune.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commune)) {
            return false;
        }
        Commune other = (Commune) object;
        if ((this.idcommune == null && other.idcommune != null) || (this.idcommune != null && !this.idcommune.equals(other.idcommune))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Commune[ idcommune=" + idcommune + " ]";
        return nomcommune;
    }
    
}
