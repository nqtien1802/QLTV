/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NhanVien;
import Model.NhanVien;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class NhanVienBusiness {

    NhanVien nhanVien = null;

    public NhanVien getNhanVien(String sql) {
        Connection con = Connect.getConnection();

        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nhanVien = new NhanVien(rs.getString("MaSoNhanVien"),rs.getString("MatKhau"), 
                rs.getString("HoTenNhanVien"), rs.getString("ChucVu"), rs.getInt("NamSinh"),rs.getString("SoDienThoai"));
            }
        } catch (Exception ex) {
			ex.printStackTrace();
        }

        return nhanVien;
    }

}
