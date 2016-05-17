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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdindividu", query = "SELECT u FROM Utilisateur u WHERE u.idindividu = :idindividu"),
    @NamedQuery(name = "Utilisateur.findByUsername", query = "SELECT u FROM Utilisateur u WHERE u.username = :username"),
    @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateur.findByDatecreation", query = "SELECT u FROM Utilisateur u WHERE u.datecreation = :datecreation"),
    @NamedQuery(name = "Utilisateur.findByDateexpiration", query = "SELECT u FROM Utilisateur u WHERE u.dateexpiration = :dateexpiration"),
    @NamedQuery(name = "Utilisateur.findByStatut", query = "SELECT u FROM Utilisateur u WHERE u.statut = :statut")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDINDIVIDU")
    private Integer idindividu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECREATION")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEEXPIRATION")
    @Temporal(TemporalType.DATE)
    private Date dateexpiration;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "STATUT")
    private String statut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idindividu")
    private List<Log> logList;
    @JoinColumn(name = "IDINDIVIDU", referencedColumnName = "IDINDIVIDU", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Individu individu;
    @JoinColumn(name = "IDPRIVILEGE", referencedColumnName = "IDPRIVILEGE")
    @ManyToOne(optional = false)
    private Roles idprivilege;

    public Utilisateur() {
    }

    public Utilisateur(Integer idindividu) {
        this.idindividu = idindividu;
    }

    public Utilisateur(Integer idindividu, String username, String password, Date datecreation, Date dateexpiration, String statut) {
        this.idindividu = idindividu;
        this.username = username;
        this.password = password;
        this.datecreation = datecreation;
        this.dateexpiration = dateexpiration;
        this.statut = statut;
    }

    public Integer getIdindividu() {
        return idindividu;
    }

    public void setIdindividu(Integer idindividu) {
        this.idindividu = idindividu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @XmlTransient
    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public Individu getIndividu() {
        return individu;
    }

    public void setIndividu(Individu individu) {
        this.individu = individu;
    }

    public Roles getIdprivilege() {
        return idprivilege;
    }

    public void setIdprivilege(Roles idprivilege) {
        this.idprivilege = idprivilege;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idindividu == null && other.idindividu != null) || (this.idindividu != null && !this.idindividu.equals(other.idindividu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Utilisateur[ idindividu=" + idindividu + " ]";
    }
    
}
