/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Sach;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @
 */
public class SachBusiness {

    public ArrayList<Sach> getSach(String sql) {
        ArrayList<Sach> lstSach = new ArrayList<Sach>();
        Connection con = Connect.getConnection();
        Statement st;
        Sach sach;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                sach = new Sach(rs.getString("MaSoSach"), rs.getString("TenSach"),
                        rs.getString("TacGia"),rs.getString("NhaXuatBan"),
                        rs.getInt("NamXuatBan"),rs.getString("TheLoai"), rs.getInt("Gia"), rs.getInt("TrangThai"));
                lstSach.add(sach);
            }
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        return lstSach;
    }

    public boolean addSach(Sach sach) {
        int isAccept = 0;
        if (sach == null || sach.getMaSoSach().equals("")) {
            return false;
        }
        String sql = String.format("INSERT INTO sach(MaSoSach, TenSach, NhaXuatBan,"
                + "TacGia, NamXuatBan, TheLoai, Gia, TrangThai) values ('%s', '%s', '%s', '%s'"
                + ", %d, '%s', %d, %d)", sach.getMaSoSach(), sach.getTenSach(), sach.getNhaXuatBan(),
                sach.getTacGia(), sach.getNamXuatBan(), sach.getTheLoai(), sach.getGiaSach(),1);
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            isAccept = st.executeUpdate(sql);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        if (isAccept == 0) {
            return false;
        }
        return true;
    }

    public boolean suaSach(Sach sach) {
        int isAccept = 0;
        if (sach == null || sach.getMaSoSach().equals("")) {
            return false;
        }
        String sql = String.format("update sach set TenSach = '%s', NhaXuatBan = '%s',"
                + " TacGia = '%s', NamXuatBan = %d, TheLoai = '%s', Gia = %d where "
                + " MaSoSach = '%s';", sach.getTenSach(), sach.getNhaXuatBan(),
                sach.getTacGia(), sach.getNamXuatBan(), sach.getTheLoai(),
                sach.getGiaSach(), sach.getMaSoSach());

        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            isAccept = st.executeUpdate(sql);
        }catch (Exception ex) {
			ex.printStackTrace();
        }
        if (isAccept == 0) {
            return false;
        }
        return true;
    }
    
    
// Xóa sách 
    public boolean xoaSach(String maSoSach) {
        int isAccept = 0;
        if (maSoSach.equals("")) {
            return false;
        }
        String sql = "update sach set TrangThai = 0 where MaSoSach = '" + maSoSach + "';";
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            isAccept = st.executeUpdate(sql);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        if (isAccept == 0) {
            return false;
        }
        return true;
    }

}
