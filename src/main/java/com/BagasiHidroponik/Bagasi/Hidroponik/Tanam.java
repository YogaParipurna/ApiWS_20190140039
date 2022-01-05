/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BagasiHidroponik.Bagasi.Hidroponik;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yapart
 */
@Entity
@Table(name = "tanam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tanam.findAll", query = "SELECT t FROM Tanam t"),
    @NamedQuery(name = "Tanam.findByKodeTanam", query = "SELECT t FROM Tanam t WHERE t.kodeTanam = :kodeTanam"),
    @NamedQuery(name = "Tanam.findByTanggal", query = "SELECT t FROM Tanam t WHERE t.tanggal = :tanggal"),
    @NamedQuery(name = "Tanam.findByBenih", query = "SELECT t FROM Tanam t WHERE t.benih = :benih"),
    @NamedQuery(name = "Tanam.findByVarietas", query = "SELECT t FROM Tanam t WHERE t.varietas = :varietas")})
public class Tanam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KodeTanam")
    private String kodeTanam;
    @Column(name = "Tanggal")
    private String tanggal;
    @Column(name = "Benih")
    private String benih;
    @Column(name = "Varietas")
    private String varietas;

    public Tanam() {
    }

    public Tanam(String kodeTanam) {
        this.kodeTanam = kodeTanam;
    }

    public String getKodeTanam() {
        return kodeTanam;
    }

    public void setKodeTanam(String kodeTanam) {
        this.kodeTanam = kodeTanam;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getBenih() {
        return benih;
    }

    public void setBenih(String benih) {
        this.benih = benih;
    }

    public String getVarietas() {
        return varietas;
    }

    public void setVarietas(String varietas) {
        this.varietas = varietas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeTanam != null ? kodeTanam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tanam)) {
            return false;
        }
        Tanam other = (Tanam) object;
        if ((this.kodeTanam == null && other.kodeTanam != null) || (this.kodeTanam != null && !this.kodeTanam.equals(other.kodeTanam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BagasiHidroponik.Bagasi.Hidroponik.Tanam[ kodeTanam=" + kodeTanam + " ]";
    }
    
}
