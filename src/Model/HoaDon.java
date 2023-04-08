package Model;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.Objects;

import java.util.Scanner;

import java.io.Serializable;


public class HoaDon implements Serializable{

    private String ID;
    private String tenKH;
    private String diaChi;
    private String ngayTao;
    private String doiTuong;
    private int oldIndex;
    private int newIndex;
    private int price;
    private int totalKW;

    public HoaDon() {

    }

    public HoaDon(String ID, String tenKH, String DiaChi, String doiTuong, String ngayTao, int oldIndex, int newIndex) {
        this.ID = ID;
        this.tenKH = tenKH;
        this.diaChi = DiaChi;
        this.ngayTao = ngayTao;
        this.doiTuong = doiTuong;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.diaChi = DiaChi;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    public int getKW() {
        return (this.newIndex - this.oldIndex);
    }

    public int normHasBeenUsed() {
        if (this.doiTuong.equals("NN")) {
            return 500;
        } else if (this.doiTuong.equals("SX hoặc KD")) {
            return 400;
        } else {
            return 300;
        }
    }

    public long payment() {
        int limitUp = 1100;
        int limitDown = 550;
        if (getKW() <= this.normHasBeenUsed()) {
            return (limitDown * getKW());
        } else {
            return (limitUp * getKW());
        }
    }

    @Override
    public String toString() {
        return "HoaDon{" + "ID=" + ID + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", ngayTao=" + ngayTao + ", doiTuong=" + doiTuong + ", oldIndex=" + oldIndex + ", newIndex=" + newIndex + ", price=" + price + ", totalKW=" + totalKW + '}';
    }
    
    
    
}

