/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DTO_NhanVien;
import DTO.DTO_User;
import static GUI.pnl_NhanVienNew.MaNV;
import static GUI.pnl_NhanVienNew.form;
import static GUI.pnl_NhanVienNew.imageName;
import static GUI.pnl_NhanVienNew.nv;
import static GUI.pnl_NhanVienNew.save_IMG;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author DELL
 */
public class pnl_NhanVienNew extends javax.swing.JPanel {
    int showHidePass = 1;
    public static pnl_NhanVienNew form;
    public static String imageName = null;
     File f;
     public static DTO.DTO_NhanVien nv = new DTO_NhanVien();
    /**
     * Creates new form pnl_NhanVienNew
     */
    public pnl_NhanVienNew() {
        initComponents();
         form = this;
        BLL.BLL_NhanVien.loadData_Luong(cbb_Luong);
        BLL.BLL_NhanVien.DoDuLieuBang(tbl_Nhanvien);
        rab_Nam.setSelected(true);
        rab_nhanvien.setSelected(true);
        btn_Capnhat.setEnabled(false);
        btn_xoa.setEnabled(false);
        btn_capnhaptk.setEnabled(false);
        btn_xoatk.setEnabled(false);
        //jPanel2.setVisible(false);
        Date d = new Date();
        Date_Ngaysinh.setMaxSelectableDate(d);
    }
     private void LamMoi() {
        FrmMain frm = FrmMain.b;
        pnl_NhanVienNew pnl = new pnl_NhanVienNew();
        frm.tab.remove(this);
        frm.tab.add("Nhân viên", pnl);
        frm.tab.setSelectedComponent(pnl);
    }
     public static boolean save_IMG(File file) {
        File dir = new File("IMG_NhanVien");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            File newfile = new File(dir, file.getName());
            Path source = Paths.get(file.getAbsolutePath());
            Path ok = Paths.get(newfile.getAbsolutePath());
            Files.copy(source, ok, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
      public void lbl_ImageNV(String ImagePath) {
        ImageIcon icon = new ImageIcon("IMG_NhanVien\\" + ImagePath);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lbl_hinh.getWidth(), lbl_hinh.getHeight(), image.SCALE_SMOOTH));
        lbl_hinh.setIcon(icon1);
    }
      private void GanDuLieu() {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        nv.setMaNV(txt_MaNV.getText());
        nv.setTenNV(txt_TenNV.getText());
        if (rab_Nam.isSelected()) {
            nv.setGioiTinh(true);

        } else {
            nv.setGioiTinh(false);
        }
        try {
            nv.setNgaySinh(s.format(Date_Ngaysinh.getDate()));
            nv.setNgayLam(s.format(date_Ngaylam.getDate()));
        } catch (Exception e) {
            thongbao.loi("Ngày sai");
            return;
        }

        nv.setSDT(txt_SDT.getText());
        GUI.mycombobox mb = (GUI.mycombobox) cbb_Luong.getSelectedItem();
        nv.setMaLuong(mb.value.toString());
        nv.setDiaChi(txt_Diachi.getText());
        nv.setGhiChu(txt_Ghichu.getText());
        nv.setHinh(imageName);
    }
      private void DienDuLieu() {
        ResultSet rs = DAO.DAO_User.LayTKTheoMaNV(MaNV);
        try {
            if (rs.next()) {
                txt_Tenuser.setText(rs.getString("TenUser"));
                txt_matkhau.setText(rs.getString("MatKhau"));
                if (rs.getString("MaQuyen").equals("QuanLy")) {
                    rab_quanly.setSelected(true);
                } else {
                    rab_nhanvien.setSelected(true);
                }
            } else {
                txt_Tenuser.setText("");
                txt_matkhau.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnl_NhanVienNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void showHidePassword() {
        showHidePass++;
        if (showHidePass % 2 == 0) {
            Image img = getToolkit().createImage(getClass().getResource("/HinhAnh/eyeBlack.png"));
            btnEye.setIcon(new ImageIcon(img));
            txt_matkhau.setEchoChar((char) 0);
            txt_nhaplai.setEchoChar((char) 0);
        } else {
            Image img = getToolkit().createImage(getClass().getResource("/HinhAnh/eyeHideBlack.png"));
            btnEye.setIcon(new ImageIcon(img));
            txt_matkhau.setEchoChar('\u25cf');
              txt_nhaplai.setEchoChar('\u25cf');
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbl_TKNV = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_hinh = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txt_MaNV = new javax.swing.JTextField();
        txt_TenNV = new javax.swing.JTextField();
        rab_Nam = new javax.swing.JRadioButton();
        rab_Nu = new javax.swing.JRadioButton();
        Date_Ngaysinh = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date_Ngaylam = new com.toedter.calendar.JDateChooser();
        cbb_Luong = new javax.swing.JComboBox<>();
        txt_Diachi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Ghichu = new javax.swing.JTextPane();
        btnEye = new javax.swing.JButton();
        btnEye2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_Tenuser = new javax.swing.JTextField();
        rab_nhanvien = new javax.swing.JRadioButton();
        rab_quanly = new javax.swing.JRadioButton();
        txt_matkhau = new javax.swing.JPasswordField();
        txt_nhaplai = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Nhanvien = new javax.swing.JTable();
        btn_themluong = new javax.swing.JButton();
        btn_xoatk = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_Capnhat = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_moi1 = new javax.swing.JButton();
        btn_themtk = new javax.swing.JButton();
        btn_capnhaptk = new javax.swing.JButton();
        lbl_chuacotk = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1380, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_TKNV.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TKNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TKNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_TKNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 170, 30));

        jLabel1.setText("Mã Nhân Viên");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel2.setText("Tên Nhân Viên");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel3.setText("Giới Tính");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel4.setText("Ngày Sinh");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        lbl_hinh.setBackground(new java.awt.Color(255, 102, 102));
        lbl_hinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_hinh.setText("Hình");
        lbl_hinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_hinh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_hinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hinhMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_hinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 170, 210));

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 10, 400));
        jPanel1.add(txt_MaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 160, 30));
        jPanel1.add(txt_TenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 160, 30));

        buttonGroup1.add(rab_Nam);
        rab_Nam.setText("Nam");
        jPanel1.add(rab_Nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        buttonGroup1.add(rab_Nu);
        rab_Nu.setText("Nữ");
        jPanel1.add(rab_Nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));
        jPanel1.add(Date_Ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 160, 30));

        jLabel7.setText("Ngày Bắt Đầu Làm");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        jLabel8.setText("Lương");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        jLabel9.setText("Địa Chỉ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        jLabel10.setText("Ghi Chú");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, -1));
        jPanel1.add(date_Ngaylam, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 180, 30));

        jPanel1.add(cbb_Luong, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 180, 30));
        jPanel1.add(txt_Diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 250, 30));

        jScrollPane1.setViewportView(txt_Ghichu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 250, 50));

        btnEye.setBackground(new java.awt.Color(255, 255, 255));
        btnEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/eyeHideBlack.png"))); // NOI18N
        btnEye.setBorder(null);
        btnEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEyeActionPerformed(evt);
            }
        });
        jPanel1.add(btnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 120, 40, 40));

        btnEye2.setBackground(new java.awt.Color(255, 255, 255));
        btnEye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/eyeHideBlack.png"))); // NOI18N
        btnEye2.setBorder(null);
        btnEye2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEye2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEye2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 230, 40, 40));

        jLabel11.setText("Số Điện Thoại");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));
        jPanel1.add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 170, 30));

        jLabel12.setText("Tài Khoản Của Nhân Viên");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, -1));

        jLabel13.setText("Tên User");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, -1, -1));

        jLabel14.setText("Quyền");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, -1, -1));

        jLabel15.setText("Mật Khẩu");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 90, -1, -1));

        jLabel16.setText("Nhập Lại");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 200, -1, -1));
        jPanel1.add(txt_Tenuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 170, 40));

        buttonGroup2.add(rab_nhanvien);
        rab_nhanvien.setText("Nhân Viên");
        jPanel1.add(rab_nhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, -1, -1));

        buttonGroup2.add(rab_quanly);
        rab_quanly.setText("Quản Lý");
        jPanel1.add(rab_quanly, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, -1, -1));
        jPanel1.add(txt_matkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, 160, 40));
        jPanel1.add(txt_nhaplai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 230, 160, 40));

        tbl_Nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Ngày Sinh", "Số Điện Thoai", "Địa Chỉ"
            }
        ));
        tbl_Nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Nhanvien);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 1260, 190));

        btn_themluong.setText("Thêm");
        btn_themluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themluongActionPerformed(evt);
            }
        });
        jPanel1.add(btn_themluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 60, 30));

        btn_xoatk.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoatk.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoatk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnxoa.png"))); // NOI18N
        btn_xoatk.setBorder(null);
        btn_xoatk.setBorderPainted(false);
        btn_xoatk.setContentAreaFilled(false);
        btn_xoatk.setDefaultCapable(false);
        btn_xoatk.setFocusPainted(false);
        btn_xoatk.setFocusable(false);
        btn_xoatk.setIconTextGap(0);
        btn_xoatk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoatkActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoatk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 300, 110, 40));

        btn_Them.setBackground(new java.awt.Color(255, 255, 255));
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnthem.png"))); // NOI18N
        btn_Them.setBorder(null);
        btn_Them.setBorderPainted(false);
        btn_Them.setContentAreaFilled(false);
        btn_Them.setDefaultCapable(false);
        btn_Them.setFocusPainted(false);
        btn_Them.setFocusable(false);
        btn_Them.setIconTextGap(0);
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 110, 40));

        btn_Capnhat.setBackground(new java.awt.Color(255, 255, 255));
        btn_Capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_Capnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btncapnhat.png"))); // NOI18N
        btn_Capnhat.setBorder(null);
        btn_Capnhat.setBorderPainted(false);
        btn_Capnhat.setContentAreaFilled(false);
        btn_Capnhat.setDefaultCapable(false);
        btn_Capnhat.setFocusPainted(false);
        btn_Capnhat.setFocusable(false);
        btn_Capnhat.setIconTextGap(0);
        btn_Capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapnhatActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Capnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 110, 40));

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnxoa.png"))); // NOI18N
        btn_xoa.setBorder(null);
        btn_xoa.setBorderPainted(false);
        btn_xoa.setContentAreaFilled(false);
        btn_xoa.setDefaultCapable(false);
        btn_xoa.setFocusPainted(false);
        btn_xoa.setFocusable(false);
        btn_xoa.setIconTextGap(0);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 110, 40));

        btn_moi1.setBackground(new java.awt.Color(255, 255, 255));
        btn_moi1.setForeground(new java.awt.Color(255, 255, 255));
        btn_moi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnmoi.png"))); // NOI18N
        btn_moi1.setBorder(null);
        btn_moi1.setBorderPainted(false);
        btn_moi1.setContentAreaFilled(false);
        btn_moi1.setDefaultCapable(false);
        btn_moi1.setFocusPainted(false);
        btn_moi1.setFocusable(false);
        btn_moi1.setIconTextGap(0);
        btn_moi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moi1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_moi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 110, 40));

        btn_themtk.setBackground(new java.awt.Color(255, 255, 255));
        btn_themtk.setForeground(new java.awt.Color(255, 255, 255));
        btn_themtk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnthem.png"))); // NOI18N
        btn_themtk.setBorder(null);
        btn_themtk.setBorderPainted(false);
        btn_themtk.setContentAreaFilled(false);
        btn_themtk.setDefaultCapable(false);
        btn_themtk.setFocusPainted(false);
        btn_themtk.setFocusable(false);
        btn_themtk.setIconTextGap(0);
        btn_themtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themtkActionPerformed(evt);
            }
        });
        jPanel1.add(btn_themtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 110, 40));

        btn_capnhaptk.setBackground(new java.awt.Color(255, 255, 255));
        btn_capnhaptk.setForeground(new java.awt.Color(255, 255, 255));
        btn_capnhaptk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btncapnhat.png"))); // NOI18N
        btn_capnhaptk.setBorder(null);
        btn_capnhaptk.setBorderPainted(false);
        btn_capnhaptk.setContentAreaFilled(false);
        btn_capnhaptk.setDefaultCapable(false);
        btn_capnhaptk.setFocusPainted(false);
        btn_capnhaptk.setFocusable(false);
        btn_capnhaptk.setIconTextGap(0);
        btn_capnhaptk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhaptkActionPerformed(evt);
            }
        });
        jPanel1.add(btn_capnhaptk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 110, 40));

        lbl_chuacotk.setForeground(new java.awt.Color(204, 0, 0));
        lbl_chuacotk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_chuacotk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 170, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
public static String MaNV;
    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
         GanDuLieu();
        boolean kt = BLL.BLL_NhanVien.KT_Them(nv);
        if (kt) {
            DAO.DAO_NhanVien.Them(nv);
            save_IMG(f);
            BLL.BLL_NhanVien.DoDuLieuBang(tbl_Nhanvien);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_CapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapnhatActionPerformed
        // TODO add your handling code here:
         GanDuLieu();
        boolean kt = BLL.BLL_NhanVien.KT_Sua(nv);
        if (kt) {
            DAO.DAO_NhanVien.Sua(nv);
            save_IMG(f);
            BLL.BLL_NhanVien.DoDuLieuBang(tbl_Nhanvien);
            pnl_NhanVienNew.MaNV = null;
            LamMoi();
        }
    }//GEN-LAST:event_btn_CapnhatActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_Nhanvien.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                String MaNV = tbl_Nhanvien.getValueAt(cacdong[i], 0).toString();
                if (BLL.BLL_NhanVien.KT_Xoa(MaNV)) {// kiểm tra nhân viên đang có tài khoản hay không
                     DAO.DAO_NhanVien.Xoa(MaNV);    
                }
               
            }
            LamMoi();
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_moi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moi1ActionPerformed
        // TODO add your handling code here:
        LamMoi();
    }//GEN-LAST:event_btn_moi1ActionPerformed

    private void btn_themtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themtkActionPerformed
        // TODO add your handling code here:
        DTO.DTO_User u = new DTO_User();
        u.setTenUser(txt_Tenuser.getText());
        u.setMK(String.valueOf(txt_matkhau.getPassword()));
        if (rab_quanly.isSelected()) {
            u.setQuyen("QuanLy");
        } else {
            u.setQuyen("NhanVien");
        }
        String NhapLai = String.valueOf(txt_nhaplai.getPassword());
        if (BLL.BLL_User.KT_Them(u, NhapLai)) {
            DAO.DAO_User.Them(u);
            LamMoi();

        }
    }//GEN-LAST:event_btn_themtkActionPerformed

    private void btn_capnhaptkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhaptkActionPerformed
        // TODO add your handling code here:
         DTO.DTO_User sua = new DTO_User();
        sua.setTenUser(txt_Tenuser.getText());
        sua.setMK(String.valueOf(txt_matkhau.getPassword()));
        if (rab_quanly.isSelected()) {
            sua.setQuyen("QuanLy");
        } else {
            sua.setQuyen("NhanVien");
        }
        String NhapLai = String.valueOf(txt_nhaplai.getPassword());
        if (BLL.BLL_User.KT_Sua(sua, NhapLai)) {
            DAO.DAO_User.Sua(sua);
            LamMoi();
        }else{}
    }//GEN-LAST:event_btn_capnhaptkActionPerformed

    private void btn_xoatkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoatkActionPerformed
        // TODO add your handling code here:
         int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "Bạn chắc chắn xóa?", "Xóa", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {//xóa theo MaNV đã chọn
            if (BLL.BLL_User.KT_Xoa(MaNV)) {
                 DAO.DAO_User.Xoa();
            }           
            LamMoi();
        }
    }//GEN-LAST:event_btn_xoatkActionPerformed

    private void btn_themluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themluongActionPerformed
        // TODO add your handling code here:
         FrmMain frm = FrmMain.b;
        try {
            frm.tab.setSelectedComponent(pnl_LoaiLuong.form);
        } catch (Exception e) {
            pnl_LoaiLuong pnl = new pnl_LoaiLuong();
            frm.tab.add("Lương", pnl);
            frm.tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_btn_themluongActionPerformed

    private void tbl_NhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanvienMouseClicked
        // TODO add your handling code here:
         if (tbl_Nhanvien.getSelectedRowCount() == 1) {
            txt_MaNV.setFocusable(false);
            btn_Capnhat.setEnabled(true);
            btn_xoa.setEnabled(true);
            btn_capnhaptk.setEnabled(true);
            btn_xoatk.setEnabled(true);
        }
        int vitri = tbl_Nhanvien.getSelectedRow();
        MaNV = tbl_Nhanvien.getValueAt(vitri, 0).toString();
        if (BLL.BLL_NhanVien.XemTK(MaNV)) {
//            jPanel2.setVisible(true);
            DienDuLieu();
            lbl_chuacotk.setText("");
            btn_themtk.setEnabled(false);
            txt_Tenuser.setFocusable(false);
            btn_capnhaptk.setEnabled(true);
            btn_xoatk.setEnabled(true);
        } else {
//            jPanel2.setVisible(false);
            DienDuLieu();
            lbl_chuacotk.setText("( chưa có tài khoản )");
            btn_themtk.setEnabled(true);
            txt_Tenuser.setFocusable(true);
            btn_capnhaptk.setEnabled(false);
            btn_xoatk.setEnabled(false);
        }
        ResultSet rs = DAO.DAO_NhanVien.LayNVTheoMa(MaNV);
        try {
            if (rs.next()) {
                txt_MaNV.setText(rs.getString("MaNhanVien"));
                txt_TenNV.setText(rs.getString("TenNhanVien"));
                lbl_TKNV.setText(rs.getString("TenNhanVien"));
                boolean gt = rs.getBoolean("GioiTinh");
                if (gt) {
                    rab_Nam.setSelected(true);
                } else {
                    rab_Nu.setSelected(true);
                }
                Date_Ngaysinh.setDate(rs.getDate("NgaySinh"));
                date_Ngaylam.setDate(rs.getDate("NgayBatDauLam"));
                txt_SDT.setText(rs.getString("SoDienThoai"));
                String MaLuong = rs.getString("MaLuong");
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_Luong.getModel();
                for (int i = 0; i < cbb_Luong.getItemCount(); i++) {
                    mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
                    if (MaLuong.equals(mb.value)) {
                        cbb_Luong.setSelectedIndex(i);
                    } else {
                    }
                }
                txt_Diachi.setText(rs.getString("DiaChi"));
                txt_Ghichu.setText(rs.getString("GhiChu"));
                imageName = rs.getString("Hinh");
//                ImageIcon ii = new ImageIcon(new ImageIcon(imageName).getImage().getScaledInstance(lbl_Hinh.getWidth(), lbl_Hinh.getHeight(), Image.SCALE_SMOOTH));
//                lbl_Hinh.setIcon(ii);
                lbl_ImageNV(imageName);
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_tbl_NhanvienMouseClicked

    private void lbl_hinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hinhMouseClicked
        // TODO add your handling code here:
         JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int resuft = file.showOpenDialog(null);
        if (resuft == JFileChooser.APPROVE_OPTION) {
            f = file.getSelectedFile();
            imageName = f.getAbsolutePath();
            ImageIcon ii = new ImageIcon(new ImageIcon(imageName).getImage().getScaledInstance(lbl_hinh.getWidth(), lbl_hinh.getHeight(), Image.SCALE_SMOOTH));
            lbl_hinh.setIcon(ii);
            imageName = f.getName();
        }
        System.out.println(imageName);
    }//GEN-LAST:event_lbl_hinhMouseClicked

    private void btnEyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEyeActionPerformed
        // TODO add your handling code here:
        showHidePassword();
    }//GEN-LAST:event_btnEyeActionPerformed

    private void btnEye2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEye2ActionPerformed
        // TODO add your handling code here:
        showHidePassword();
    }//GEN-LAST:event_btnEye2ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
          String TuKhoa = txtTimKiem.getText();
        if (TuKhoa.equals("")) {
            BLL.BLL_NhanVien.DoDuLieuBang(tbl_Nhanvien);
        } else {
            BLL.BLL_NhanVien.DoDuLieuTimKiem(tbl_Nhanvien, TuKhoa);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_Ngaysinh;
    private javax.swing.JButton btnEye;
    private javax.swing.JButton btnEye2;
    private javax.swing.JButton btn_Capnhat;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_capnhaptk;
    private javax.swing.JButton btn_moi1;
    private javax.swing.JButton btn_themluong;
    private javax.swing.JButton btn_themtk;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_xoatk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbb_Luong;
    private com.toedter.calendar.JDateChooser date_Ngaylam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_TKNV;
    private javax.swing.JLabel lbl_chuacotk;
    private javax.swing.JLabel lbl_hinh;
    private javax.swing.JRadioButton rab_Nam;
    private javax.swing.JRadioButton rab_Nu;
    private javax.swing.JRadioButton rab_nhanvien;
    private javax.swing.JRadioButton rab_quanly;
    private javax.swing.JTable tbl_Nhanvien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txt_Diachi;
    private javax.swing.JTextPane txt_Ghichu;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenNV;
    private javax.swing.JTextField txt_Tenuser;
    private javax.swing.JPasswordField txt_matkhau;
    private javax.swing.JPasswordField txt_nhaplai;
    // End of variables declaration//GEN-END:variables
}
