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
@Table(name = "INSTITUTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i"),
    @NamedQuery(name = "Institution.findByIdinstitution", query = "SELECT i FROM Institution i WHERE i.idinstitution = :idinstitution"),
    @NamedQuery(name = "Institution.findByNominstitution", query = "SELECT i FROM Institution i WHERE i.nominstitution = :nominstitution"),
    @NamedQuery(name = "Institution.findByAdresseinstitution", query = "SELECT i FROM Institution i WHERE i.adresseinstitution = :adresseinstitution"),
    @NamedQuery(name = "Institution.findByTelephone", query = "SELECT i FROM Institution i WHERE i.telephone = :telephone"),
    @NamedQuery(name = "Institution.findByEmail", query = "SELECT i FROM Institution i WHERE i.email = :email"),
    @NamedQuery(name = "Institution.findByCategorie", query = "SELECT i FROM Institution i WHERE i.categorie = :categorie"),
    @NamedQuery(name = "Institution.findByWebsite", query = "SELECT i FROM Institution i WHERE i.website = :website")})
public class Institution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDINSTITUTION")
    private Integer idinstitution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMINSTITUTION")
    private String nominstitution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADRESSEINSTITUTION")
    private String adresseinstitution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TELEPHONE")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CATEGORIE")
    private String categorie;
    @Size(max = 50)
    @Column(name = "WEBSITE")
    private String website;
    @JoinColumn(name = "IDCOMMUNE", referencedColumnName = "IDCOMMUNE")
    @ManyToOne(optional = false)
    private Commune idcommune;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinstitution")
    private List<Programme> programmeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinstitution")
    private List<Financer> financerList;

    public Institution() {
    }

    public Institution(Integer idinstitution) {
        this.idinstitution = idinstitution;
    }

    public Institution(Integer idinstitution, String nominstitution, String adresseinstitution, String telephone, String email, String categorie) {
        this.idinstitution = idinstitution;
        this.nominstitution = nominstitution;
        this.adresseinstitution = adresseinstitution;
        this.telephone = telephone;
        this.email = email;
        this.categorie = categorie;
    }

    public Integer getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Integer idinstitution) {
        this.idinstitution = idinstitution;
    }

    public String getNominstitution() {
        return nominstitution;
    }

    public void setNominstitution(String nominstitution) {
        this.nominstitution = nominstitution;
    }

    public String getAdresseinstitution() {
        return adresseinstitution;
    }

    public void setAdresseinstitution(String adresseinstitution) {
        this.adresseinstitution = adresseinstitution;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Commune getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(Commune idcommune) {
        this.idcommune = idcommune;
    }

    @XmlTransient
    public List<Programme> getProgrammeList() {
        return programmeList;
    }

    public void setProgrammeList(List<Programme> programmeList) {
        this.programmeList = programmeList;
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
        hash += (idinstitution != null ? idinstitution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.idinstitution == null && other.idinstitution != null) || (this.idinstitution != null && !this.idinstitution.equals(other.idinstitution))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Institution[ idinstitution=" + idinstitution + " ]";
        //return nominstitution;
    }
    
}
