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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "INDIVIDU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Individu.findAll", query = "SELECT i FROM Individu i"),
    @NamedQuery(name = "Individu.findByIdindividu", query = "SELECT i FROM Individu i WHERE i.idindividu = :idindividu"),
    @NamedQuery(name = "Individu.findByNom", query = "SELECT i FROM Individu i WHERE i.nom = :nom"),
    @NamedQuery(name = "Individu.findByPrenom", query = "SELECT i FROM Individu i WHERE i.prenom = :prenom"),
    @NamedQuery(name = "Individu.findByDatenaissance", query = "SELECT i FROM Individu i WHERE i.datenaissance = :datenaissance"),
    @NamedQuery(name = "Individu.findByCin", query = "SELECT i FROM Individu i WHERE i.cin = :cin"),
    @NamedQuery(name = "Individu.findByTelephone", query = "SELECT i FROM Individu i WHERE i.telephone = :telephone"),
    @NamedQuery(name = "Individu.findByTelephone2", query = "SELECT i FROM Individu i WHERE i.telephone2 = :telephone2"),
    @NamedQuery(name = "Individu.findBySexe", query = "SELECT i FROM Individu i WHERE i.sexe = :sexe"),
    @NamedQuery(name = "Individu.findByEmail", query = "SELECT i FROM Individu i WHERE i.email = :email"),
    @NamedQuery(name = "Individu.findByLieunaissance", query = "SELECT i FROM Individu i WHERE i.lieunaissance = :lieunaissance"),
    @NamedQuery(name = "Individu.findByAdresse", query = "SELECT i FROM Individu i WHERE i.adresse = :adresse"),
    @NamedQuery(name = "Individu.findByDateenregistrement", query = "SELECT i FROM Individu i WHERE i.dateenregistrement = :dateenregistrement"),
    @NamedQuery(name = "Individu.findByNiveau", query = "SELECT i FROM Individu i WHERE i.niveau = :niveau")})
public class Individu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDINDIVIDU")
    private Integer idindividu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATENAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "CIN")
    private String cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 15)
    @Column(name = "TELEPHONE2")
    private String telephone2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXE")
    private Character sexe;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "LIEUNAISSANCE")
    private String lieunaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "DATEENREGISTREMENT")
    @Temporal(TemporalType.DATE)
    private Date dateenregistrement;
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;
    @Lob
    @Column(name = "EMPREINTE")
    private byte[] empreinte;
    @Size(max = 15)
    @Column(name = "NIVEAU")
    private String niveau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idindividu")
    private List<Dossierbeneficiaire> dossierbeneficiaireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idindividu")
    private List<Enfant> enfantList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "individu")
    private Utilisateur utilisateur;
    @JoinColumn(name = "IDORGANISATION", referencedColumnName = "IDORGANISATION")
    @ManyToOne
    private Organisation idorganisation;
    @JoinColumn(name = "IDPRF", referencedColumnName = "IDPRF")
    @ManyToOne
    private Personnereference idprf;

    public Individu() {
    }

    public Individu(Integer idindividu) {
        this.idindividu = idindividu;
    }

    public Individu(Integer idindividu, String nom, String prenom, Date datenaissance, String cin, String telephone, Character sexe, String email, String adresse) {
        this.idindividu = idindividu;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.cin = cin;
        this.telephone = telephone;
        this.sexe = sexe;
        this.email = email;
        this.adresse = adresse;
    }

    public Integer getIdindividu() {
        return idindividu;
    }

    public void setIdindividu(Integer idindividu) {
        this.idindividu = idindividu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLieunaissance() {
        return lieunaissance;
    }

    public void setLieunaissance(String lieunaissance) {
        this.lieunaissance = lieunaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateenregistrement() {
        return dateenregistrement;
    }

    public void setDateenregistrement(Date dateenregistrement) {
        this.dateenregistrement = dateenregistrement;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(byte[] empreinte) {
        this.empreinte = empreinte;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @XmlTransient
    public List<Dossierbeneficiaire> getDossierbeneficiaireList() {
        return dossierbeneficiaireList;
    }

    public void setDossierbeneficiaireList(List<Dossierbeneficiaire> dossierbeneficiaireList) {
        this.dossierbeneficiaireList = dossierbeneficiaireList;
    }

    @XmlTransient
    public List<Enfant> getEnfantList() {
        return enfantList;
    }

    public void setEnfantList(List<Enfant> enfantList) {
        this.enfantList = enfantList;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Organisation getIdorganisation() {
        return idorganisation;
    }

    public void setIdorganisation(Organisation idorganisation) {
        this.idorganisation = idorganisation;
    }

    public Personnereference getIdprf() {
        return idprf;
    }

    public void setIdprf(Personnereference idprf) {
        this.idprf = idprf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idindividu != null ? idindividu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Individu)) {
            return false;
        }
        Individu other = (Individu) object;
        if ((this.idindividu == null && other.idindividu != null) || (this.idindividu != null && !this.idindividu.equals(other.idindividu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Individu[ idindividu=" + idindividu + " ]";
    }
    
}
