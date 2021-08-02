/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTO_HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ThongKeHD_DaoImpl implements ThongKeHD_Dao{

    @Override
    public List<DTO_HoaDon> getlistbyhoaddon() {
       Connection cons = connection.conn;
        String sql = "SELECT MaHoaDon, ThanhTien From HoaDon";
        List<DTO_HoaDon> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DTO_HoaDon hd = new DTO_HoaDon();
                hd.setMaDP(rs.getInt("MaHoaDon"));
                hd.setThanhTien(rs.getDouble("ThanhTien"));
                list.add(hd);
             }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    }
    

