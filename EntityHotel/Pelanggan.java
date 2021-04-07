/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityHotel;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Hopeless
 */


import java.util.Objects;

/**
 *
 * @author Hopeless
 */
public class Pelanggan {
    
    private Integer id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    private String tglin;
    private String tglout;

public Pelanggan(){
    
}    

    public Pelanggan(String nama, String alamat, String telepon, String email, String tglin,String tglout) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
        this.tglin = tglin;
        this.tglout = tglout;
    }

    public String getTglin() {
        return tglin;
    }

    public void setTglin(String tglin) {
        this.tglin = tglin;
    }

    public String getTglout() {
        return tglout;
    }

    public void setTglout(String tglout) {
        this.tglout = tglout;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nama);
        hash = 59 * hash + Objects.hashCode(this.alamat);
        hash = 59 * hash + Objects.hashCode(this.telepon);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.tglin);
        hash = 59 * hash + Objects.hashCode(this.tglout);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelanggan other = (Pelanggan) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.telepon, other.telepon)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.tglin, other.tglin)) {
            return false;
        }
        if (!Objects.equals(this.tglout, other.tglout)) {
            return false;
        }
        return true;
    }
    
}


