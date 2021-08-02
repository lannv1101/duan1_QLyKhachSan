/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DTO_Phong;
import static GUI.FrmQLphongNew.P;
import static GUI.FrmQLphongNew.imageName;
import static GUI.FrmQLphongNew.save_IMG;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class FrmQLphongNew extends javax.swing.JFrame {
    public static FrmQLphongNew form;
    public static DTO.DTO_Phong P = new DTO_Phong();
    public static String imageName = null;
    File f;
    /**
     * Creates new form FrmQLphongNew
     */
    public FrmQLphongNew() {
        initComponents();
        form = this;
        BLL.BLL_Phong.Load_cbbTang(cbb_Chontang);
        rab_Chontang.setSelected(true);
        setLocationRelativeTo(null);
    }
    public static boolean save_IMG(File file) {
        File dir = new File("IMG_Phong");
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
        ImageIcon icon = new ImageIcon("IMG_Phong\\" + ImagePath);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lbl_hinh.getWidth(), lbl_hinh.getHeight(), image.SCALE_SMOOTH));
        lbl_hinh.setIcon(icon1);
    }
    private void LuaChon() {//lựa chọn tầng hay tự nhập tầng
        if (rab_Chontang.isSelected()) {
            txt_Nhaptang.setEnabled(false);
            cbb_Chontang.setEnabled(true);
        } else {
            cbb_Chontang.setEnabled(false);
            txt_Nhaptang.setEnabled(true);
        }
    }
    private void GanThongTin() {
        P.setMaPhong(txt_Maphong.getText());
        P.setDienTich(txt_Dientich.getText());
        P.setGhiChu(txt_ghichu.getText());
        mycombobox mb = (mycombobox) cbb_Loaiphong.getSelectedItem();
        P.setMaLoaiPhong(mb.value.toString());
        P.setGiuongDon(txt_Giuongdon.getText());
        P.setGiuongDoi(txt_Giuongdoi.getText());
        if (rab_Chontang.isSelected()) {
            P.setTang(cbb_Chontang.getSelectedItem().toString());
            System.out.println("tang " + P.getTang());
        } else {
            P.setTang(txt_Nhaptang.getText());
        }
//        System.out.println("loaiphong" + P.getMaLoaiPhong());
        P.setHinh(imageName);
    }
     private void DienTTVaoTextField(String MaPhong) {
        ResultSet rs = DAO.DAO_Phong.LayTheoMa(MaPhong);
        try {
            if (rs.next()) {
                txt_Maphong.setText(rs.getString("MaPhong"));
                txt_Dientich.setText(String.valueOf(rs.getInt("DienTich")));
                txt_ghichu.setText(rs.getString("GhiChu"));
                imageName = rs.getString("Hinh");
//                ImageIcon ii = new ImageIcon(new ImageIcon(imageName).getImage().getScaledInstance(lbl_Anh2.getWidth(), lbl_Anh2.getHeight(), Image.SCALE_SMOOTH));
//                lbl_Anh2.setIcon(ii);
                lbl_ImageNV(imageName);
                String MaLoaiPhong = rs.getString("MaLoaiPhong");
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_Loaiphong.getModel();
                for (int i = 0; i < cbb_Loaiphong.getItemCount(); i++) {
                    mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
                    if (MaLoaiPhong.equals(mb.value)) {
                        txt_Nhaptang.setEnabled(false);
                        rab_Chontang.setSelected(true);
                        cbb_Chontang.setEnabled(true);
                        cbb_Loaiphong.setSelectedIndex(i);
                    } else {
                    }
                }
                for (int i = 0; i < cbb_Chontang.getItemCount(); i++) {
                    if (rs.getString("MaTang").matches(cbb_Chontang.getItemAt(i))) {
                        cbb_Chontang.setSelectedIndex(i);
                    } else {

                    }
                }
                txt_Giuongdon.setText(rs.getString("GiuongDon"));
                txt_Giuongdon.setText(rs.getString("GiuongDoi"));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
     private void LamMoi() {
        BLL.BLL_Phong.DoDuLieuBang(tbl_Phong);
        BLL.BLL_Phong.loadData_LoaiPhong(cbb_Loaiphong);
        txt_Maphong.setText("");
        txt_Dientich.setText("");
        txt_ghichu.setText("");
        txt_Maphong.setFocusable(true);
        imageName = null;
        lbl_hinh.setIcon(null);
        btn_Capnhat.setEnabled(false);
        btn_xoa.setEnabled(false);
        txt_Giuongdoi.setText("0");
        txt_Giuongdon.setText("0");
    }
     private void SoLuongGiuongDon(int giatri) {
        int sl = Integer.parseInt(txt_Giuongdon.getText());
        sl = sl + (giatri);
        txt_Giuongdon.setText(String.valueOf(sl));
    }

    private void SoLuongGiuongDoi(int giatri) {
        int sl = Integer.parseInt(txt_Giuongdoi.getText());
        sl = sl + (giatri);
        txt_Giuongdoi.setText(String.valueOf(sl));
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
        jPanel1 = new javax.swing.JPanel();
        pnl_TieuDe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        tab = new javax.swing.JTabbedPane();
        pnl_Phong = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Phong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_hinh = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Maphong = new javax.swing.JTextField();
        txt_Dientich = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbb_Loaiphong = new javax.swing.JComboBox<>();
        rab_Chontang = new javax.swing.JRadioButton();
        rab_Nhaptang = new javax.swing.JRadioButton();
        cbb_Chontang = new javax.swing.JComboBox<>();
        txt_Giuongdon = new javax.swing.JTextField();
        txt_Giuongdoi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ghichu = new javax.swing.JTextPane();
        btn_tru = new javax.swing.JButton();
        btn_cong = new javax.swing.JButton();
        btn_tru2 = new javax.swing.JButton();
        btn_Cong2 = new javax.swing.JButton();
        txt_Nhaptang = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        btn_Capnhat = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_moi1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_TieuDe.setBackground(new java.awt.Color(0, 51, 102));
        pnl_TieuDe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản Lý Phòng");
        pnl_TieuDe.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/closeMain.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setContentAreaFilled(false);
        btnClose.setDefaultCapable(false);
        btnClose.setFocusPainted(false);
        btnClose.setFocusable(false);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnl_TieuDe.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        jPanel1.add(pnl_TieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 50));

        pnl_Phong.setBackground(new java.awt.Color(0, 153, 153));
        pnl_Phong.setPreferredSize(new java.awt.Dimension(860, 600));
        pnl_Phong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Phong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phòng", "Loại Phòng", "Diện Tích", "Hình", "Tình Trạng", "Tầng"
            }
        ));
        tbl_Phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Phong);

        pnl_Phong.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 180));

        jLabel2.setText("Mã Phòng");
        pnl_Phong.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jLabel3.setText("Loại Phòng");
        pnl_Phong.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel4.setText("Diện Tích");
        pnl_Phong.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        lbl_hinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_hinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hinhMouseClicked(evt);
            }
        });
        pnl_Phong.add(lbl_hinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 170, 250));

        jLabel6.setText("Tầng");
        pnl_Phong.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        jLabel7.setText("Số Giường Đơn");
        pnl_Phong.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        jLabel8.setText("Số Giường Đôi");
        pnl_Phong.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        jLabel9.setText("Ghi Chú");
        pnl_Phong.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));
        pnl_Phong.add(txt_Maphong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 200, 30));
        pnl_Phong.add(txt_Dientich, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 200, 30));

        jLabel11.setText("m2");
        pnl_Phong.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

        cbb_Loaiphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnl_Phong.add(cbb_Loaiphong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 200, 30));

        buttonGroup1.add(rab_Chontang);
        rab_Chontang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rab_ChontangActionPerformed(evt);
            }
        });
        pnl_Phong.add(rab_Chontang, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        buttonGroup1.add(rab_Nhaptang);
        rab_Nhaptang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rab_NhaptangActionPerformed(evt);
            }
        });
        pnl_Phong.add(rab_Nhaptang, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        pnl_Phong.add(cbb_Chontang, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 160, 20));

        txt_Giuongdon.setText("0");
        txt_Giuongdon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GiuongdonActionPerformed(evt);
            }
        });
        pnl_Phong.add(txt_Giuongdon, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 200, 30));

        txt_Giuongdoi.setText("0");
        txt_Giuongdoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GiuongdoiActionPerformed(evt);
            }
        });
        pnl_Phong.add(txt_Giuongdoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 200, 30));

        jScrollPane2.setViewportView(txt_ghichu);

        pnl_Phong.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 200, 80));

        btn_tru.setText("-");
        btn_tru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_truActionPerformed(evt);
            }
        });
        pnl_Phong.add(btn_tru, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, -1, 30));

        btn_cong.setText("+");
        btn_cong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_congActionPerformed(evt);
            }
        });
        pnl_Phong.add(btn_cong, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 40, 30));

        btn_tru2.setText("-");
        btn_tru2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tru2ActionPerformed(evt);
            }
        });
        pnl_Phong.add(btn_tru2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, -1, 30));

        btn_Cong2.setText("+");
        btn_Cong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cong2ActionPerformed(evt);
            }
        });
        pnl_Phong.add(btn_Cong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 40, 30));
        pnl_Phong.add(txt_Nhaptang, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 160, 30));

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
        pnl_Phong.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 110, 40));

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
        pnl_Phong.add(btn_Capnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 110, 40));

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
        pnl_Phong.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 110, 40));

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
        pnl_Phong.add(btn_moi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 110, 40));

        tab.addTab("Phòng", pnl_Phong);

        jPanel1.add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, -1, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        GanThongTin();
        if (BLL.BLL_Phong.Them(P)) {
            DAO.DAO_Phong.ThemPhong(P);
            BLL.BLL_Phong.DoDuLieuBang(tbl_Phong);
            save_IMG(f);
            //BLL.BLL_Phong.Load_cbbTang(cbb_Chontang);
            LamMoi();
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_CapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapnhatActionPerformed
        // TODO add your handling code here:
         GanThongTin();
        if (BLL.BLL_Phong.KT_Sua(P)) {
            DAO.DAO_Phong.Sua(P);
            save_IMG(f);
            // BLL.BLL_Phong.Load_cbbTang(cbb_Chontang);
            LamMoi();
        }
    }//GEN-LAST:event_btn_CapnhatActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
         int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_Phong.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                String MaPhong = tbl_Phong.getValueAt(cacdong[i], 0).toString();
                if (BLL.BLL_Phong.KT_Xoa(MaPhong)) {
                    DAO.DAO_Phong.Xoa(MaPhong);
                    LamMoi();
                }

            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_moi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moi1ActionPerformed
        // TODO add your handling code here:
        LamMoi();
        imageName = null;
        lbl_hinh.setIcon(null);
    }//GEN-LAST:event_btn_moi1ActionPerformed

    private void btn_truActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_truActionPerformed
        // TODO add your handling code here:
                if (!txt_Giuongdon.getText().equals("0")) {
            SoLuongGiuongDon(-1);

        }
    }//GEN-LAST:event_btn_truActionPerformed

    private void btn_congActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_congActionPerformed
        // TODO add your handling code here:
        SoLuongGiuongDon(1);
    }//GEN-LAST:event_btn_congActionPerformed

    private void btn_tru2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tru2ActionPerformed
        // TODO add your handling code here:
           if (!txt_Giuongdoi.getText().equals("0")) {
            SoLuongGiuongDoi(-1);
           }
    }//GEN-LAST:event_btn_tru2ActionPerformed

    private void btn_Cong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cong2ActionPerformed
        // TODO add your handling code here:
        SoLuongGiuongDoi(1);
    }//GEN-LAST:event_btn_Cong2ActionPerformed

    private void rab_ChontangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rab_ChontangActionPerformed
        // TODO add your handling code here:
        LuaChon();
    }//GEN-LAST:event_rab_ChontangActionPerformed

    private void rab_NhaptangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rab_NhaptangActionPerformed
        // TODO add your handling code here:
        LuaChon();
    }//GEN-LAST:event_rab_NhaptangActionPerformed

    private void tbl_PhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PhongMouseClicked
        // TODO add your handling code here:
        if (tbl_Phong.getSelectedRowCount() == 1) {
            btn_Capnhat.setEnabled(true);
            btn_xoa.setEnabled(true);
            txt_Maphong.setFocusable(false);
            int vitri = tbl_Phong.getSelectedRow();
            String MaPhong = tbl_Phong.getValueAt(vitri, 0).toString();
            DienTTVaoTextField(MaPhong);

        }
    }//GEN-LAST:event_tbl_PhongMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         BLL.BLL_Phong.DoDuLieuBang(tbl_Phong);
        BLL.BLL_Phong.loadData_LoaiPhong(cbb_Loaiphong);
        pnl_LoaiPhong pnl = new pnl_LoaiPhong();
        tab.add("Loại Phòng", pnl);
        btn_Capnhat.setEnabled(false);
        btn_xoa.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

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
    }//GEN-LAST:event_lbl_hinhMouseClicked

    private void txt_GiuongdoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GiuongdoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GiuongdoiActionPerformed

    private void txt_GiuongdonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GiuongdonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GiuongdonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmQLphongNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLphongNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLphongNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLphongNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLphongNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btn_Capnhat;
    private javax.swing.JButton btn_Cong2;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_cong;
    private javax.swing.JButton btn_moi1;
    private javax.swing.JButton btn_tru;
    private javax.swing.JButton btn_tru2;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_Chontang;
    private javax.swing.JComboBox<String> cbb_Loaiphong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_hinh;
    private javax.swing.JPanel pnl_Phong;
    private javax.swing.JPanel pnl_TieuDe;
    private javax.swing.JRadioButton rab_Chontang;
    private javax.swing.JRadioButton rab_Nhaptang;
    public javax.swing.JTabbedPane tab;
    private javax.swing.JTable tbl_Phong;
    private javax.swing.JTextField txt_Dientich;
    private javax.swing.JTextField txt_Giuongdoi;
    private javax.swing.JTextField txt_Giuongdon;
    private javax.swing.JTextField txt_Maphong;
    private javax.swing.JTextField txt_Nhaptang;
    private javax.swing.JTextPane txt_ghichu;
    // End of variables declaration//GEN-END:variables
}
