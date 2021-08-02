/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DTO_Luong;
import DTO.DTO_NhanLuong;
import java.awt.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.Hashtable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ADMIN
 */
public class pnl_LoaiLuong extends javax.swing.JPanel {

    /**
     * Creates new form pnl_Luong
     */
    public static pnl_LoaiLuong form;

    public pnl_LoaiLuong() {
        initComponents();

        form = this;
        BLL.BLL_Luong.dodulieu(tbl_Luong);
        tbl_Luong.getTableHeader().setOpaque(false);
        tbl_Luong.getTableHeader().setBackground(new Color(255, 102, 102));
        BLL.BLL_Luong.DoDuLieuBang(tbl_NV);
//        double random=Math.random()*10;
//        lbl_random.setText(String.valueOf(random));
//        Demo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        lbl_MaLuong = new javax.swing.JLabel();
        txt_maluong = new javax.swing.JTextField();
        lbl_LuongTheoGio = new javax.swing.JLabel();
        txt_LuongTheoGio = new javax.swing.JTextField();
        lbl_SoGioLam = new javax.swing.JLabel();
        txt_SoGioLam = new javax.swing.JTextField();
        btn_Tru = new javax.swing.JButton();
        btn_Cong = new javax.swing.JButton();
        lbl_GhiChu = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_GhiChu = new javax.swing.JTextArea();
        btn_Them = new javax.swing.JButton();
        btn_Capnhat = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Luong = new javax.swing.JTable();
        pnl2 = new javax.swing.JPanel();
        lbl_TenNV = new javax.swing.JLabel();
        txt_TenNV = new javax.swing.JTextField();
        lbl_SoNGayNghi = new javax.swing.JLabel();
        txt_SoNgayNghi = new javax.swing.JTextField();
        lbl_SoNgayLam = new javax.swing.JLabel();
        txt_SoNgayLam = new javax.swing.JTextField();
        lbl_LuongTheoGio2 = new javax.swing.JLabel();
        txt_LuongTheoGio2 = new javax.swing.JTextField();
        lbl_SoGioLam2 = new javax.swing.JLabel();
        txt_SoGioLam2 = new javax.swing.JTextField();
        lbl_TongNhan = new javax.swing.JLabel();
        txt_TongLuong = new javax.swing.JTextField();
        lbl_MaNhanLuong2 = new javax.swing.JLabel();
        lbl_MaNhanLuong = new javax.swing.JLabel();
        btn_XuatPhieuluong = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_NV = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1243, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl.setBackground(new java.awt.Color(153, 153, 255));
        pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MaLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_MaLuong.setText("Mã lương");
        pnl.add(lbl_MaLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        txt_maluong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnl.add(txt_maluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 190, 30));

        lbl_LuongTheoGio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_LuongTheoGio.setText("Lương theo giờ");
        pnl.add(lbl_LuongTheoGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        txt_LuongTheoGio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_LuongTheoGio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_LuongTheoGioKeyReleased(evt);
            }
        });
        pnl.add(txt_LuongTheoGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 190, 40));

        lbl_SoGioLam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_SoGioLam.setText("Số giờ làm");
        pnl.add(lbl_SoGioLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        txt_SoGioLam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_SoGioLam.setText("01");
        txt_SoGioLam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SoGioLamKeyReleased(evt);
            }
        });
        pnl.add(txt_SoGioLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 190, 40));

        btn_Tru.setText("-");
        btn_Tru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TruActionPerformed(evt);
            }
        });
        pnl.add(btn_Tru, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 40, 40));

        btn_Cong.setText("+");
        btn_Cong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CongActionPerformed(evt);
            }
        });
        pnl.add(btn_Cong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 40, 40));

        lbl_GhiChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_GhiChu.setText("Ghi chú");
        pnl.add(lbl_GhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        txt_GhiChu.setColumns(20);
        txt_GhiChu.setRows(5);
        jScrollPane2.setViewportView(txt_GhiChu);

        pnl.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 233, 60));

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
        pnl.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 110, 40));

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
                btn_SuaActionPerformed(evt);
            }
        });
        pnl.add(btn_Capnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 110, 40));

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
                btn_XoaActionPerformed(evt);
            }
        });
        pnl.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 110, 40));

        btn_moi.setBackground(new java.awt.Color(255, 255, 255));
        btn_moi.setForeground(new java.awt.Color(255, 255, 255));
        btn_moi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnmoi.png"))); // NOI18N
        btn_moi.setBorder(null);
        btn_moi.setBorderPainted(false);
        btn_moi.setContentAreaFilled(false);
        btn_moi.setDefaultCapable(false);
        btn_moi.setFocusPainted(false);
        btn_moi.setFocusable(false);
        btn_moi.setIconTextGap(0);
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        pnl.add(btn_moi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 110, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Loại Lương", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tbl_Luong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lương", "Lương theo giờ", "Số giờ làm"
            }
        ));
        tbl_Luong.setFocusable(false);
        tbl_Luong.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_Luong.setRowHeight(25);
        tbl_Luong.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tbl_Luong.setShowVerticalLines(false);
        tbl_Luong.getTableHeader().setReorderingAllowed(false);
        tbl_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_LuongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Luong);

        pnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 250));

        add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 660));

        pnl2.setBackground(new java.awt.Color(153, 153, 255));
        pnl2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_TenNV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_TenNV.setText("Tên nhân viên");
        pnl2.add(lbl_TenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        txt_TenNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_TenNV.setFocusable(false);
        pnl2.add(txt_TenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 170, 30));

        lbl_SoNGayNghi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_SoNGayNghi.setText("Số ngày nghỉ");
        pnl2.add(lbl_SoNGayNghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, 20));

        txt_SoNgayNghi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_SoNgayNghi.setText("0");
        txt_SoNgayNghi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SoNgayNghiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SoNgayNghiKeyTyped(evt);
            }
        });
        pnl2.add(txt_SoNgayNghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 170, 30));

        lbl_SoNgayLam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_SoNgayLam.setText("Số ngày làm");
        pnl2.add(lbl_SoNgayLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, 20));

        txt_SoNgayLam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_SoNgayLam.setText("0");
        txt_SoNgayLam.setFocusable(false);
        pnl2.add(txt_SoNgayLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 170, 30));

        lbl_LuongTheoGio2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_LuongTheoGio2.setText("Lương theo giờ");
        pnl2.add(lbl_LuongTheoGio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, 20));

        txt_LuongTheoGio2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_LuongTheoGio2.setText("0");
        txt_LuongTheoGio2.setFocusable(false);
        pnl2.add(txt_LuongTheoGio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 170, 30));

        lbl_SoGioLam2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_SoGioLam2.setText("Số giờ làm trong ngày");
        pnl2.add(lbl_SoGioLam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, 20));

        txt_SoGioLam2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_SoGioLam2.setText("0");
        txt_SoGioLam2.setFocusable(false);
        pnl2.add(txt_SoGioLam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 170, 40));

        lbl_TongNhan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_TongNhan.setText("Tổng nhận:");
        pnl2.add(lbl_TongNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));

        txt_TongLuong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_TongLuong.setText("0");
        txt_TongLuong.setFocusable(false);
        pnl2.add(txt_TongLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 250, 50));

        lbl_MaNhanLuong2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_MaNhanLuong2.setText("Mã nhận lương:");
        pnl2.add(lbl_MaNhanLuong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));
        pnl2.add(lbl_MaNhanLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 175, 30));

        btn_XuatPhieuluong.setBackground(new java.awt.Color(255, 255, 255));
        btn_XuatPhieuluong.setForeground(new java.awt.Color(255, 255, 255));
        btn_XuatPhieuluong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnpdf.png"))); // NOI18N
        btn_XuatPhieuluong.setBorder(null);
        btn_XuatPhieuluong.setBorderPainted(false);
        btn_XuatPhieuluong.setContentAreaFilled(false);
        btn_XuatPhieuluong.setDefaultCapable(false);
        btn_XuatPhieuluong.setEnabled(false);
        btn_XuatPhieuluong.setFocusPainted(false);
        btn_XuatPhieuluong.setFocusable(false);
        btn_XuatPhieuluong.setIconTextGap(0);
        btn_XuatPhieuluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatPhieuActionPerformed(evt);
            }
        });
        pnl2.add(btn_XuatPhieuluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 110, 40));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Lương Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tbl_NV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Mã lương", "Ngày  làm"
            }
        ));
        tbl_NV.setRowHeight(25);
        tbl_NV.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tbl_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_NV);

        pnl2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 250));

        add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 0, 880, 678));
    }// </editor-fold>//GEN-END:initComponents

    public static DTO.DTO_Luong L = new DTO_Luong();

    private void GanDuLieu() {
        L.setMaluong(txt_maluong.getText());
        L.setLuonggio(txt_LuongTheoGio.getText());
        L.setSogiolam(txt_SoGioLam.getText());
        L.setGhichu(txt_GhiChu.getText());
    }
    private void tbl_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_LuongMouseClicked
        // TODO add your handling code here:
        if (tbl_Luong.getSelectedRowCount() == 1) {
            int vitri = tbl_Luong.getSelectedRow();
            String maluong = tbl_Luong.getValueAt(vitri, 0).toString();
            DienDuLieuVaoField(maluong);
            txt_maluong.setFocusable(false);
            btn_Capnhat.setEnabled(true);
            btn_xoa.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_LuongMouseClicked

    private void txt_SoGioLamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SoGioLamKeyReleased
        try {
            int sl = Integer.parseInt(txt_SoGioLam.getText());

        } catch (Exception e) {
            txt_SoGioLam.setText("0");

        }
    }//GEN-LAST:event_txt_SoGioLamKeyReleased

    private void btn_TruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TruActionPerformed
        if (Double.parseDouble(txt_SoGioLam.getText()) > 0) {
            SoLuong(-1);

        }
    }//GEN-LAST:event_btn_TruActionPerformed

    private void btn_CongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CongActionPerformed
        SoLuong(1);
    }//GEN-LAST:event_btn_CongActionPerformed

    private void tbl_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NVMouseClicked
        if (tbl_NV.getSelectedRowCount() == 1) {
            GanField();

            //
            btn_XuatPhieuluong.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_NVMouseClicked

    private void txt_SoNgayNghiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SoNgayNghiKeyReleased
//        try {
//            int songaynghi=Integer.parseInt((txt_SoNgayNghi.getText()));
//            int songaylam=Integer.parseInt(txt_SoNgayLam.getText());
//            int songaylam2=songaynghi-songaylam;
//            txt_SoNgayLam.setText(String.valueOf(songaylam2));
//        } catch (Exception e) {
//        }
        try {
            int sl = Integer.parseInt(txt_SoNgayNghi.getText());

        } catch (Exception e) {
            txt_SoNgayNghi.setText("0");
        }
        GanField();
    }//GEN-LAST:event_txt_SoNgayNghiKeyReleased

    private void txt_SoNgayNghiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SoNgayNghiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoNgayNghiKeyTyped
    DTO.DTO_NhanLuong nl = new DTO_NhanLuong();
    String ngayhientai;
    private void btn_XuatPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatPhieuActionPerformed
//gắn DTO nl
        nl.setMaChiTietLuong(lbl_MaNhanLuong.getText());
        nl.setSoNgayNghi(Integer.parseInt(txt_SoNgayNghi.getText()));
        nl.setSoNgayLam(Integer.parseInt(txt_SoNgayLam.getText()));
        nl.setTongNhan(ChuyenDoi.ChuyenSangSo(txt_TongLuong.getText()));
        nl.setNgayNhanLuong(ngayhientai);
        if (BLL.BLL_NhanLuong.KT_MaNhanLuong(nl)) {
            //cập nhật ngày làm của nhân viên vừa trả lương thành hiện tại
            DAO.DAO_NhanLuong.CapNhatNgayLam(nl, ngayhientai);
            //
            DAO.DAO_NhanLuong.Them(nl);
            //xuất phiếu 
            XuatLuong(nl.getMaChiTietLuong());
            LamMoi();
        }

    }//GEN-LAST:event_btn_XuatPhieuActionPerformed
    public void XuatLuong(String MaCTLuong) {
        try {

            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/GUI/rpt_Luong.jrxml");

            map.put("MaChiTietLuong2", MaCTLuong);

            JasperPrint p = JasperFillManager.fillReport(report, map, DAO.connection.conn);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void txt_LuongTheoGioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LuongTheoGioKeyReleased
        try {
//            int sl = Integer.parseInt(txt_TienCoc.getText());
//            String chuoi = txtKhachTra.getText();
            double so = ChuyenDoi.ChuyenSangSo(txt_LuongTheoGio.getText());
            String sotien = ChuyenDoi.DinhDangSo(so);
            txt_LuongTheoGio.setText(sotien);
//txt_TienCoc.setText(ChuyenDoi.DinhDangSo(sl));
        } catch (Exception e) {
//            txt_TienCoc.setText("");
            txt_LuongTheoGio.setText("0");
        }
    }//GEN-LAST:event_txt_LuongTheoGioKeyReleased

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        GanDuLieu();
        if (BLL.BLL_Luong.KT_THem(L)) {
            DAO.DAO_Luong.Them(L);
            BLL.BLL_Luong.dodulieu(tbl_Luong);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
         GanDuLieu();
        if (BLL.BLL_Luong.KT_Sua(L)) {
            DAO.DAO_Luong.Sua(L);
            LamMoi();
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
         int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_Luong.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {

                String maluong = tbl_Luong.getValueAt(cacdong[i], 0).toString();
                if (BLL.BLL_Luong.KT_xoa(maluong)) {// Kiểm tra mã lương khi xóa có đang tồn tại ở nhân viên hay không
                    DAO.DAO_Luong.Xoa(maluong);
                }

            }
            LamMoi();
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        LamMoi();
    }//GEN-LAST:event_btn_LamMoiActionPerformed
    private void DienDuLieuVaoField(String maluong) {
        ResultSet rs = DAO.DAO_Luong.LayLuongTheoMa(maluong);
        try {
            if (rs.next()) {
                txt_maluong.setText(rs.getString("MaLuong"));
                txt_LuongTheoGio.setText(ChuyenDoi.DinhDangSo(rs.getDouble("LuongTheoGio")));
                txt_SoGioLam.setText(rs.getString("SoGioLam"));
                txt_GhiChu.setText(rs.getString("GhiChu"));
            }
        } catch (SQLException ex) {

        }
    }

    private void SoLuong(int giatri) {
        int sl = Integer.parseInt(txt_SoGioLam.getText());
        sl = sl + (giatri);
        txt_SoGioLam.setText(String.valueOf(sl));
    }

    private void LamMoi() {

        FrmMain frm = FrmMain.b;
        frm.tab.remove(form);
        pnl_LoaiLuong pnl = new pnl_LoaiLuong();
        frm.tab.add("Lương", pnl);
        frm.tab.setSelectedComponent(pnl);
    }

    private void GanField() {
        int vitri = tbl_NV.getSelectedRow();
        txt_TenNV.setText(tbl_NV.getValueAt(vitri, 1).toString());
        String maluong = tbl_NV.getValueAt(vitri, 2).toString();
        String MaNhanVien = tbl_NV.getValueAt(vitri, 0).toString();
        //gắn mã nhận lương
        Date d = new Date();
        SimpleDateFormat D = new SimpleDateFormat("ddMMyyyy");
        lbl_MaNhanLuong.setText(D.format(d) + MaNhanVien);
        //
        ResultSet rs = DAO.DAO_Luong.LayLuongTheoMa(maluong);
        try {
            if (rs.next()) {
                txt_LuongTheoGio2.setText(ChuyenDoi.DinhDangSo(rs.getDouble("LuongTheoGio")));
                txt_SoGioLam2.setText(rs.getString("SoGioLam"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(pnl_LoaiLuong.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            TinhNgayLam(ChuyenDoi.GetDate(tbl_NV.getValueAt(vitri, 3).toString()));
        } catch (Exception e) {
            TinhNgayLam(d);
        }
//gắn DTO nl
        nl.setMaNhanVien(MaNhanVien);
    }

    private void TinhNgayLam(Date ngaylam) {

        try {
            Date d = new Date();
            SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
            ngayhientai = D.format(d);//gắn ngày hiện tại 
//            System.out.println("ngày hiện tại"+ngayhientai);
            long ngay = (d.getTime() - ngaylam.getTime()) / (24 * 3600 * 1000);
            int songaynghi = Integer.parseInt(txt_SoNgayNghi.getText());
            int songaylam = (int) (ngay - songaynghi);
            System.out.println("so ngay lam" + songaylam);
            txt_SoNgayLam.setText(String.valueOf(songaylam));

            //tinh tien
            double luongtheogio = ChuyenDoi.ChuyenSangSo(txt_LuongTheoGio2.getText());
            int sogiolam = Integer.parseInt(txt_SoGioLam2.getText());
            double tongluong = sogiolam * luongtheogio * songaylam;
//            System.out.println("luong "+tongluong);
            txt_TongLuong.setText(ChuyenDoi.DinhDangSo(tongluong));
        } catch (Exception e) {
        }

//        System.out.println("so ngay lam"+songaylam);
    }
//    private void Demo(){
//         Date date = Date.valueOf("2011-07-31 01:00:00");
//         Date date2=Date.valueOf("2011-07-31 14:00:00");
//         long a=(date2.getTime()-date.getTime())/(24*3600*1000);
//         System.out.println("thời gian là"+a);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Capnhat;
    private javax.swing.JButton btn_Cong;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Tru;
    private javax.swing.JButton btn_XuatPhieuluong;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_GhiChu;
    private javax.swing.JLabel lbl_LuongTheoGio;
    private javax.swing.JLabel lbl_LuongTheoGio2;
    private javax.swing.JLabel lbl_MaLuong;
    private javax.swing.JLabel lbl_MaNhanLuong;
    private javax.swing.JLabel lbl_MaNhanLuong2;
    private javax.swing.JLabel lbl_SoGioLam;
    private javax.swing.JLabel lbl_SoGioLam2;
    private javax.swing.JLabel lbl_SoNGayNghi;
    private javax.swing.JLabel lbl_SoNgayLam;
    private javax.swing.JLabel lbl_TenNV;
    private javax.swing.JLabel lbl_TongNhan;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl2;
    private javax.swing.JTable tbl_Luong;
    private javax.swing.JTable tbl_NV;
    private javax.swing.JTextArea txt_GhiChu;
    private javax.swing.JTextField txt_LuongTheoGio;
    private javax.swing.JTextField txt_LuongTheoGio2;
    private javax.swing.JTextField txt_SoGioLam;
    private javax.swing.JTextField txt_SoGioLam2;
    private javax.swing.JTextField txt_SoNgayLam;
    private javax.swing.JTextField txt_SoNgayNghi;
    private javax.swing.JTextField txt_TenNV;
    private javax.swing.JTextField txt_TongLuong;
    private javax.swing.JTextField txt_maluong;
    // End of variables declaration//GEN-END:variables
}