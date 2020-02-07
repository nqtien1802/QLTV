/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Linh
 */
public class MuonTra {

    private String maSoMuonTra;
    private String maSoBanDoc;
    private Date ngayMuon;
    private Date hanTra;
    private Date ngayTra;
    private String maCanBo;
    private int soTienCoc;
    private int soTienPhat;

    public MuonTra() {
    }

    public String getMaSoMuonTra() {
        return maSoMuonTra;
    }

    public void setMaSoMuonTra(String maSoMuonTra) {
        this.maSoMuonTra = maSoMuonTra;
    }

    public String getMaSoBanDoc() {
        return maSoBanDoc;
    }

    public void setMaSoBanDoc(String maSoBanDoc) {
        this.maSoBanDoc = maSoBanDoc;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public int getSoTienPhat() {
        return soTienPhat;
    }

    public void setSoTienPhat(int soTienPhat) {
        this.soTienPhat = soTienPhat;
    }

    public int getSoTienCoc() {
        return soTienCoc;
    }

    public void setSoTienCoc(int soTienCoc) {
        this.soTienCoc = soTienCoc;
    }

    
    public MuonTra(String maSoMuonTra, String maSoBanDoc, Date ngayMuon, Date hanTra, Date ngayTra, String maCanBo, int soTienPhat, int soTienCoc) {
        this.maSoMuonTra = maSoMuonTra;
        this.maSoBanDoc = maSoBanDoc;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
        this.maCanBo = maCanBo;
        this.soTienPhat = soTienPhat;
        this.soTienCoc = soTienCoc;
    }
    
    
}
