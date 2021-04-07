/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerHotel;

/**
 *
 * @author Hopeless
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ModelHotel.PelangganModel;
import ReserveHotel.view.MainView;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Hopeless
 */
public class PelangganController {
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(MainView view) {
        model.resetPelanggan();
    }
    public void insertPelanggan(MainView view) {
        String nama = view.getTxNama().getText();
        String alamat = view.getTxAlamat().getText();
        String telepon = view.getTxTelepon().getText();
        String email = view.getTxEmail().getText();
        String tglin = view.getTgl();
        String tglout = view.getTgl1();
        
        if (nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
            
        }else if (nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Melebihi dari 255 Karakter");
        }else if (telepon.length()>13){
            JOptionPane.showMessageDialog(view, "Nomor Telepon tidak melebih 13 digit");
        }else if (!email.contains("@") ||!email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            model.setTglin(tglin);
            model.setTglout(tglout);
            
            
            try{
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan!");
                model.resetPelanggan();
        }catch (Throwable throwable){
            JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", throwable.getMessage()});
                }
        }
        
        
    }
    public void updatePelanggan(MainView view) {
        if(view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang ingin di ubah ");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxId().getText());
        
        String nama = view.getTxNama1().getText();
        String alamat = view.getTxAlamat1().getText();
        String telepon = view.getTxTelepon1().getText();
        String email = view.getTxEmail1().getText();
        String tglin = view.getTgl2();
        String tglout = view.getTgl3();
        
        
        if (nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
            
        }else if (nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Melebihi dari 255 Karakter");
        }else if (telepon.length()>13){
            JOptionPane.showMessageDialog(view, "Nomor Telepon tidak melebih 13 digit");
        }else if (!email.contains("@") ||!email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            model.setTglin(tglin);
            model.setTglout(tglout);
            
            try{
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Diubah!");
                model.resetPelanggan();
        }catch (Throwable e){
            JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", e.getMessage()});
                }
        }
        
    }
    public void deletePelanggan(MainView view) {
        if(view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang ingin di ubah ");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Menghapus Data Tersebut ?")== JOptionPane.OK_OPTION){
            Integer id = Integer.parseInt(view.getTxId().getText());
            model.setId(id);
            
                    try{
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Dihapus!");
                model.resetPelanggan();
        }catch (Throwable e){
            JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", e.getMessage()});
                }
                    
        }
        
    }
            
}
