/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTO_HoaDon;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ThongKeHD_serviceImpl implements  ThongKeHD_service{
    private ThongKeHD_Dao thonkedao=null;
    public ThongKeHD_serviceImpl(){
        this.thonkedao = new ThongKeHD_DaoImpl();
    }
    @Override
    public List<DTO_HoaDon> getlistbyhoadon() {
       return thonkedao.getlistbyhoaddon();
    }
    
}
