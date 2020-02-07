/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BanDoc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class BanDocBusiness {
    
    public ArrayList<BanDoc> getBanDoc(String sql){
        Connection con = Connect.getConnection();
        ArrayList<BanDoc> lstBanDoc = new ArrayList<BanDoc>();
        BanDoc banDoc;
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                banDoc = new BanDoc(rs.getString("MaSoBanDoc"), rs.getString("HoTen"),
                rs.getString("GioiTinh"),rs.getInt("NamSinh"),rs.getString("DiaChi"),
                rs.getString("SoChungMinhThu"),rs.getString("SoDienThoai"),
                        rs.getString("Email"), rs.getInt("TrangThai"));
                
                lstBanDoc.add(banDoc);
            }
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        
        return lstBanDoc;
    }
    
    
    public boolean addBanDoc(BanDoc banDoc){
        int isSuccess = 0;
        if(banDoc == null || banDoc.getMaSo() == ""){
            return false;
        }
        String sql = String.format("insert into bandoc(MaSoBanDoc, HoTen, GioiTinh,"
                + " NamSinh, DiaChi, SoChungMinhThu, SoDienThoai, Email,TrangThai) values "
                + "('%s', '%s', '%s', %d, '%s', '%s', '%s' ,'%s',1);",
                banDoc.getMaSo(), banDoc.getHoTen(), banDoc.getGioiTinh(),
                banDoc.getNamSinh(), banDoc.getDiaChi(), banDoc.getSoChungMinhThu(),
                banDoc.getSoDienThoai(), banDoc.getEmail(),1);  
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
    
    //Edit the information of Customer
    public boolean suaBanDoc(BanDoc banDoc){
        int isSuccess = 0;
        if(banDoc == null){
            return false;
        }
        String sql = String.format("update bandoc set HoTen = '%s', GioiTinh = '%s',"
                + "NamSinh = %d, DiaChi = '%s', SoChungMinhThu = '%s',"
                + "SoDienThoai = '%s', Email = '%s' where MaSoBanDoc = '%s';",
                banDoc.getHoTen(), banDoc.getGioiTinh(), banDoc.getNamSinh(),
                banDoc.getDiaChi(), banDoc.getSoChungMinhThu(), banDoc.getSoDienThoai(),
                banDoc.getEmail(), banDoc.getMaSo());
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
    
    
    public boolean xoaBanDoc(String maSoBanDoc){
        int isSuccess = 0;
        if(maSoBanDoc == "")
            return false;
        String sql = String.format("update bandoc set TrangThai = 0 where MaSoBanDoc = '%s';", maSoBanDoc);
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            isSuccess = st.executeUpdate(sql);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        if(isSuccess == 0){
            return false;
        }
        return true;
    }
}
