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
@Table(name = "ENFANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfant.findAll", query = "SELECT e FROM Enfant e"),
    @NamedQuery(name = "Enfant.findByIdenfant", query = "SELECT e FROM Enfant e WHERE e.idenfant = :idenfant"),
    @NamedQuery(name = "Enfant.findByNomenfant", query = "SELECT e FROM Enfant e WHERE e.nomenfant = :nomenfant"),
    @NamedQuery(name = "Enfant.findByPrenomenfant", query = "SELECT e FROM Enfant e WHERE e.prenomenfant = :prenomenfant"),
    @NamedQuery(name = "Enfant.findByDatadenaissanceenfant", query = "SELECT e FROM Enfant e WHERE e.datadenaissanceenfant = :datadenaissanceenfant"),
    @NamedQuery(name = "Enfant.findBySexeenfant", query = "SELECT e FROM Enfant e WHERE e.sexeenfant = :sexeenfant"),
    @NamedQuery(name = "Enfant.findByNiveau", query = "SELECT e FROM Enfant e WHERE e.niveau = :niveau")})
public class Enfant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDENFANT")
    private Integer idenfant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMENFANT")
    private String nomenfant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOMENFANT")
    private String prenomenfant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATADENAISSANCEENFANT")
    @Temporal(TemporalType.DATE)
    private Date datadenaissanceenfant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXEENFANT")
    private Character sexeenfant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NIVEAU")
    private String niveau;
    @JoinColumn(name = "IDINDIVIDU", referencedColumnName = "IDINDIVIDU")
    @ManyToOne(optional = false)
    private Individu idindividu;
    @JoinColumn(name = "IDORGANISATION", referencedColumnName = "IDORGANISATION")
    @ManyToOne(optional = false)
    private Organisation idorganisation;

    public Enfant() {
    }

    public Enfant(Integer idenfant) {
        this.idenfant = idenfant;
    }

    public Enfant(Integer idenfant, String nomenfant, String prenomenfant, Date datadenaissanceenfant, Character sexeenfant, String niveau) {
        this.idenfant = idenfant;
        this.nomenfant = nomenfant;
        this.prenomenfant = prenomenfant;
        this.datadenaissanceenfant = datadenaissanceenfant;
        this.sexeenfant = sexeenfant;
        this.niveau = niveau;
    }

    public Integer getIdenfant() {
        return idenfant;
    }

    public void setIdenfant(Integer idenfant) {
        this.idenfant = idenfant;
    }

    public String getNomenfant() {
        return nomenfant;
    }

    public void setNomenfant(String nomenfant) {
        this.nomenfant = nomenfant;
    }

    public String getPrenomenfant() {
        return prenomenfant;
    }

    public void setPrenomenfant(String prenomenfant) {
        this.prenomenfant = prenomenfant;
    }

    public Date getDatadenaissanceenfant() {
        return datadenaissanceenfant;
    }

    public void setDatadenaissanceenfant(Date datadenaissanceenfant) {
        this.datadenaissanceenfant = datadenaissanceenfant;
    }

    public Character getSexeenfant() {
        return sexeenfant;
    }

    public void setSexeenfant(Character sexeenfant) {
        this.sexeenfant = sexeenfant;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Individu getIdindividu() {
        return idindividu;
    }

    public void setIdindividu(Individu idindividu) {
        this.idindividu = idindividu;
    }

    public Organisation getIdorganisation() {
        return idorganisation;
    }

    public void setIdorganisation(Organisation idorganisation) {
        this.idorganisation = idorganisation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenfant != null ? idenfant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfant)) {
            return false;
        }
        Enfant other = (Enfant) object;
        if ((this.idenfant == null && other.idenfant != null) || (this.idenfant != null && !this.idenfant.equals(other.idenfant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Enfant[ idenfant=" + idenfant + " ]";
    }
    
}
