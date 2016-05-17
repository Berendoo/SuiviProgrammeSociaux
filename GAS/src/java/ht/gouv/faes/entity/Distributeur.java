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
@Table(name = "DISTRIBUTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distributeur.findAll", query = "SELECT d FROM Distributeur d"),
    @NamedQuery(name = "Distributeur.findByIddistributeur", query = "SELECT d FROM Distributeur d WHERE d.iddistributeur = :iddistributeur"),
    @NamedQuery(name = "Distributeur.findByNomdistributeur", query = "SELECT d FROM Distributeur d WHERE d.nomdistributeur = :nomdistributeur"),
    @NamedQuery(name = "Distributeur.findByTelephone", query = "SELECT d FROM Distributeur d WHERE d.telephone = :telephone"),
    @NamedQuery(name = "Distributeur.findByEmaildistributeur", query = "SELECT d FROM Distributeur d WHERE d.emaildistributeur = :emaildistributeur"),
    @NamedQuery(name = "Distributeur.findByAdressedistributeur", query = "SELECT d FROM Distributeur d WHERE d.adressedistributeur = :adressedistributeur"),
    @NamedQuery(name = "Distributeur.findByNumeropatente", query = "SELECT d FROM Distributeur d WHERE d.numeropatente = :numeropatente"),
    @NamedQuery(name = "Distributeur.findByNif", query = "SELECT d FROM Distributeur d WHERE d.nif = :nif"),
    @NamedQuery(name = "Distributeur.findByRaisonsociale", query = "SELECT d FROM Distributeur d WHERE d.raisonsociale = :raisonsociale")})
public class Distributeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDDISTRIBUTEUR")
    private Integer iddistributeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMDISTRIBUTEUR")
    private String nomdistributeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAILDISTRIBUTEUR")
    private String emaildistributeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ADRESSEDISTRIBUTEUR")
    private String adressedistributeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NUMEROPATENTE")
    private String numeropatente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NIF")
    private String nif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "RAISONSOCIALE")
    private String raisonsociale;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddistributeur")
    private List<Contrat> contratList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddistributeur")
    private List<Prestation> prestationList;
    @JoinColumn(name = "IDCOMMUNE", referencedColumnName = "IDCOMMUNE")
    @ManyToOne(optional = false)
    private Commune idcommune;

    public Distributeur() {
    }

    public Distributeur(Integer iddistributeur) {
        this.iddistributeur = iddistributeur;
    }

    public Distributeur(Integer iddistributeur, String nomdistributeur, String telephone, String emaildistributeur, String adressedistributeur, String numeropatente, String nif, String raisonsociale) {
        this.iddistributeur = iddistributeur;
        this.nomdistributeur = nomdistributeur;
        this.telephone = telephone;
        this.emaildistributeur = emaildistributeur;
        this.adressedistributeur = adressedistributeur;
        this.numeropatente = numeropatente;
        this.nif = nif;
        this.raisonsociale = raisonsociale;
    }

    public Integer getIddistributeur() {
        return iddistributeur;
    }

    public void setIddistributeur(Integer iddistributeur) {
        this.iddistributeur = iddistributeur;
    }

    public String getNomdistributeur() {
        return nomdistributeur;
    }

    public void setNomdistributeur(String nomdistributeur) {
        this.nomdistributeur = nomdistributeur;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmaildistributeur() {
        return emaildistributeur;
    }

    public void setEmaildistributeur(String emaildistributeur) {
        this.emaildistributeur = emaildistributeur;
    }

    public String getAdressedistributeur() {
        return adressedistributeur;
    }

    public void setAdressedistributeur(String adressedistributeur) {
        this.adressedistributeur = adressedistributeur;
    }

    public String getNumeropatente() {
        return numeropatente;
    }

    public void setNumeropatente(String numeropatente) {
        this.numeropatente = numeropatente;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    @XmlTransient
    public List<Prestation> getPrestationList() {
        return prestationList;
    }

    public void setPrestationList(List<Prestation> prestationList) {
        this.prestationList = prestationList;
    }

    public Commune getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(Commune idcommune) {
        this.idcommune = idcommune;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddistributeur != null ? iddistributeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distributeur)) {
            return false;
        }
        Distributeur other = (Distributeur) object;
        if ((this.iddistributeur == null && other.iddistributeur != null) || (this.iddistributeur != null && !this.iddistributeur.equals(other.iddistributeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Distributeur[ iddistributeur=" + iddistributeur + " ]";
        return nomdistributeur;
    }
    
}
