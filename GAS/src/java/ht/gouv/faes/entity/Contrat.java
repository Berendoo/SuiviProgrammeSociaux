/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benucci
 */
@Entity
@Table(name = "CONTRAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c"),
    @NamedQuery(name = "Contrat.findByIdcontrat", query = "SELECT c FROM Contrat c WHERE c.idcontrat = :idcontrat"),
    @NamedQuery(name = "Contrat.findByDatedebut", query = "SELECT c FROM Contrat c WHERE c.datedebut = :datedebut"),
    @NamedQuery(name = "Contrat.findByDatefin", query = "SELECT c FROM Contrat c WHERE c.datefin = :datefin"),
    @NamedQuery(name = "Contrat.findByMotif", query = "SELECT c FROM Contrat c WHERE c.motif = :motif")})
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDCONTRAT")
    private Integer idcontrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEDEBUT")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "MOTIF")
    private String motif;
    @JoinColumn(name = "IDDISTRIBUTEUR", referencedColumnName = "IDDISTRIBUTEUR")
    @ManyToOne(optional = false)
    private Distributeur iddistributeur;
    @JoinColumn(name = "IDPROJET", referencedColumnName = "IDPROJET")
    @ManyToOne(optional = false)
    private Projet idprojet;

    public Contrat() {
    }

    public Contrat(Integer idcontrat) {
        this.idcontrat = idcontrat;
    }

    public Contrat(Integer idcontrat, Date datedebut, Date datefin, String motif) {
        this.idcontrat = idcontrat;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.motif = motif;
    }

    public Integer getIdcontrat() {
        return idcontrat;
    }

    public void setIdcontrat(Integer idcontrat) {
        this.idcontrat = idcontrat;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Distributeur getIddistributeur() {
        return iddistributeur;
    }

    public void setIddistributeur(Distributeur iddistributeur) {
        this.iddistributeur = iddistributeur;
    }

    public Projet getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(Projet idprojet) {
        this.idprojet = idprojet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontrat != null ? idcontrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.idcontrat == null && other.idcontrat != null) || (this.idcontrat != null && !this.idcontrat.equals(other.idcontrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Contrat[ idcontrat=" + idcontrat + " ]";
    }
    
}
