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
@Table(name = "PRESTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestation.findAll", query = "SELECT p FROM Prestation p"),
    @NamedQuery(name = "Prestation.findByIdprestation", query = "SELECT p FROM Prestation p WHERE p.idprestation = :idprestation"),
    @NamedQuery(name = "Prestation.findByNomprestation", query = "SELECT p FROM Prestation p WHERE p.nomprestation = :nomprestation"),
    @NamedQuery(name = "Prestation.findByDescription", query = "SELECT p FROM Prestation p WHERE p.description = :description")})
public class Prestation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDPRESTATION")
    private Integer idprestation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMPRESTATION")
    private String nomprestation;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprestation")
    private List<Detailsprestation> detailsprestationList;
    @JoinColumn(name = "IDDISTRIBUTEUR", referencedColumnName = "IDDISTRIBUTEUR")
    @ManyToOne(optional = false)
    private Distributeur iddistributeur;

    public Prestation() {
    }

    public Prestation(Integer idprestation) {
        this.idprestation = idprestation;
    }

    public Prestation(Integer idprestation, String nomprestation) {
        this.idprestation = idprestation;
        this.nomprestation = nomprestation;
    }

    public Integer getIdprestation() {
        return idprestation;
    }

    public void setIdprestation(Integer idprestation) {
        this.idprestation = idprestation;
    }

    public String getNomprestation() {
        return nomprestation;
    }

    public void setNomprestation(String nomprestation) {
        this.nomprestation = nomprestation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Detailsprestation> getDetailsprestationList() {
        return detailsprestationList;
    }

    public void setDetailsprestationList(List<Detailsprestation> detailsprestationList) {
        this.detailsprestationList = detailsprestationList;
    }

    public Distributeur getIddistributeur() {
        return iddistributeur;
    }

    public void setIddistributeur(Distributeur iddistributeur) {
        this.iddistributeur = iddistributeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprestation != null ? idprestation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestation)) {
            return false;
        }
        Prestation other = (Prestation) object;
        if ((this.idprestation == null && other.idprestation != null) || (this.idprestation != null && !this.idprestation.equals(other.idprestation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Prestation[ idprestation=" + idprestation + " ]";
        return nomprestation;
    }
    
}
