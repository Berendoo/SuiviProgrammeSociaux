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
@Table(name = "TYPEBENEFICIAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typebeneficiaire.findAll", query = "SELECT t FROM Typebeneficiaire t"),
    @NamedQuery(name = "Typebeneficiaire.findByIdtypebeneficiaire", query = "SELECT t FROM Typebeneficiaire t WHERE t.idtypebeneficiaire = :idtypebeneficiaire"),
    @NamedQuery(name = "Typebeneficiaire.findByNomtypebeneficiaire", query = "SELECT t FROM Typebeneficiaire t WHERE t.nomtypebeneficiaire = :nomtypebeneficiaire"),
    @NamedQuery(name = "Typebeneficiaire.findByDescription", query = "SELECT t FROM Typebeneficiaire t WHERE t.description = :description")})
public class Typebeneficiaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDTYPEBENEFICIAIRE")
    private Integer idtypebeneficiaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMTYPEBENEFICIAIRE")
    private String nomtypebeneficiaire;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypebeneficiaire")
    private List<Fichebeneficiaire> fichebeneficiaireList;

    public Typebeneficiaire() {
    }

    public Typebeneficiaire(Integer idtypebeneficiaire) {
        this.idtypebeneficiaire = idtypebeneficiaire;
    }

    public Typebeneficiaire(Integer idtypebeneficiaire, String nomtypebeneficiaire) {
        this.idtypebeneficiaire = idtypebeneficiaire;
        this.nomtypebeneficiaire = nomtypebeneficiaire;
    }

    public Integer getIdtypebeneficiaire() {
        return idtypebeneficiaire;
    }

    public void setIdtypebeneficiaire(Integer idtypebeneficiaire) {
        this.idtypebeneficiaire = idtypebeneficiaire;
    }

    public String getNomtypebeneficiaire() {
        return nomtypebeneficiaire;
    }

    public void setNomtypebeneficiaire(String nomtypebeneficiaire) {
        this.nomtypebeneficiaire = nomtypebeneficiaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Fichebeneficiaire> getFichebeneficiaireList() {
        return fichebeneficiaireList;
    }

    public void setFichebeneficiaireList(List<Fichebeneficiaire> fichebeneficiaireList) {
        this.fichebeneficiaireList = fichebeneficiaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypebeneficiaire != null ? idtypebeneficiaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typebeneficiaire)) {
            return false;
        }
        Typebeneficiaire other = (Typebeneficiaire) object;
        if ((this.idtypebeneficiaire == null && other.idtypebeneficiaire != null) || (this.idtypebeneficiaire != null && !this.idtypebeneficiaire.equals(other.idtypebeneficiaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Typebeneficiaire[ idtypebeneficiaire=" + idtypebeneficiaire + " ]";
        return nomtypebeneficiaire;
    }
    
}
