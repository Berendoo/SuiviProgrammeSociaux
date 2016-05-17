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
@Table(name = "FINANCER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financer.findAll", query = "SELECT f FROM Financer f"),
    @NamedQuery(name = "Financer.findByIdfinancer", query = "SELECT f FROM Financer f WHERE f.idfinancer = :idfinancer"),
    @NamedQuery(name = "Financer.findByDate", query = "SELECT f FROM Financer f WHERE f.date = :date"),
    @NamedQuery(name = "Financer.findByDon", query = "SELECT f FROM Financer f WHERE f.don = :don")})
public class Financer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDFINANCER")
    private Integer idfinancer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DON")
    private String don;
    @JoinColumn(name = "IDDONATEUR", referencedColumnName = "IDDONATEUR")
    @ManyToOne(optional = false)
    private Donateur iddonateur;
    @JoinColumn(name = "IDINSTITUTION", referencedColumnName = "IDINSTITUTION")
    @ManyToOne(optional = false)
    private Institution idinstitution;

    public Financer() {
    }

    public Financer(Integer idfinancer) {
        this.idfinancer = idfinancer;
    }

    public Financer(Integer idfinancer, Date date, String don) {
        this.idfinancer = idfinancer;
        this.date = date;
        this.don = don;
    }

    public Integer getIdfinancer() {
        return idfinancer;
    }

    public void setIdfinancer(Integer idfinancer) {
        this.idfinancer = idfinancer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDon() {
        return don;
    }

    public void setDon(String don) {
        this.don = don;
    }

    public Donateur getIddonateur() {
        return iddonateur;
    }

    public void setIddonateur(Donateur iddonateur) {
        this.iddonateur = iddonateur;
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
        hash += (idfinancer != null ? idfinancer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Financer)) {
            return false;
        }
        Financer other = (Financer) object;
        if ((this.idfinancer == null && other.idfinancer != null) || (this.idfinancer != null && !this.idfinancer.equals(other.idfinancer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Financer[ idfinancer=" + idfinancer + " ]";
    }
    
}
