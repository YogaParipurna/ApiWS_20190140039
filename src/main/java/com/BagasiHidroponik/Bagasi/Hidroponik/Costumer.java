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
@Table(name = "costumer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costumer.findAll", query = "SELECT c FROM Costumer c"),
    @NamedQuery(name = "Costumer.findById", query = "SELECT c FROM Costumer c WHERE c.id = :id"),
    @NamedQuery(name = "Costumer.findByNamaCustomer", query = "SELECT c FROM Costumer c WHERE c.namaCustomer = :namaCustomer"),
    @NamedQuery(name = "Costumer.findByAsalKontak", query = "SELECT c FROM Costumer c WHERE c.asalKontak = :asalKontak"),
    @NamedQuery(name = "Costumer.findByNomerHp", query = "SELECT c FROM Costumer c WHERE c.nomerHp = :nomerHp")})
public class Costumer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "NamaCustomer")
    private String namaCustomer;
    @Column(name = "AsalKontak")
    private String asalKontak;
    @Column(name = "NomerHp")
    private String nomerHp;

    public Costumer(Integer id, String namaCustomer, String asalKontak, String nomerHp) {
        this.id = id;
        this.namaCustomer = namaCustomer;
        this.asalKontak = asalKontak;
        this.nomerHp = nomerHp;
    }
    
    public Costumer() {
    }
    
    public Costumer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getAsalKontak() {
        return asalKontak;
    }

    public void setAsalKontak(String asalKontak) {
        this.asalKontak = asalKontak;
    }

    public String getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(String nomerHp) {
        this.nomerHp = nomerHp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costumer)) {
            return false;
        }
        Costumer other = (Costumer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "com.BagasiHidroponik.Bagasi.Hidroponik.Costumer[ id=" + id + " ]";
        return "id; = " + getId() + "Nama Costumer = "+ getNamaCustomer()+"Asal Kontak = "+getAsalKontak()+"Nomor HP = "+getNomerHp();
    }
    
}
