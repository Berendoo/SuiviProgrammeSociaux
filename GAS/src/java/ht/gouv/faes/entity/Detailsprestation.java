/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "DETAILSPRESTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailsprestation.findAll", query = "SELECT d FROM Detailsprestation d"),
    @NamedQuery(name = "Detailsprestation.findByIddetailsprestation", query = "SELECT d FROM Detailsprestation d WHERE d.iddetailsprestation = :iddetailsprestation"),
    @NamedQuery(name = "Detailsprestation.findByQuantite", query = "SELECT d FROM Detailsprestation d WHERE d.quantite = :quantite"),
    @NamedQuery(name = "Detailsprestation.findByDatelivraison", query = "SELECT d FROM Detailsprestation d WHERE d.datelivraison = :datelivraison"),
    @NamedQuery(name = "Detailsprestation.findByNofacture", query = "SELECT d FROM Detailsprestation d WHERE d.nofacture = :nofacture"),
    @NamedQuery(name = "Detailsprestation.findByCin", query = "SELECT d FROM Detailsprestation d WHERE d.cin = :cin"),
    @NamedQuery(name = "Detailsprestation.findByDatelancement", query = "SELECT d FROM Detailsprestation d WHERE d.datelancement = :datelancement"),
    @NamedQuery(name = "Detailsprestation.findByPin", query = "SELECT d FROM Detailsprestation d WHERE d.pin = :pin"),
    @NamedQuery(name = "Detailsprestation.findByPeriode", query = "SELECT d FROM Detailsprestation d WHERE d.periode = :periode"),
    @NamedQuery(name = "Detailsprestation.findByMontant", query = "SELECT d FROM Detailsprestation d WHERE d.montant = :montant"),
    @NamedQuery(name = "Detailsprestation.findByDevise", query = "SELECT d FROM Detailsprestation d WHERE d.devise = :devise"),
    @NamedQuery(name = "Detailsprestation.findByPyPayerId", query = "SELECT d FROM Detailsprestation d WHERE d.pyPayerId = :pyPayerId"),
    @NamedQuery(name = "Detailsprestation.findByPyPayrollNo", query = "SELECT d FROM Detailsprestation d WHERE d.pyPayrollNo = :pyPayrollNo"),
    @NamedQuery(name = "Detailsprestation.findByPyPayeeId", query = "SELECT d FROM Detailsprestation d WHERE d.pyPayeeId = :pyPayeeId"),
    @NamedQuery(name = "Detailsprestation.findByDossier", query = "SELECT d FROM Detailsprestation d WHERE d.dossier = :dossier"),
    @NamedQuery(name = "Detailsprestation.findByNumeroch", query = "SELECT d FROM Detailsprestation d WHERE d.numeroch = :numeroch"),
    @NamedQuery(name = "Detailsprestation.findBySerie", query = "SELECT d FROM Detailsprestation d WHERE d.serie = :serie")})
public class Detailsprestation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    @Column(name = "IDDETAILSPRESTATION")
    private Integer iddetailsprestation;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "DATELIVRAISON")
    @Temporal(TemporalType.DATE)
    private Date datelivraison;
    @Size(max = 15)
    @Column(name = "NOFACTURE")
    private String nofacture;
    @Size(max = 17)
    @Column(name = "CIN")
    private String cin;
    @Column(name = "DATELANCEMENT")
    @Temporal(TemporalType.DATE)
    private Date datelancement;
    @Size(max = 10)
    @Column(name = "PIN")
    private String pin;
    @Size(max = 15)
    @Column(name = "PERIODE")
    private String periode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private BigDecimal montant;
    @Column(name = "DEVISE")
    private BigDecimal devise;
    @Size(max = 15)
    @Column(name = "PY_PAYER_ID")
    private String pyPayerId;
    @Size(max = 15)
    @Column(name = "PY_PAYROLL_NO")
    private String pyPayrollNo;
    @Size(max = 15)
    @Column(name = "PY_PAYEE_ID")
    private String pyPayeeId;
    @Size(max = 10)
    @Column(name = "DOSSIER")
    private String dossier;
    @Size(max = 10)
    @Column(name = "NUMEROCH")
    private String numeroch;
    @Size(max = 15)
    @Column(name = "SERIE")
    private String serie;
    @JoinColumn(name = "IDCOMMUNE", referencedColumnName = "IDCOMMUNE")
    @ManyToOne(optional = false)
    private Commune idcommune;
    @JoinColumn(name = "IDFICHE", referencedColumnName = "IDFICHE")
    @ManyToOne(optional = false)
    private Fichebeneficiaire idfiche;
    @JoinColumn(name = "IDPRESTATION", referencedColumnName = "IDPRESTATION")
    @ManyToOne(optional = false)
    private Prestation idprestation;

    public Detailsprestation() {
    }

    public Detailsprestation(Integer iddetailsprestation) {
        this.iddetailsprestation = iddetailsprestation;
    }

    public Integer getIddetailsprestation() {
        return iddetailsprestation;
    }

    public void setIddetailsprestation(Integer iddetailsprestation) {
        this.iddetailsprestation = iddetailsprestation;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDatelivraison() {
        return datelivraison;
    }

    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }

    public String getNofacture() {
        return nofacture;
    }

    public void setNofacture(String nofacture) {
        this.nofacture = nofacture;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDatelancement() {
        return datelancement;
    }

    public void setDatelancement(Date datelancement) {
        this.datelancement = datelancement;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getDevise() {
        return devise;
    }

    public void setDevise(BigDecimal devise) {
        this.devise = devise;
    }

    public String getPyPayerId() {
        return pyPayerId;
    }

    public void setPyPayerId(String pyPayerId) {
        this.pyPayerId = pyPayerId;
    }

    public String getPyPayrollNo() {
        return pyPayrollNo;
    }

    public void setPyPayrollNo(String pyPayrollNo) {
        this.pyPayrollNo = pyPayrollNo;
    }

    public String getPyPayeeId() {
        return pyPayeeId;
    }

    public void setPyPayeeId(String pyPayeeId) {
        this.pyPayeeId = pyPayeeId;
    }

    public String getDossier() {
        return dossier;
    }

    public void setDossier(String dossier) {
        this.dossier = dossier;
    }

    public String getNumeroch() {
        return numeroch;
    }

    public void setNumeroch(String numeroch) {
        this.numeroch = numeroch;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Commune getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(Commune idcommune) {
        this.idcommune = idcommune;
    }

    public Fichebeneficiaire getIdfiche() {
        return idfiche;
    }

    public void setIdfiche(Fichebeneficiaire idfiche) {
        this.idfiche = idfiche;
    }

    public Prestation getIdprestation() {
        return idprestation;
    }

    public void setIdprestation(Prestation idprestation) {
        this.idprestation = idprestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetailsprestation != null ? iddetailsprestation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailsprestation)) {
            return false;
        }
        Detailsprestation other = (Detailsprestation) object;
        if ((this.iddetailsprestation == null && other.iddetailsprestation != null) || (this.iddetailsprestation != null && !this.iddetailsprestation.equals(other.iddetailsprestation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Detailsprestation[ iddetailsprestation=" + iddetailsprestation + " ]";
    }
    
}
