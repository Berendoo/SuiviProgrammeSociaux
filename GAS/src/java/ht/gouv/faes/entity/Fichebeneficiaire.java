/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benucci
 */
@Entity
@Table(name = "FICHEBENEFICIAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichebeneficiaire.findAll", query = "SELECT f FROM Fichebeneficiaire f"),
    @NamedQuery(name = "Fichebeneficiaire.findByIdfiche", query = "SELECT f FROM Fichebeneficiaire f WHERE f.idfiche = :idfiche"),
    @NamedQuery(name = "Fichebeneficiaire.findByDatecreation", query = "SELECT f FROM Fichebeneficiaire f WHERE f.datecreation = :datecreation"),
    @NamedQuery(name = "Fichebeneficiaire.findByDescription", query = "SELECT f FROM Fichebeneficiaire f WHERE f.description = :description")})
public class Fichebeneficiaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDFICHE")
    private Integer idfiche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECREATION")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "IDDOSSIERBENEFICIAIRE", referencedColumnName = "IDDOSSIERBENEFICIAIRE")
    @ManyToOne(optional = false)
    private Dossierbeneficiaire iddossierbeneficiaire;
    @JoinColumn(name = "IDPROJET", referencedColumnName = "IDPROJET")
    @ManyToOne(optional = false)
    private Projet idprojet;
    @JoinColumn(name = "IDTYPEBENEFICIAIRE", referencedColumnName = "IDTYPEBENEFICIAIRE")
    @ManyToOne(optional = false)
    private Typebeneficiaire idtypebeneficiaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfiche")
    private List<Detailsprestation> detailsprestationList;

    public Fichebeneficiaire() {
    }

    public Fichebeneficiaire(Integer idfiche) {
        this.idfiche = idfiche;
    }

    public Fichebeneficiaire(Integer idfiche, Date datecreation) {
        this.idfiche = idfiche;
        this.datecreation = datecreation;
    }

    public Integer getIdfiche() {
        return idfiche;
    }

    public void setIdfiche(Integer idfiche) {
        this.idfiche = idfiche;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dossierbeneficiaire getIddossierbeneficiaire() {
        return iddossierbeneficiaire;
    }

    public void setIddossierbeneficiaire(Dossierbeneficiaire iddossierbeneficiaire) {
        this.iddossierbeneficiaire = iddossierbeneficiaire;
    }

    public Projet getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(Projet idprojet) {
        this.idprojet = idprojet;
    }

    public Typebeneficiaire getIdtypebeneficiaire() {
        return idtypebeneficiaire;
    }

    public void setIdtypebeneficiaire(Typebeneficiaire idtypebeneficiaire) {
        this.idtypebeneficiaire = idtypebeneficiaire;
    }

    @XmlTransient
    public List<Detailsprestation> getDetailsprestationList() {
        return detailsprestationList;
    }

    public void setDetailsprestationList(List<Detailsprestation> detailsprestationList) {
        this.detailsprestationList = detailsprestationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfiche != null ? idfiche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichebeneficiaire)) {
            return false;
        }
        Fichebeneficiaire other = (Fichebeneficiaire) object;
        if ((this.idfiche == null && other.idfiche != null) || (this.idfiche != null && !this.idfiche.equals(other.idfiche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Fichebeneficiaire[ idfiche=" + idfiche + " ]";
    }
    
}
