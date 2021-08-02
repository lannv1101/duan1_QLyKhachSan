/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class thongbao {
    public static void thongbao(String noidung){
        JOptionPane.showMessageDialog(new JOptionPane(),noidung, "Thông Báo",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void loi(String noidung){
        JOptionPane.showMessageDialog(new JOptionPane(),noidung, "Lỗi",JOptionPane.ERROR_MESSAGE);
    }
    public static void ktlai(String noidung){
        JOptionPane.showMessageDialog(new JOptionPane(),noidung, "Kiểm Tra Lại",JOptionPane.WARNING_MESSAGE);
    }
}
