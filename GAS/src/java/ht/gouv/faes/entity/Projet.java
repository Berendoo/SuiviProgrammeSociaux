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
import javax.persistence.Lob;
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
@Table(name = "PROJET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projet.findAll", query = "SELECT p FROM Projet p"),
    @NamedQuery(name = "Projet.findByIdprojet", query = "SELECT p FROM Projet p WHERE p.idprojet = :idprojet"),
    @NamedQuery(name = "Projet.findByNomprojet", query = "SELECT p FROM Projet p WHERE p.nomprojet = :nomprojet"),
    @NamedQuery(name = "Projet.findByDescription", query = "SELECT p FROM Projet p WHERE p.description = :description"),
    @NamedQuery(name = "Projet.findByTypeprojet", query = "SELECT p FROM Projet p WHERE p.typeprojet = :typeprojet")})
public class Projet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDPROJET")
    private Integer idprojet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMPROJET")
    private String nomprojet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TYPEPROJET")
    private String typeprojet;
    @Lob
    @Column(name = "LOGO")
    private byte[] logo;
    @JoinColumn(name = "IDPROGRAMME", referencedColumnName = "IDPROGRAMME")
    @ManyToOne(optional = false)
    private Programme idprogramme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprojet")
    private List<Fichebeneficiaire> fichebeneficiaireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprojet")
    private List<Contrat> contratList;

    public Projet() {
    }

    public Projet(Integer idprojet) {
        this.idprojet = idprojet;
    }

    public Projet(Integer idprojet, String nomprojet, String description, String typeprojet) {
        this.idprojet = idprojet;
        this.nomprojet = nomprojet;
        this.description = description;
        this.typeprojet = typeprojet;
    }

    public Integer getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(Integer idprojet) {
        this.idprojet = idprojet;
    }

    public String getNomprojet() {
        return nomprojet;
    }

    public void setNomprojet(String nomprojet) {
        this.nomprojet = nomprojet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeprojet() {
        return typeprojet;
    }

    public void setTypeprojet(String typeprojet) {
        this.typeprojet = typeprojet;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Programme getIdprogramme() {
        return idprogramme;
    }

    public void setIdprogramme(Programme idprogramme) {
        this.idprogramme = idprogramme;
    }

    @XmlTransient
    public List<Fichebeneficiaire> getFichebeneficiaireList() {
        return fichebeneficiaireList;
    }

    public void setFichebeneficiaireList(List<Fichebeneficiaire> fichebeneficiaireList) {
        this.fichebeneficiaireList = fichebeneficiaireList;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprojet != null ? idprojet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.idprojet == null && other.idprojet != null) || (this.idprojet != null && !this.idprojet.equals(other.idprojet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Projet[ idprojet=" + idprojet + " ]";
        return nomprojet;
    }
    
}
