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
@Table(name = "DONATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donateur.findAll", query = "SELECT d FROM Donateur d"),
    @NamedQuery(name = "Donateur.findByIddonateur", query = "SELECT d FROM Donateur d WHERE d.iddonateur = :iddonateur"),
    @NamedQuery(name = "Donateur.findByNomdonateur", query = "SELECT d FROM Donateur d WHERE d.nomdonateur = :nomdonateur"),
    @NamedQuery(name = "Donateur.findByAdresse", query = "SELECT d FROM Donateur d WHERE d.adresse = :adresse"),
    @NamedQuery(name = "Donateur.findByTelephone1", query = "SELECT d FROM Donateur d WHERE d.telephone1 = :telephone1"),
    @NamedQuery(name = "Donateur.findByTelephone2", query = "SELECT d FROM Donateur d WHERE d.telephone2 = :telephone2"),
    @NamedQuery(name = "Donateur.findBySiege", query = "SELECT d FROM Donateur d WHERE d.siege = :siege"),
    @NamedQuery(name = "Donateur.findByWebsite", query = "SELECT d FROM Donateur d WHERE d.website = :website"),
    @NamedQuery(name = "Donateur.findByTypedonateur", query = "SELECT d FROM Donateur d WHERE d.typedonateur = :typedonateur"),
    @NamedQuery(name = "Donateur.findByEmail", query = "SELECT d FROM Donateur d WHERE d.email = :email")})
public class Donateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDDONATEUR")
    private Integer iddonateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMDONATEUR")
    private String nomdonateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADRESSE")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEPHONE1")
    private String telephone1;
    @Size(max = 15)
    @Column(name = "TELEPHONE2")
    private String telephone2;
    @Size(max = 50)
    @Column(name = "SIEGE")
    private String siege;
    @Size(max = 50)
    @Column(name = "WEBSITE")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TYPEDONATEUR")
    private String typedonateur;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddonateur")
    private List<Financer> financerList;

    public Donateur() {
    }

    public Donateur(Integer iddonateur) {
        this.iddonateur = iddonateur;
    }

    public Donateur(Integer iddonateur, String nomdonateur, String adresse, String telephone1, String typedonateur, String email) {
        this.iddonateur = iddonateur;
        this.nomdonateur = nomdonateur;
        this.adresse = adresse;
        this.telephone1 = telephone1;
        this.typedonateur = typedonateur;
        this.email = email;
    }

    public Integer getIddonateur() {
        return iddonateur;
    }

    public void setIddonateur(Integer iddonateur) {
        this.iddonateur = iddonateur;
    }

    public String getNomdonateur() {
        return nomdonateur;
    }

    public void setNomdonateur(String nomdonateur) {
        this.nomdonateur = nomdonateur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTypedonateur() {
        return typedonateur;
    }

    public void setTypedonateur(String typedonateur) {
        this.typedonateur = typedonateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Financer> getFinancerList() {
        return financerList;
    }

    public void setFinancerList(List<Financer> financerList) {
        this.financerList = financerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddonateur != null ? iddonateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donateur)) {
            return false;
        }
        Donateur other = (Donateur) object;
        if ((this.iddonateur == null && other.iddonateur != null) || (this.iddonateur != null && !this.iddonateur.equals(other.iddonateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Donateur[ iddonateur=" + iddonateur + " ]";
        return nomdonateur;
    }
    
}
