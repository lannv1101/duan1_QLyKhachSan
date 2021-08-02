/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DTO_CTDV;
import DTO.DTO_DichVu;
import DTO.DTO_Phong;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author ADMIN
 */
public class pnl_DichVuPhong extends javax.swing.JPanel {

    ArrayList<DTO_DichVu> arrDV = new ArrayList<>();
    /**
     * Creates new form pnl_CungCapDichVu
     */
    public static pnl_DichVuPhong form;
    public static String MaDP0;
    public static String MaDV;

    public pnl_DichVuPhong() {
        initComponents();
        form = this;

        BLL.BLL_DichVu.DoDuLieuBangDatPhong(tbl_ThuePhong);
        ResultSet rs = DAO.DAO_CungCapDichVu.LayDV();
        FillDichVu(rs);
        btn_Them.setEnabled(false);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(50);//tốc độ cuộn chuột JScrollpane

    }

    public void GanDV(String TenDV, String DonVi, String DonGia) {
        lbl_SP.setText(TenDV);
        lbl_DV.setText(DonVi);
        lbl_DG.setText(DonGia);
    }

    public void FillDichVu(ResultSet rs) {
        //làm trống pnl chứa các dịch vụ
        arrDV.clear();
        pnl_DichVu.removeAll();
        
        try {
            while (rs.next()) {
                DTO.DTO_DichVu DV = new DTO_DichVu();
                DV.setMaDV(rs.getString("MaDichVu"));
                DV.setTenDV(rs.getString("TenDichVu"));
                DV.setDonVi(rs.getString("DonVi"));
                DV.setDonGia(ChuyenDoi.DinhDangSo(rs.getDouble("DonGia")));
                DV.setGhiChu(rs.getString("GhiChu"));
                arrDV.add(DV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnl_DichVuPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        int sapxep = arrDV.size();
        if (sapxep % 2 == 0) {
            pnl_DichVu.setLayout(new GridLayout(sapxep / 2, 2,5,5));//so hang, so cot, khoang cach giua cac hang, khoang cach giua cac cot
        } else {
            pnl_DichVu.setLayout(new GridLayout(sapxep / 2 + 1, 2,5,5));//so hang, so cot, khoang cach giua cac hang, khoang cach giua cac cot

        }
        if (arrDV != null) {
            JButton[] btn = new JButton[arrDV.size()];
            for (int i = 0; i < arrDV.size(); i++) {
                btn[i] = new javax.swing.JButton();
                btn[i].setPreferredSize(new Dimension(100, 100));
                btn[i].setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                btn[i].setFont(new java.awt.Font("Times New Roman", 1, 20));
                pnl_DichVu.add(btn[i]);
                pnl_DichVu.updateUI();
                btn[i].setBackground(Color.decode("#0071F3"));
                btn[i].setText("<html><div style=\"color: black;text-align: center;\">" + arrDV.get(i).getTenDV() + "<br>" + arrDV.get(i).getDonGia() + "</div></html>");
                btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icons8-hamper-100.png")));
                String MaDV0 = arrDV.get(i).getMaDV();
                String TenDV = arrDV.get(i).getTenDV();
                String DonVi = arrDV.get(i).getDonVi();
                String DonGia = arrDV.get(i).getDonGia();
                btn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GanDV(TenDV, DonVi, DonGia);
                        MaDV = MaDV0;
                        TienTungDV();
                        if (tbl_ThuePhong.getSelectedRowCount() > 0) {
                            btn_Them.setEnabled(true);
                        }

                    }
                });

            }
        }
    }

    public void TienTungDV() {
        double dongia = ChuyenDoi.ChuyenSangSo(lbl_DG.getText());
        double soluong = ChuyenDoi.ChuyenSangSo(txt_SoLuong.getText());
        double thanhtien = dongia * soluong;
        lbl_ThanhTien.setText(ChuyenDoi.DinhDangSo(thanhtien));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DV = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ThuePhong = new javax.swing.JTable();
        lbl_DSThue = new javax.swing.JLabel();
        lbl_DVPhong = new javax.swing.JLabel();
        lbl_Phong = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        lbl_SP2 = new javax.swing.JLabel();
        lbl_SP = new javax.swing.JLabel();
        lbl_DonGia2 = new javax.swing.JLabel();
        lbl_DG = new javax.swing.JLabel();
        lbl_DV2 = new javax.swing.JLabel();
        lbl_DV = new javax.swing.JLabel();
        lbl_SoLuong = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        btn_Tru = new javax.swing.JButton();
        btn_Cong = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        lbl_ThanhTien2 = new javax.swing.JLabel();
        lbl_ThanhTien = new javax.swing.JLabel();
        lbl_TongTIen2 = new javax.swing.JLabel();
        lbl_TongTien = new javax.swing.JLabel();
        pnl3 = new javax.swing.JPanel();
        lbl_Tim = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnl_DichVu = new javax.swing.JPanel();
        btn_xoa = new javax.swing.JButton();

        pnl.setBackground(new java.awt.Color(255, 255, 255));
        pnl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_DV.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tbl_DV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã CTDV", "Tên dịch vụ", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        tbl_DV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DV);

        pnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 395, 470, 170));

        tbl_ThuePhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt phòng", "Tên khách hàng", "Phòng", "Loại hình thuê", "Ngày thuê"
            }
        ));
        tbl_ThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ThuePhongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_ThuePhong);

        pnl.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 29, 470, 311));

        lbl_DSThue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_DSThue.setText("Danh sách thuê phòng");
        pnl.add(lbl_DSThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 6, -1, -1));

        lbl_DVPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_DVPhong.setText("Dịch vụ của phòng:");
        pnl.add(lbl_DVPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 372, -1, -1));

        lbl_Phong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnl.add(lbl_Phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 366, 82, 23));

        pnl2.setBackground(new java.awt.Color(255, 255, 255));
        pnl2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_SP2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_SP2.setText("Sán phẩm:");

        lbl_SP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_DonGia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_DonGia2.setText("Đơn giá:");

        lbl_DG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_DV2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_DV2.setText("Đơn vị:");

        lbl_DV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_SoLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_SoLuong.setText("Số lượng");

        txt_SoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_SoLuong.setText("1");
        txt_SoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoLuongActionPerformed(evt);
            }
        });
        txt_SoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SoLuongKeyReleased(evt);
            }
        });

        btn_Tru.setBackground(new java.awt.Color(255, 255, 255));
        btn_Tru.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Tru.setText("-");
        btn_Tru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Tru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TruActionPerformed(evt);
            }
        });

        btn_Cong.setBackground(new java.awt.Color(255, 255, 255));
        btn_Cong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Cong.setText("+");
        btn_Cong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Cong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CongActionPerformed(evt);
            }
        });

        btn_Them.setBackground(new java.awt.Color(51, 255, 51));
        btn_Them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Them.setText("Thêm vào hóa đơn");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        lbl_ThanhTien2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_ThanhTien2.setText("Thành tiền");

        lbl_ThanhTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lbl_ThanhTien2)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_ThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnl2Layout.createSequentialGroup()
                                    .addComponent(lbl_DV2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_DV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl2Layout.createSequentialGroup()
                                    .addComponent(lbl_SP2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl2Layout.createSequentialGroup()
                                    .addComponent(lbl_DonGia2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_DG, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl2Layout.createSequentialGroup()
                                .addComponent(lbl_SoLuong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Tru, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Cong)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btn_Them)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_SP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_DonGia2)
                    .addComponent(lbl_DG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_DV2)
                    .addComponent(lbl_DV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_SoLuong)
                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Tru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Cong))
                .addGap(18, 18, 18)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ThanhTien2)
                    .addComponent(lbl_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Them)
                .addGap(102, 102, 102))
        );

        pnl.add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 330, 300));

        lbl_TongTIen2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_TongTIen2.setText("Tổng:");
        pnl.add(lbl_TongTIen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 50, 70));

        lbl_TongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnl.add(lbl_TongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 180, 70));

        pnl3.setBackground(new java.awt.Color(0, 113, 243));
        pnl3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Tim.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_Tim.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Tim.setText("Tìm kiếm");
        pnl3.add(lbl_Tim, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 20, -1, -1));

        txt_TimKiem.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TimKiemKeyReleased(evt);
            }
        });
        pnl3.add(txt_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 11, 440, 32));

        pnl_DichVu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_DichVuLayout = new javax.swing.GroupLayout(pnl_DichVu);
        pnl_DichVu.setLayout(pnl_DichVuLayout);
        pnl_DichVuLayout.setHorizontalGroup(
            pnl_DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        pnl_DichVuLayout.setVerticalGroup(
            pnl_DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pnl_DichVu);

        pnl3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 61, 570, 512));

        pnl.add(pnl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 0, 570, 610));

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/btnxoa.png"))); // NOI18N
        btn_xoa.setBorder(null);
        btn_xoa.setBorderPainted(false);
        btn_xoa.setContentAreaFilled(false);
        btn_xoa.setDefaultCapable(false);
        btn_xoa.setEnabled(false);
        btn_xoa.setFocusPainted(false);
        btn_xoa.setFocusable(false);
        btn_xoa.setIconTextGap(0);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        pnl.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 1374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 574, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TruActionPerformed
        if (!txt_SoLuong.getText().equals("0")) {
            SoLuong(-1);
            TienTungDV();
        }

    }//GEN-LAST:event_btn_TruActionPerformed

    private void btn_CongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CongActionPerformed
        SoLuong(1);
        TienTungDV();
    }//GEN-LAST:event_btn_CongActionPerformed

    private void txt_SoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SoLuongKeyReleased
        try {
            int sl = Integer.parseInt(txt_SoLuong.getText());
            TienTungDV();
        } catch (Exception e) {
            txt_SoLuong.setText("0");
            TienTungDV();
        }
    }//GEN-LAST:event_txt_SoLuongKeyReleased

    private void tbl_ThuePhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ThuePhongMouseClicked
        if (tbl_ThuePhong.getSelectedRowCount() == 1) {
            int vitri = tbl_ThuePhong.getSelectedRow();
            MaDP0 = (tbl_ThuePhong.getValueAt(vitri, 0).toString());
            BLL.BLL_DichVu.DoDuLieuDichVu(tbl_DV, MaDP0);
            TongTienDV();
        }
    }//GEN-LAST:event_tbl_ThuePhongMouseClicked

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        DTO.DTO_CTDV ctdv = new DTO_CTDV();
        ctdv.setMaDP(Integer.parseInt(MaDP0));
        ctdv.setMaDV(MaDV);
        ctdv.setSoLuong(Integer.parseInt(txt_SoLuong.getText()));
        ctdv.setThanhTien(ChuyenDoi.ChuyenSangSo(lbl_ThanhTien.getText()));
        ctdv.setDonGia(ChuyenDoi.ChuyenSangSo(lbl_DG.getText()));
        if (BLL.BLL_CTDV.KT_Them(ctdv)) {
            DAO.DAO_CTDV.Them(ctdv);
            BLL.BLL_DichVu.DoDuLieuDichVu(tbl_DV, MaDP0);
            TongTienDV();
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        int cacdong[] = tbl_DV.getSelectedRows();
        for (int i = 0; i < cacdong.length; i++) {
            String MaCTDV = tbl_DV.getValueAt(cacdong[i], 0).toString();
            DAO.DAO_CTDV.Xoa(MaCTDV);
        }
        BLL.BLL_DichVu.DoDuLieuDichVu(tbl_DV, MaDP0);
        TongTienDV();
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void tbl_DVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DVMouseClicked
        if (tbl_DV.getSelectedRowCount() == 1) {
            btn_xoa.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_DVMouseClicked

    private void txt_SoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoLuongActionPerformed

    private void txt_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemKeyReleased
        String tukhoa = txt_TimKiem.getText();
        ResultSet rs = DAO.DAO_CungCapDichVu.TimKiem(tukhoa);

        FillDichVu(rs);
    }//GEN-LAST:event_txt_TimKiemKeyReleased
    private void SoLuong(int giatri) {
        int sl = Integer.parseInt(txt_SoLuong.getText());
        sl = sl + (giatri);
        txt_SoLuong.setText(String.valueOf(sl));
    }

    public void ChonDatPhong(String MaDP) {
        BLL.BLL_DichVu.DoDuLieuDichVu(tbl_DV, MaDP);

        for (int i = 0; i < tbl_ThuePhong.getRowCount(); i++) {

            if (String.valueOf(tbl_ThuePhong.getValueAt(i, 0)).equals(MaDP)) {
//                int vitri = tbl_ThuePhong.getSelectedRow();

                MaDP0 = (tbl_ThuePhong.getValueAt(i, 0).toString());
                BLL.BLL_DichVu.DoDuLieuDichVu(tbl_DV, MaDP0);
                TongTienDV();
                //System.out.println(tbl_ThuePhong.getValueAt(i, 0));
                tbl_ThuePhong.setRowSelectionInterval(i, i);
            } else {

            }
        }
    }

    private void TongTienDV() {
        double TongTienDichVu = 0;
        for (int i = 0; i < tbl_DV.getRowCount(); i++) {
            TongTienDichVu = TongTienDichVu + ChuyenDoi.ChuyenSangSo(tbl_DV.getValueAt(i, 4).toString());
        }
        lbl_TongTien.setText(ChuyenDoi.DinhDangSo(TongTienDichVu));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cong;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Tru;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_DG;
    private javax.swing.JLabel lbl_DSThue;
    private javax.swing.JLabel lbl_DV;
    private javax.swing.JLabel lbl_DV2;
    private javax.swing.JLabel lbl_DVPhong;
    private javax.swing.JLabel lbl_DonGia2;
    private javax.swing.JLabel lbl_Phong;
    private javax.swing.JLabel lbl_SP;
    private javax.swing.JLabel lbl_SP2;
    private javax.swing.JLabel lbl_SoLuong;
    private javax.swing.JLabel lbl_ThanhTien;
    private javax.swing.JLabel lbl_ThanhTien2;
    private javax.swing.JLabel lbl_Tim;
    private javax.swing.JLabel lbl_TongTIen2;
    private javax.swing.JLabel lbl_TongTien;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl_DichVu;
    public javax.swing.JTable tbl_DV;
    public javax.swing.JTable tbl_ThuePhong;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
