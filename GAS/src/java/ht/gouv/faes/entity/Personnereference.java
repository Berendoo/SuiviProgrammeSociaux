/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "PERSONNEREFERENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnereference.findAll", query = "SELECT p FROM Personnereference p"),
    @NamedQuery(name = "Personnereference.findByIdprf", query = "SELECT p FROM Personnereference p WHERE p.idprf = :idprf"),
    @NamedQuery(name = "Personnereference.findByNomprf", query = "SELECT p FROM Personnereference p WHERE p.nomprf = :nomprf"),
    @NamedQuery(name = "Personnereference.findByPrenomprf", query = "SELECT p FROM Personnereference p WHERE p.prenomprf = :prenomprf"),
    @NamedQuery(name = "Personnereference.findByAdresseprf", query = "SELECT p FROM Personnereference p WHERE p.adresseprf = :adresseprf"),
    @NamedQuery(name = "Personnereference.findByCinprf", query = "SELECT p FROM Personnereference p WHERE p.cinprf = :cinprf"),
    @NamedQuery(name = "Personnereference.findByTelephoneprf", query = "SELECT p FROM Personnereference p WHERE p.telephoneprf = :telephoneprf"),
    @NamedQuery(name = "Personnereference.findByFonction", query = "SELECT p FROM Personnereference p WHERE p.fonction = :fonction"),
    @NamedQuery(name = "Personnereference.findBySexeprf", query = "SELECT p FROM Personnereference p WHERE p.sexeprf = :sexeprf"),
    @NamedQuery(name = "Personnereference.findByEmailprf", query = "SELECT p FROM Personnereference p WHERE p.emailprf = :emailprf")})
public class Personnereference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDPRF")
    private Integer idprf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMPRF")
    private String nomprf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOMPRF")
    private String prenomprf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADRESSEPRF")
    private String adresseprf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "CINPRF")
    private String cinprf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEPHONEPRF")
    private String telephoneprf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FONCTION")
    private String fonction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXEPRF")
    private String sexeprf;
    @Size(max = 50)
    @Column(name = "EMAILPRF")
    private String emailprf;
    @JoinColumn(name = "IDCOMMUNE", referencedColumnName = "IDCOMMUNE")
    @ManyToOne(optional = false)
    private Commune idcommune;
    @JoinColumn(name = "IDORGANISATION", referencedColumnName = "IDORGANISATION")
    @ManyToOne(optional = false)
    private Organisation idorganisation;
    @JoinColumn(name = "IDTYPEPOC", referencedColumnName = "IDTYPEPOC")
    @ManyToOne(optional = false)
    private Typepoc idtypepoc;
    @OneToMany(mappedBy = "idprf")
    private List<Individu> individuList;

    public Personnereference() {
    }

    public Personnereference(Integer idprf) {
        this.idprf = idprf;
    }

    public Personnereference(Integer idprf, String nomprf, String prenomprf, String adresseprf, String cinprf, String telephoneprf, String fonction, String sexeprf) {
        this.idprf = idprf;
        this.nomprf = nomprf;
        this.prenomprf = prenomprf;
        this.adresseprf = adresseprf;
        this.cinprf = cinprf;
        this.telephoneprf = telephoneprf;
        this.fonction = fonction;
        this.sexeprf = sexeprf;
    }

    public Integer getIdprf() {
        return idprf;
    }

    public void setIdprf(Integer idprf) {
        this.idprf = idprf;
    }

    public String getNomprf() {
        return nomprf;
    }

    public void setNomprf(String nomprf) {
        this.nomprf = nomprf;
    }

    public String getPrenomprf() {
        return prenomprf;
    }

    public void setPrenomprf(String prenomprf) {
        this.prenomprf = prenomprf;
    }

    public String getAdresseprf() {
        return adresseprf;
    }

    public void setAdresseprf(String adresseprf) {
        this.adresseprf = adresseprf;
    }

    public String getCinprf() {
        return cinprf;
    }

    public void setCinprf(String cinprf) {
        this.cinprf = cinprf;
    }

    public String getTelephoneprf() {
        return telephoneprf;
    }

    public void setTelephoneprf(String telephoneprf) {
        this.telephoneprf = telephoneprf;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getSexeprf() {
        return sexeprf;
    }

    public void setSexeprf(String sexeprf) {
        this.sexeprf = sexeprf;
    }

    public String getEmailprf() {
        return emailprf;
    }

    public void setEmailprf(String emailprf) {
        this.emailprf = emailprf;
    }

    public Commune getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(Commune idcommune) {
        this.idcommune = idcommune;
    }

    public Organisation getIdorganisation() {
        return idorganisation;
    }

    public void setIdorganisation(Organisation idorganisation) {
        this.idorganisation = idorganisation;
    }

    public Typepoc getIdtypepoc() {
        return idtypepoc;
    }

    public void setIdtypepoc(Typepoc idtypepoc) {
        this.idtypepoc = idtypepoc;
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
        hash += (idprf != null ? idprf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnereference)) {
            return false;
        }
        Personnereference other = (Personnereference) object;
        if ((this.idprf == null && other.idprf != null) || (this.idprf != null && !this.idprf.equals(other.idprf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Personnereference[ idprf=" + idprf + " ]";
    }
    
}
