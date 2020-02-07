/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BanDoc;
import Model.ChiTietMuon;
import Model.MuonTra;
import Model.NhanVien;
import Model.Sach;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Linh
 */
public class QuanLyThuVien {

    private BanDocBusiness qlbd = new BanDocBusiness();
    private NhanVienBusiness qlnv = new NhanVienBusiness();
    private SachBusiness qls = new SachBusiness();
    private MuonTraBusiness qlmt = new MuonTraBusiness();
    private ChiTietMuonBusiness ctm = new ChiTietMuonBusiness();

    //Quản lý bạn đọc
    public boolean xoaBanDoc(String maBanDoc) {
        return qlbd.xoaBanDoc(maBanDoc);
    }

    public ArrayList<BanDoc> getBanDoc(String sql) {
        ArrayList<BanDoc> lstBanDoc = new ArrayList<BanDoc>();
        lstBanDoc = qlbd.getBanDoc(sql);
        return lstBanDoc;
    }

    public boolean addBanDoc(BanDoc banDoc) {
        return qlbd.addBanDoc(banDoc);
    }

    public boolean suaBanDoc(BanDoc banDoc) {
        return qlbd.suaBanDoc(banDoc);
    }

    //Lấy nhân viên đăng nhập
    public NhanVien getNhanVien(String sql) {
        return qlnv.getNhanVien(sql);
    }

    //Quản lý sách
    public ArrayList<Sach> getSach(String sql) {
        return qls.getSach(sql);
    }

    public boolean addSach(Sach sach) {
        return qls.addSach(sach);
    }

    public boolean suaSach(Sach sach) {
        return qls.suaSach(sach);
    }

    public boolean xoaSach(String maSoSach) {
        return qls.xoaSach(maSoSach);
    }

    //Date to String
    public String dateToString(Date date) {
        String dateToString = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateToString = sdf.format(date);
        } catch (Exception e) {
        }
        return dateToString;
    }

    public ArrayList<BanDoc> fileToBanDoc(File file) {
        ArrayList<BanDoc> lstBanDoc = new ArrayList<BanDoc>();
        try {
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            for (int i = 0; i < sheet.getRows(); i++) {
                BanDoc bd = new BanDoc(sheet.getCell(0, i).getContents(), sheet.getCell(1, i).getContents(),
                        sheet.getCell(2, i).getContents(), Integer.parseInt(sheet.getCell(3, i).getContents()),
                        sheet.getCell(4, i).getContents(),
                        sheet.getCell(5, i).getContents(), sheet.getCell(6, i).getContents(),
                        sheet.getCell(7, i).getContents(), 1);
                lstBanDoc.add(bd);
            }
        } catch (IOException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {

        }
        return lstBanDoc;
    }

    public ArrayList<Sach> fileToSach(File file) {
        ArrayList<Sach> lstSach = new ArrayList<Sach>();
        try {
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            for (int i = 0; i < sheet.getRows(); i++) {
                Sach sach = new Sach(sheet.getCell(0, i).getContents(), sheet.getCell(1, i).getContents(),
                        sheet.getCell(2, i).getContents(), sheet.getCell(3, i).getContents(),
                        Integer.parseInt(sheet.getCell(4, i).getContents()),
                        sheet.getCell(5, i).getContents(), Integer.parseInt(sheet.getCell(6, i).getContents()), 1);
                lstSach.add(sach);
            }
        } catch (IOException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {

        }
        return lstSach;
    }

    public Sach stringToSach(String str) {
        Sach sach = null;
        String[] arrString = str.split(";");
        int giaSach = 0;
        int namXuatBan = 0;
        try {
            giaSach = Integer.parseInt(arrString[6]);
            namXuatBan = Integer.parseInt(arrString[4]);
            sach = new Sach(arrString[0], arrString[1], arrString[3], arrString[2],
                    namXuatBan, arrString[5], giaSach, 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tệp vừa chọn có trường hợp không hợp lệ !");
        }
        return sach;
    }

    // Quản lý mượn trả
    public boolean addMuonTra(MuonTra muonTra) {
        return qlmt.addMuonTra(muonTra);
    }

    public ArrayList<MuonTra> getMuonTra(String sql) {
        return qlmt.getMuonTra(sql);
    }

    public boolean xoaMuonTra(String maSoMuon) {
        return qlmt.xoaMuonTra(maSoMuon);
    }

    public boolean suaMuonTra(MuonTra muonTra) {
        return qlmt.suaMuonTra(muonTra);
    }

    // quản lí chi tiết mượnsS
    public boolean addChiTietMuon(ChiTietMuon chiTietMuon) {
        return ctm.addChiTietMuon(chiTietMuon);
    }

    public ArrayList<ChiTietMuon> getChiTietMuon(String sql) {
        return ctm.getChiTietMuon(sql);
    }

    public boolean suaChiTietMuon(ChiTietMuon chiTietMuon) {
        return ctm.suaChiTietMuon(chiTietMuon);
    }

    public boolean xoaChiTietMuon(ChiTietMuon chiTietMuon) {
        return ctm.xoaChiTietMuon(chiTietMuon);
    }

    public java.sql.Date stringToSQLDate(String str) {
        java.sql.Date date = null;
        String[] arrString = str.split("-");
        int nam = 0;
        int thang = 0;
        int ngay = 0;
        try {
            nam = Integer.parseInt(arrString[0]) - 1990;
            thang = Integer.parseInt(arrString[1]) - 1;
            ngay = Integer.parseInt(arrString[2]);
            date = new java.sql.Date(nam, thang, ngay);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public java.sql.Date dateToDate(java.util.Date date2) {
        java.sql.Date date;
        int nam = date2.getYear();
        int thang = date2.getMonth();
        int ngay = date2.getDate();
        date = new java.sql.Date(nam, thang, ngay);
        return date;
    }

    public PdfPTable getTable(JTable table) throws DocumentException, IOException {
        BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
        Font fontBang = new Font(bf1, 10, Font.NORMAL, BaseColor.BLACK);
        Font fontCot = new Font(bf1, 12, Font.BOLD, BaseColor.BLUE);
        int numColumm = table.getColumnCount();
        // set cho dòng đầu tiên
        PdfPTable pdfTable = new PdfPTable(numColumm);
        for (int i = 0; i < numColumm; i++) {
            PdfPCell cell = new PdfPCell(new Paragraph(table.getColumnName(i), fontCot));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
            pdfTable.addCell(cell);
        }
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                PdfPCell cell = new PdfPCell(new Paragraph("" + table.getValueAt(i, j), fontBang));
                pdfTable.addCell(cell);
            }
        }
        return pdfTable;
    }

    public boolean inBaoCao(String path, String tenBanCao, NhanVien nhanVien, String duLieuTimKiem, JTable table) {
        boolean isSuccess = false;
        try {
            BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
            document.open();
            Font fontTenThuVien = new Font(bf1, 35, Font.BOLD, BaseColor.RED);
            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
            Font fontLienLac = new Font(bf1, 6, Font.UNDEFINED, BaseColor.BLACK);
            document.add(new Paragraph("                THƯ VIỆN QUẬN 9", fontTenThuVien));
            document.add(new Paragraph(" ", fontChuKy));
            document.add(new Paragraph("Học viện Công nghệ Bưu chính Viễn Thông- 97 Man Thiện- Q9-TP.HCM                                                                                                                                                                                                      SĐT: 0337566668", fontLienLac));
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", fontLienLac));
            document.add(new Paragraph("                                              BÁO CÁO", fontTieuDe));
            document.add(new Paragraph("                               ", fontTieuDe));
            document.add(new Paragraph(duLieuTimKiem, fontChung));
            document.add(new Paragraph("Ngày              : " + new java.sql.Date(new Date().getTime()), fontChung));
            document.add(new Paragraph("Thủ thư          : " + nhanVien.getHoTen(), fontChung));
            document.add(new Paragraph("Mã số thủ thư     : " + nhanVien.getMaSo(), fontChung));
            document.add(new Paragraph("Kết quả           :", fontChung));
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph(" ", fontChung));
            PdfPTable table2 = getTable(table);
            document.add(table2);
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph("                                                               Chữ ký thủ thư và đóng dấu ", fontChuKy));
            document.close();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        
        return isSuccess;
    }

    // Chuyển từ chuỗi sang Ngày trong java
    public Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return date;
    }

    public boolean inPhieuMuon(BanDoc banDoc, MuonTra muonTra, NhanVien nhanVien, JTable table, String path) {
        boolean isSuccess = false;
        try {
            BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
            document.open();
            Font fontTenThuVien = new Font(bf1, 35, Font.BOLD, BaseColor.RED);
            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
            Font fontLienLac = new Font(bf1, 6, Font.UNDEFINED, BaseColor.BLACK);
            document.add(new Paragraph("                 THƯ VIỆN QUẬN 9", fontTenThuVien));
            document.add(new Paragraph(" ", fontChuKy));
            document.add(new Paragraph("Học viện Công nghệ Bưu chính Viễn Thông- 97 Man Thiện- Q9-TP.HCM                                                                                                                                                                                                      SĐT: 0337566668", fontLienLac));
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", fontLienLac));

            document.add(new Paragraph("                                      PHIẾU MƯỢN SÁCH", fontTieuDe));
            document.add(new Paragraph("                               ", fontTieuDe));
            document.add(new Paragraph("Mã số mượn        : " + muonTra.getMaSoMuonTra(), fontChung));
            document.add(new Paragraph("Ngày mượn         : " + muonTra.getNgayMuon(), fontChung));
            document.add(new Paragraph("Hạn trả           : " + muonTra.getHanTra(), fontChung));
            document.add(new Paragraph("Số tiền cọc          : " + muonTra.getSoTienCoc(), fontChung));
            document.add(new Paragraph("Mã số bạn đọc     : " + banDoc.getMaSo(), fontChung));
            document.add(new Paragraph("Họ tên bạn đọc    : " + banDoc.getHoTen(), fontChung));
            document.add(new Paragraph("Năm sinh          : " + banDoc.getNamSinh(), fontChung));
            document.add(new Paragraph("Địa chỉ           : " + banDoc.getDiaChi(), fontChung));
            document.add(new Paragraph("Số chứng minh thư : " + banDoc.getSoChungMinhThu(), fontChung));
            document.add(new Paragraph("Số điện thoại     : " + banDoc.getSoDienThoai(), fontChung));
            document.add(new Paragraph("Mã số thủ thư      : " + nhanVien.getMaSo(), fontChung));
            document.add(new Paragraph("Họ tên thủ thư    : " + nhanVien.getHoTen() + "\n", fontChung));
            document.add(new Paragraph("Danh sách các sách đã mượn :", fontChung));
            document.add(new Paragraph(" ", fontChung));
            PdfPTable table2 = getTable(table);
            document.add(table2);
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph("         Chữ ký bạn đọc                                                Chữ ký thủ thư và đóng dấu ", fontChuKy));
            document.close();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
    }

    //Thống kê
    // Thống kê sách theo tên
//    public void thongKeSach(JTable table){
//        String sql = "select TenSach, count(MaSoSach) from sach group by TenSach;";
//        String [] colName = {"Tên sách", "Số lượng"}; 
//        DefaultTableModel model = new DefaultTableModel(colName, 0);
//        Object [] objThongKeSach = new Object[2];
//        Connection con = Connect.getConnection();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()){
//                objThongKeSach[0] = rs.getString("TenSach");
//                objThongKeSach[1] = rs.getInt("count(MaSoSach)");
//                model.addRow(objThongKeSach);
//            }
//            table.setModel(model);
//        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    //Thống kê sách bị mất tính từ ngày mượn
    public void thongKeSachMat(JTable table, String date1, String date2) {
        String sql = String.format("select sach.MaSoSach, sach.TenSach, muontra.NgayMuon, bandoc.MaSoBanDoc,bandoc.HoTen "
                + " from muontra, chitietmuon, sach, bandoc where muontra.MaSoMuon = chitietmuon.MaSoMuon and sach.MaSoSach = chitietmuon.MaSoSach \n"
                + " and chitietmuon.TrangThai = 'Mất' and muontra.MaSoBanDoc = bandoc.MaSoBanDoc and datediff('%s',NgayMuon) >= 0 and datediff(NgayMuon,'%s') >= 0;",
                date2, date1);
        String[] colName = {"Mã số sách", "Tên sách", "Ngày mượn", "Mã số bạn đọc làm mất", "Tên bạn đọc"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Object[] objThongKeSach = new Object[5];
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objThongKeSach[0] = rs.getString("MaSoSach");
                objThongKeSach[1] = rs.getString("TenSach");
                objThongKeSach[2] = rs.getDate("NgayMuon");
                objThongKeSach[3] = rs.getString("MaSoBanDoc");
                objThongKeSach[4] = rs.getString("HoTen");
                model.addRow(objThongKeSach);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
    }

    //Thống kê các sách được mượn
    public void thongKeSachDuocMuon(JTable table, String date1, String date2) {
        String sql = String.format("select sach.MaSoSach, sach.TenSach, muontra.NgayMuon, bandoc.MaSoBanDoc,bandoc.HoTen, muontra.MaSoMuon  "
                + " from muontra, chitietmuon, sach, bandoc where muontra.TrangThai = 1 and muontra.MaSoMuon = chitietmuon.MaSoMuon and sach.MaSoSach = chitietmuon.MaSoSach \n"
                + " and  muontra.MaSoBanDoc = bandoc.MaSoBanDoc and datediff('%s',NgayMuon) >= 0 and datediff(NgayMuon,'%s') >= 0;",
                date2, date1);
        String[] colName = {"Mã số sách", "Tên sách", "Ngày mượn", "Mã số bạn đọc mượn sách", "Tên bạn đọc", "Mã số mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Object[] objThongKeSach = new Object[6];
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objThongKeSach[0] = rs.getString("MaSoSach");
                objThongKeSach[1] = rs.getString("TenSach");
                objThongKeSach[2] = rs.getDate("NgayMuon");
                objThongKeSach[3] = rs.getString("MaSoBanDoc");
                objThongKeSach[4] = rs.getString("HoTen");
                objThongKeSach[5] = rs.getString("MaSoMuon");
                model.addRow(objThongKeSach);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
    }

    //Thống kê bạn đọc mượn sách
    public void thongKeBanDocMuonSach(JTable table, String date1, String date2) {
        String sql = String.format("select bandoc.MaSoBanDoc, bandoc.HoTen, muontra.NgayMuon, muontra.MaSoMuon from bandoc, muontra where bandoc.MaSoBanDoc = muontra.MaSoBanDoc "
                + " and muontra.TrangThai = 1 and datediff('%s',NgayMuon) >= 0 and datediff(NgayMuon,'%s') >= 0;", date2, date1);
        String[] colName = {"Mã số bạn đọc", "Họ tên", "Mã số mượn", "Ngày mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Object[] objThongKeSach = new Object[6];
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objThongKeSach[0] = rs.getString("MaSoBanDoc");
                objThongKeSach[1] = rs.getString("HoTen");
                objThongKeSach[3] = rs.getDate("NgayMuon");
                objThongKeSach[2] = rs.getString("MaSoMuon");
                model.addRow(objThongKeSach);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
    }

    //Thống kê só lượng sách theo các kiểu khác nhau
    public void thongKeSach(JTable table, String kieuThongKe) {
        String sql = "select " + kieuThongKe + ", count(MaSoSach) from sach group by "
                + kieuThongKe;
        String[] colName = new String[2];
        if (kieuThongKe.equals("TenSach")) {
            colName[0] = "Tên sách";
        }
        if (kieuThongKe.equals("TacGia")) {
            colName[0] = "Tác giả";
        }
        if (kieuThongKe.equals("NhaXuatBan")) {
            colName[0] = "Nhà xuất bản";
        }
        if (kieuThongKe.equals("TheLoai")) {
            colName[0] = "Thể loại";
        }
        colName[1] = "Số lượng";
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Object[] objSach = new Object[2];
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objSach[0] = rs.getString(kieuThongKe);
                objSach[1] = rs.getInt("count(MaSoSach)");
                model.addRow(objSach);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
    }

    //Top những sách được mượn nhiều nhất
    public void thongKeTop(JTable table, int soLuongSach) {
        String sql = "select TenSach, TacGia, NhaXuatBan, TheLoai, count(chitietmuon.MaSoMuon)"
                + "from sach, chitietmuon, muontra where sach.MaSoSach = chitietmuon.MaSoSach and"
                + " muontra.MaSoMuon = chitietmuon.MaSoMuon and muontra.TrangThai = 1 "
                + "and sach.TrangThai = 1 group by tensach"
                + " order by count(chitietmuon.MaSoMuon) desc limit " + soLuongSach;
        String[] colName = {"Tên sách", "Tác giả", "Nhà xuất bản", "Thể loại", "Số lượt mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Object[] objSach = new Object[5];
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objSach[0] = rs.getString("TenSach");
                objSach[1] = rs.getString("TacGia");
                objSach[2] = rs.getString("NhaXuatBan");
                objSach[3] = rs.getString("TheLoai");
                objSach[4] = rs.getInt("count(chitietmuon.MaSoMuon)");
                model.addRow(objSach);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
    }

    public void thongKeBanDocTraMuon() {
    }

//  public boolean  inThongKe1(JTable table,String path,String tenThongKe,NhanVien nhanVien){
//        boolean isSuccess = false;
//        try {
//            BaseFont bf1 = BaseFont.createFont("C:\\Users\\Linh\\Downloads\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, true);
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
//            document.open();
//            Font fontTenThuVien = new Font(bf1, 35, Font.BOLD, BaseColor.RED);
//            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
//            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
//            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
//            Font fontLienLac = new Font(bf1, 6, Font.UNDEFINED, BaseColor.BLACK);
//            document.add(new Paragraph("      THƯ VIỆN TẠ QUANG BỬU", fontTenThuVien));
//            document.add(new Paragraph(" ", fontChuKy));
//            
//
//            document.add(new Paragraph("Đại học Bách Khoa Hà Nội - Số 1 Đại Cồ Việt - Hai Bà Trưng - Hà Nội                                                                                                                                                                SĐT: 01667645238", fontLienLac));
//            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------",fontLienLac));
//            document.add(new Paragraph("                                  PHIẾU THỐNG KÊ", fontTieuDe));
//            document.add(new Paragraph("                               ", fontTieuDe));
//            document.add(new Paragraph("Nội dung thống kê      : " + tenThongKe, fontChung));
//           
//            document.add(new Paragraph("Tên nhân viên thống kê : " + nhanVien.getHoTen(), fontChung));
//            document.add(new Paragraph("Mã số nhân viên        : " + nhanVien.getMaSo(), fontChung));
//            document.add(new Paragraph("Ngày thống kê          : " + new java.sql.Date(new Date().getTime()), fontChung));
//            document.add(new Paragraph(" ", fontChung));
//            PdfPTable table2 = getTable(table);
//            document.add(table2);
//            document.add(new Paragraph(" ", fontChung));
//            document.add(new Paragraph(" ", fontChung));
//            document.add(new Paragraph("                                                               Chữ ký cán bộ và đóng dấu ", fontChuKy));
//            document.close();
//            isSuccess = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            isSuccess = false;
//        }
//        return isSuccess;
//    }
    public boolean inThongKe(JTable table, String path, String tenThongKe, NhanVien nhanVien, String ngayBatDau, String ngayKetThuc) {
        boolean isSuccess = false;
        try {
            BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
            document.open();
            Font fontTenThuVien = new Font(bf1, 35, Font.BOLD, BaseColor.RED);
            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
            Font fontLienLac = new Font(bf1, 6, Font.UNDEFINED, BaseColor.BLACK);
            document.add(new Paragraph("                 THƯ VIỆN QUẬN 9", fontTenThuVien));
            document.add(new Paragraph(" ", fontChuKy));
            document.add(new Paragraph("Học viện Công nghệ Bưu chính Viễn Thông- 97 Man Thiện- Q9-TP.HCM                                                                                                                                                                                                      SĐT: 0337566668", fontLienLac));
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", fontLienLac));
            document.add(new Paragraph("                                  PHIẾU THỐNG KÊ", fontTieuDe));
            document.add(new Paragraph("                               ", fontTieuDe));
            document.add(new Paragraph("Nội dung thống kê      : " + tenThongKe, fontChung));
            if (ngayBatDau != null && ngayKetThuc != null) {
                if (ngayBatDau.equals(ngayKetThuc)) {
                    document.add(new Paragraph("Ngày                  : " + ngayBatDau, fontChung));
                } else {
                    document.add(new Paragraph("Ngày bắt đầu           : " + ngayBatDau, fontChung));
                    document.add(new Paragraph("Ngày kết thúc           : " + ngayKetThuc, fontChung));
                }
            }
            document.add(new Paragraph("Tên nhân viên thống kê : " + nhanVien.getHoTen(), fontChung));
            document.add(new Paragraph("Mã số thủ thư        : " + nhanVien.getMaSo(), fontChung));
            document.add(new Paragraph("Ngày thống kê          : " + new java.sql.Date(new Date().getTime()), fontChung));
            document.add(new Paragraph(" ", fontChung));
            PdfPTable table2 = getTable(table);
            document.add(table2);
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph("                                                               Chữ ký thủ thư và đóng dấu ", fontChuKy));
            document.close();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
    }

    public boolean thongKeBanDoc(JTable table, String kieuThongKe) {
        String[] colName = new String[2];
        if (kieuThongKe.equals("NamSinh")) {
            colName[0] = "Năm sinh";
        }
        if (kieuThongKe.equals("DiaChi")) {
            colName[0] = "Địa chỉ";
        }
        if (kieuThongKe.equals("GioiTinh")) {
            colName[0] = "Giới tính";
        }
        colName[1] = "Số lượng";
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        String sql = "select " + kieuThongKe + ", count(MaSoBanDoc) from bandoc "
                + " group by " + kieuThongKe;
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] objBanDoc = new Object[2];
                if (kieuThongKe.equals("NamSinh")) {
                    objBanDoc[0] = rs.getInt(kieuThongKe);
                } else {
                    objBanDoc[0] = rs.getString(kieuThongKe);
                }
                objBanDoc[1] = rs.getInt("count(MaSoBanDoc)");
                model.addRow(objBanDoc);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean thongKeTopBanDoc(JTable table, int number) {
        String[] colName = {"Mã bạn đọc", "Họ và tên", "Số lượt mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        String sql = "Select bandoc.MaSoBanDoc, bandoc.HoTen, count(MaSoMuon) "
                + "from  bandoc, muontra where bandoc.MaSoBanDoc = muontra.MaSoBanDoc "
                + " group by bandoc.MaSoBanDoc order by count(MaSoMuon) desc limit 10";
        Connection con = Connect.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] objBanDoc = new Object[3];
                objBanDoc[2] = rs.getString("count(MaSoMuon)");
                objBanDoc[0] = rs.getString("MaSoBanDoc");
                objBanDoc[1] = rs.getString("HoTen");
                model.addRow(objBanDoc);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean thongKeTienCoc(JTable table, String date1, String date2) {
        String sql = String.format("select bandoc.MaSoBanDoc,bandoc.HoTen, muontra.SoTienCoc, muonTra.NgayMuon"
                + " from bandoc, muontra where muontra.TrangThai = 1 and  bandoc.MaSoBanDoc = muontra.MaSoBanDoc and datediff('%s',NgayMuon) >= 0 and datediff(NgayMuon,'%s') >= 0;", date2, date1);
        String[] colName = {"Mã số bạn đọc", "Họ tên bạn đọc", "Số tiền cọc", "Ngày mượn sách"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Connection con = Connect.getConnection();
        Statement st;
        int tongTien = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] objTienCoc = new Object[4];
                objTienCoc[0] = rs.getString("MaSoBanDoc");
                objTienCoc[1] = rs.getString("HoTen");
                objTienCoc[2] = rs.getInt("SoTienCoc");
                objTienCoc[3] = rs.getString("NgayMuon");
                tongTien += (int) objTienCoc[2];
                model.addRow(objTienCoc);
            }
            Object[] objects = new Object[4];
            objects[0] = "Tổng số tiền";
            objects[1] = " ";
            objects[2] = " ";
            objects[3] = tongTien;
            model.addRow(objects);
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }

        return true;
    }

    public boolean thongKeTienPhat(JTable table, String date1, String date2) {
        int tongTien = 0;
        String sql = String.format("select bandoc.MaSoBanDoc,bandoc.HoTen, muontra.SoTienPhat, muonTra.NgayTra"
                + " from bandoc, muontra where muontra.TrangThai = 1 and muontra.SoTienPhat > 0 and bandoc.MaSoBanDoc = muontra.MaSoBanDoc and datediff('%s',NgayMuon) >= 0 and datediff(NgayMuon,'%s') >= 0;", date2, date1);
        String[] colName = {"Mã số bạn đọc", "Họ tên bạn đọc", "Số tiền phạt", "Ngày trả sách"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Connection con = Connect.getConnection();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] objTienCoc = new Object[4];
                objTienCoc[0] = rs.getString("MaSoBanDoc");
                objTienCoc[1] = rs.getString("HoTen");
                objTienCoc[2] = rs.getInt("SoTienPhat");
                objTienCoc[3] = rs.getString("NgayTra");
                tongTien += (int) objTienCoc[2];
                model.addRow(objTienCoc);
            }
            Object[] objects = new Object[4];
            objects[0] = "Tổng số tiền";
            objects[1] = " ";
            objects[3] = " ";
            objects[2] = tongTien;
            model.addRow(objects);
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }

        return true;
    }

    public boolean thongKeSachTheoThang(JTable table) {
        String sql = "select "
                + " month(muontra.NgayMuon), count(chitietmuon.MaSoSach)"
                + "from "
                + " muontra, chitietmuon "
                + "where muontra.MaSoMuon = chitietmuon.MaSoMuon and year(muontra.NgayMuon) = year(curdate()) and muontra.TrangThai = 1 "
                + "group by month(muontra.NgayMuon)";
        String[] colName = {"Tháng", "Số lượng sách cho mượn",};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Connection con = Connect.getConnection();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] objSoLuongSach = new Object[2];
                objSoLuongSach[0] = rs.getString("month(muontra.NgayMuon)");
                objSoLuongSach[1] = rs.getInt("count(chitietmuon.MaSoSach)");
                model.addRow(objSoLuongSach);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        return true;
    }

    public boolean thongKeLuotMuonTheoThang(JTable table) {

        String sql = "select "
                + " month(muontra.NgayMuon), count(MaSoMuon)"
                + "from "
                + " muontra "
                + " where year(muontra.NgayMuon) = year(curdate()) and muontra.TrangThai = 1 "
                + "group by month(muontra.NgayMuon)";
        String[] colName = {"Tháng", "Số lượng lượt mượn",};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Connection con = Connect.getConnection();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] objSoLuongSach = new Object[2];
                objSoLuongSach[0] = rs.getString("month(muontra.NgayMuon)");
                objSoLuongSach[1] = rs.getInt("count(MaSoMuon)");
                model.addRow(objSoLuongSach);
            }
            table.setModel(model);
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        return true;
    }
}
