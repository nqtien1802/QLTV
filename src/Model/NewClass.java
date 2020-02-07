/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.QuanLyThuVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Linh
 */
public class NewClass {
    
    public static java.sql.Date dateToDate(java.util.Date date2){
        java.sql.Date date = null;
        int nam = date2.getYear();
        int thang = date2.getMonth();
        int ngay = date2.getDate();
        date = new java.sql.Date(nam,thang,ngay);
        return date;
    }
    public static void main(String[] args) {
        QuanLyThuVien qltv = new QuanLyThuVien();
       java.sql.Date d1 = dateToDate(new java.util.Date());
       java.sql.Date d2= dateToDate(new java.util.Date());
       java.sql.Date d3 = dateToDate(new java.util.Date());
       java.sql.Date d4 = new java.sql.Date(5-5-5);
       
       
//       MuonTra mt = new MuonTra("fffffff", "BD1008", d3, d2, d1, "NV001", 0);
//       if(qltv.addMuonTra(mt)){
//           System.out.println("1");
        System.out.println(d4);
       }
    }
    
