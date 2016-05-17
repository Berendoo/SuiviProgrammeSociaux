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
@Table(name = "ORGANISATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organisation.findAll", query = "SELECT o FROM Organisation o"),
    @NamedQuery(name = "Organisation.findByIdorganisation", query = "SELECT o FROM Organisation o WHERE o.idorganisation = :idorganisation"),
    @NamedQuery(name = "Organisation.findByNomorganisation", query = "SELECT o FROM Organisation o WHERE o.nomorganisation = :nomorganisation"),
    @NamedQuery(name = "Organisation.findByAdresseorganisation", query = "SELECT o FROM Organisation o WHERE o.adresseorganisation = :adresseorganisation"),
    @NamedQuery(name = "Organisation.findByCommentaire", query = "SELECT o FROM Organisation o WHERE o.commentaire = :commentaire")})
public class Organisation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDORGANISATION")
    private Integer idorganisation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMORGANISATION")
    private String nomorganisation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ADRESSEORGANISATION")
    private String adresseorganisation;
    @Size(max = 150)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorganisation")
    private List<Enfant> enfantList;
    @JoinColumn(name = "IDCOMMUNE", referencedColumnName = "IDCOMMUNE")
    @ManyToOne(optional = false)
    private Commune idcommune;
    @JoinColumn(name = "IDTYPEORGANISATION", referencedColumnName = "IDTYPEORGANISATION")
    @ManyToOne(optional = false)
    private Typeorganistation idtypeorganisation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorganisation")
    private List<Personnereference> personnereferenceList;
    @OneToMany(mappedBy = "idorganisation")
    private List<Individu> individuList;

    public Organisation() {
    }

    public Organisation(Integer idorganisation) {
        this.idorganisation = idorganisation;
    }

    public Organisation(Integer idorganisation, String nomorganisation, String adresseorganisation) {
        this.idorganisation = idorganisation;
        this.nomorganisation = nomorganisation;
        this.adresseorganisation = adresseorganisation;
    }

    public Integer getIdorganisation() {
        return idorganisation;
    }

    public void setIdorganisation(Integer idorganisation) {
        this.idorganisation = idorganisation;
    }

    public String getNomorganisation() {
        return nomorganisation;
    }

    public void setNomorganisation(String nomorganisation) {
        this.nomorganisation = nomorganisation;
    }

    public String getAdresseorganisation() {
        return adresseorganisation;
    }

    public void setAdresseorganisation(String adresseorganisation) {
        this.adresseorganisation = adresseorganisation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @XmlTransient
    public List<Enfant> getEnfantList() {
        return enfantList;
    }

    public void setEnfantList(List<Enfant> enfantList) {
        this.enfantList = enfantList;
    }

    public Commune getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(Commune idcommune) {
        this.idcommune = idcommune;
    }

    public Typeorganistation getIdtypeorganisation() {
        return idtypeorganisation;
    }

    public void setIdtypeorganisation(Typeorganistation idtypeorganisation) {
        this.idtypeorganisation = idtypeorganisation;
    }

    @XmlTransient
    public List<Personnereference> getPersonnereferenceList() {
        return personnereferenceList;
    }

    public void setPersonnereferenceList(List<Personnereference> personnereferenceList) {
        this.personnereferenceList = personnereferenceList;
    }

    @XmlTransient
    public List<Individu> getIndividuList() {
        return individuList;
    }

    public void setIndividuList(List<Individu> individuList) {
        this.individuList = individuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorganisation != null ? idorganisation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisation)) {
            return false;
        }
        Organisation other = (Organisation) object;
        if ((this.idorganisation == null && other.idorganisation != null) || (this.idorganisation != null && !this.idorganisation.equals(other.idorganisation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Organisation[ idorganisation=" + idorganisation + " ]";
        return nomorganisation;
    }
    
}
