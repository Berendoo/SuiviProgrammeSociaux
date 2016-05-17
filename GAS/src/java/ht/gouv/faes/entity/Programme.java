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
import javax.persistence.Lob;
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
@Table(name = "PROGRAMME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programme.findAll", query = "SELECT p FROM Programme p"),
    @NamedQuery(name = "Programme.findByIdprogramme", query = "SELECT p FROM Programme p WHERE p.idprogramme = :idprogramme"),
    @NamedQuery(name = "Programme.findByNomprogramme", query = "SELECT p FROM Programme p WHERE p.nomprogramme = :nomprogramme"),
    @NamedQuery(name = "Programme.findByDescription", query = "SELECT p FROM Programme p WHERE p.description = :description")})
public class Programme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDPROGRAMME")
    private Integer idprogramme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMPROGRAMME")
    private String nomprogramme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Column(name = "LOGO")
    private byte[] logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprogramme")
    private List<Projet> projetList;
    @JoinColumn(name = "IDINSTITUTION", referencedColumnName = "IDINSTITUTION")
    @ManyToOne(optional = false)
    private Institution idinstitution;

    public Programme() {
    }

    public Programme(Integer idprogramme) {
        this.idprogramme = idprogramme;
    }

    public Programme(Integer idprogramme, String nomprogramme, String description) {
        this.idprogramme = idprogramme;
        this.nomprogramme = nomprogramme;
        this.description = description;
    }

    public Integer getIdprogramme() {
        return idprogramme;
    }

    public void setIdprogramme(Integer idprogramme) {
        this.idprogramme = idprogramme;
    }

    public String getNomprogramme() {
        return nomprogramme;
    }

    public void setNomprogramme(String nomprogramme) {
        this.nomprogramme = nomprogramme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @XmlTransient
    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprogramme != null ? idprogramme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.idprogramme == null && other.idprogramme != null) || (this.idprogramme != null && !this.idprogramme.equals(other.idprogramme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "ht.gouv.faes.entity.Programme[ idprogramme=" + idprogramme + " ]";
        return nomprogramme;
    }
    
}
