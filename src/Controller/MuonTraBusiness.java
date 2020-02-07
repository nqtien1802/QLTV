/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MuonTra;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class MuonTraBusiness {

	public ArrayList<MuonTra> getMuonTra(String sql) {
		ArrayList<MuonTra> lstMuonTra = new ArrayList<MuonTra>();
		Connection con = Connect.getConnection();
		MuonTra muonTra;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				muonTra = new MuonTra(rs.getString("MaSoMuon"), rs.getString("MaSoBanDoc"), rs.getDate("NgayMuon"),
						rs.getDate("HanTra"), rs.getDate("NgayTra"), rs.getString("MaCanBo"), rs.getInt("SoTienPhat"),
						rs.getInt("SoTienCoc"));
				lstMuonTra.add(muonTra);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstMuonTra;
	}

	public boolean addMuonTra(MuonTra muonTra) {
		if (muonTra == null) {
			return false;
		}
		int isSuccess = 0;
		String sql = String.format(
				"insert into muontra(MaSoMuon, MaSoBanDoc, NgayMuon, HanTra, MaCanBo, SoTienPhat, TrangThai, SoTienCoc) "
						+ " values('%s', '%s', '%s', '%s', '%s', %d, 1, %d);",
				muonTra.getMaSoMuonTra(), muonTra.getMaSoBanDoc(), muonTra.getNgayMuon(), muonTra.getHanTra(),
				muonTra.getMaCanBo(), muonTra.getSoTienPhat(), muonTra.getSoTienCoc());
		Connection con = Connect.getConnection();
		try {
			Statement st = con.createStatement();
			isSuccess = st.executeUpdate(sql);
		} catch (SQLException ex) {

		}
		if (isSuccess == 0) {
			return false;
		}
		return true;
	}

	public boolean suaMuonTra(MuonTra muonTra) {
		String sql = "";
		int isSuccess = 0;
		if (muonTra.getNgayTra() != null) {
			sql = String.format(
					"update muontra set HanTra = '%s', NgayTra = '%s', SoTienPhat = %d, MaSoBanDoc = '%s' where MaSoMuon = '%s';",
					muonTra.getHanTra(), muonTra.getNgayTra(), muonTra.getSoTienPhat(), muonTra.getMaSoBanDoc(),
					muonTra.getMaSoMuonTra());
		} else {
			sql = String.format(
					"update muontra set HanTra = '%s', SoTienPhat = %d, SoTienCoc = %d, MaSoBanDoc = '%s' where MaSoMuon = '%s';",
					muonTra.getHanTra(), muonTra.getSoTienPhat(), muonTra.getSoTienCoc(), muonTra.getMaSoBanDoc(),
					muonTra.getMaSoMuonTra());
		}
		Connection con = Connect.getConnection();
		try {
			Statement st = con.createStatement();
			isSuccess = st.executeUpdate(sql);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		if (isSuccess == 0) {
			return false;
		}
		return true;
	}

	public boolean xoaMuonTra(String maSoMuon) {
		int isSuccess = 0;
		String sql = String.format("update muontra set TrangThai = 0 where MaSoMuon = '%s'", maSoMuon);
		Connection con = Connect.getConnection();
		try {
			Statement st = con.createStatement();
			isSuccess = st.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (isSuccess == 0) {
			return false;
		}
		return true;
	}
}
