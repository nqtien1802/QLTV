/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Linh
 */
public class ChiTietMuon {
    private String maSoMuon;
    private String maSoSach;
    private String trangThai;

    public ChiTietMuon() {
    }

    public String getMaSoMuon() {
        return maSoMuon;
    }

    public void setMaSoMuon(String maSoMuon) {
        this.maSoMuon = maSoMuon;
    }

    public String getMaSoSach() {
        return maSoSach;
    }

    public void setMaSoSach(String maSoSach) {
        this.maSoSach = maSoSach;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    public ChiTietMuon(String maSoMuon, String maSoSach, String trangThai) {
        this.maSoMuon = maSoMuon;
        this.maSoSach = maSoSach;
        this.trangThai = trangThai;
    }
    
    
}
