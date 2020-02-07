/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChiTietMuon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class ChiTietMuonBusiness {
    
    public boolean addChiTietMuon(ChiTietMuon chiTietMuon){
        if(chiTietMuon == null){
            return false;
        }
        int isSuccess = 0;
        String sql =String.format("insert into chitietmuon(MaSoMuon, MaSoSach,TrangThai) values"
                + "('%s', '%s','%s')", chiTietMuon.getMaSoMuon(), chiTietMuon.getMaSoSach(), "Đang mượn");
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            isSuccess = st.executeUpdate(sql);
        }catch (Exception ex) {
			ex.printStackTrace();
        }
        if(isSuccess == 0)
            return false;
        return true;
    }
    
    public ArrayList<ChiTietMuon> getChiTietMuon(String sql){
        ArrayList<ChiTietMuon> lstChiTietMuon = new ArrayList<ChiTietMuon>();
        Connection con = Connect.getConnection();
        ChiTietMuon chiTietMuon;
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                chiTietMuon = new ChiTietMuon(rs.getString("MaSoMuon"),rs.getString("MaSoSach"), rs.getString("TrangThai"));
                lstChiTietMuon.add(chiTietMuon);
            }
        }catch (Exception ex) {
			ex.printStackTrace();
        }

        return lstChiTietMuon;
    }
    
    public boolean xoaChiTietMuon(ChiTietMuon chiTietMuon){
        if(chiTietMuon == null){
            return false;
        }
        int isSuccess = 0;
        String sql =String.format("delete from chitietmuon where MaSoMuon = '%s' and MaSoSach = '%s'",
                chiTietMuon.getMaSoMuon(), chiTietMuon.getMaSoSach());
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            isSuccess = st.executeUpdate(sql);
        }catch (Exception ex) {
			ex.printStackTrace();
        }
        if(isSuccess == 0)
            return false;
        return true;
    }
    
    public boolean suaChiTietMuon(ChiTietMuon chiTietMuon){
        if(chiTietMuon == null){
            return false;
        }
        int isSuccess = 0;
        String sql =String.format("update chitietmuon set TrangThai = '%s' where MaSoMuon = '%s' and MaSoSach = '%s';",
                chiTietMuon.getTrangThai(), chiTietMuon.getMaSoMuon(), chiTietMuon.getMaSoSach());
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            isSuccess = st.executeUpdate(sql);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        if(isSuccess == 0)
            return false;
        return true;
    }
}
