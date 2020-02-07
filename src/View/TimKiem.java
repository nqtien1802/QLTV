package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import Controller.QuanLyThuVien;
import Model.Sach;



public class TimKiem extends JFrame {
	JTextField txtTim;
	JButton btnBatDauTK, btnDangNhap;
	JTable tblSach;
	ArrayList<Sach> dsSach = null;
	JComboBox<String> cbotimKiemSach = null;
	QuanLyThuVien QTLV = new QuanLyThuVien();


	public TimKiem(String title) {
		super(title);
		addControls();
		addEvents();
		hienThiSach("SELECT * FROM sach where TrangThai = 1;");
	}

	public void hienThiSach(String sql) {
        String[] colSach = {"Mã số", "Tên sách", "Tác giả", "Nhà Xuất bản",
            "Năm xuất bản", "Thể loại", "Giá",};
        DefaultTableModel model = new DefaultTableModel(colSach, 0);
        Object[] objSach = new Object[7];
        ArrayList<Sach> lstSach = new ArrayList<Sach>();
        lstSach = QTLV.getSach(sql);
        for (int i = 0; i < lstSach.size(); i++) {
            objSach[0] = lstSach.get(i).getMaSoSach();
            objSach[1] = lstSach.get(i).getTenSach();
            objSach[3] = lstSach.get(i).getNhaXuatBan();
            objSach[2] = lstSach.get(i).getTacGia();
            objSach[4] = lstSach.get(i).getNamXuatBan();
            objSach[5] = lstSach.get(i).getTheLoai();
            objSach[6] = lstSach.get(i).getGiaSach();

            model.addRow(objSach);
        }
        tblSach.setModel(model);
    }

	private void addEvents() {
		txtTim.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent evt) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent evt) {
				// TODO Auto-generated method stub
			
			txtTimKeyReleased(evt);
			}
			@Override
			public void keyPressed(KeyEvent evt) {
				// TODO Auto-generated method stub

			}
		});
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 frmDangNhap main = new frmDangNhap("Đăng nhập hệ thống");
				 
				 main.showWindows();
				 dispose();
			}
		});

	}

	protected void txtTimKeyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		String sql = "";
        String kieuTimKiemSach = "";
        switch (cbotimKiemSach.getSelectedItem().toString()) {
            case "Mã số sách":
                kieuTimKiemSach = "MaSoSach";
                break;
            case "Tên sách":
                kieuTimKiemSach = "TenSach";
                break;
            case "Nhà xuất bản":
                kieuTimKiemSach = "NhaXuatBan";
                break;
            case "Thể loại":
                kieuTimKiemSach = "TheLoai";
                break;
            case "Tác giả":
                kieuTimKiemSach = "TacGia";
                break;
        }
        sql = "select * from sach where " + kieuTimKiemSach + " like '%"
                + txtTim.getText() + "%' and TrangThai = 1;";
        hienThiSach(sql);
    }


	private void addControls() {

		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNhap = new JLabel("Nhập dữ liệu: ");
		txtTim = new JTextField(30);
		cbotimKiemSach = new JComboBox<>();
		cbotimKiemSach.setModel(new DefaultComboBoxModel<>(
				new String[] { "Mã sách", "Tên sách", "Nhà xuất bản", "Tác giả", "Thể loại" }));
		pnNorth.add(lblNhap);
		pnNorth.add(txtTim);
		pnNorth.add(cbotimKiemSach);
		con.add(pnNorth, BorderLayout.NORTH);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		tblSach = new JTable();
		tblSach.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));

		JScrollPane scTable = new JScrollPane(tblSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable, BorderLayout.CENTER);
		scTable.setViewportView(tblSach);
        con.add(pnCenter, BorderLayout.CENTER);
        TitledBorder bordertblSach = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Danh sách tất cả các sách có trong thư viện");
        pnCenter.setBorder(bordertblSach);
        
		TitledBorder borderTimKiem = new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Tìm kiếm");

		pnNorth.setBorder(borderTimKiem);

		JPanel pnNorthRight = new JPanel();
		pnNorthRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setSize(100, 200);
		btnDangNhap.setIcon(new ImageIcon("images/dn.png"));
		pnNorthRight.add(btnDangNhap);
		con.add(pnNorthRight, BorderLayout.SOUTH);

	}

	public void showWindow() {
		this.setSize(1300, 900);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	

}