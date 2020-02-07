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
public class NhanVien {
    private String maSo;
    private String matKhau;
    private String hoTen;
    private String chucVu;
    private int namSinh;
    private String soDienThoai;

    public NhanVien(String maSo, String matKhau, String hoTen, String chucVu, int namSinh, String soDienThoai) {
        this.maSo = maSo;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
    }

    public NhanVien(){
    }
    
    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
}
