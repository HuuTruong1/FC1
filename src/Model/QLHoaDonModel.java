package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author HuuTruong
 */
public class QLHoaDonModel {

    public ArrayList<HoaDon> danhSachHoaDon = new ArrayList<HoaDon>();
    Scanner sc = new Scanner(System.in);

    public QLHoaDonModel() {
        this.danhSachHoaDon = new ArrayList<>();
    }

    public QLHoaDonModel(ArrayList<HoaDon> BillList) {
        this.danhSachHoaDon = BillList;
    }

    public void setBillList(ArrayList<HoaDon> BillList) {
        this.danhSachHoaDon = BillList;
    }

    public void insert(HoaDon bill) {
        this.danhSachHoaDon.add(bill);
    }

    public void delete(HoaDon bill) {
        this.danhSachHoaDon.remove(bill);
    }

    public ArrayList<HoaDon> getBillList() {
        return danhSachHoaDon;
    }

    public void update(HoaDon bill) {
        this.danhSachHoaDon.remove(bill);
        this.danhSachHoaDon.add(bill);
    }

    public boolean kiemTraTonTai(HoaDon hoaDon) {
        for (HoaDon HD : danhSachHoaDon) {
            if (HD.getID().equals(hoaDon.getID())) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraDanhSachCoTonTai() {
        if (danhSachHoaDon.size() == 0) {
            return true;
        }
        return false;
    }

    public HoaDon getLargestPayment() {
        HoaDon hoaDonLN = new HoaDon();
        long max = 0;
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (hoaDon.payment() > max) {
                max = hoaDon.payment();
                hoaDonLN = hoaDon;
            }
        }
        return hoaDonLN;
    }

    public long getTotalByType(String type) {
        long res = 0;
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (hoaDon.getDoiTuong().equals(type)) {
                res += hoaDon.payment();
            }
        }
        return res;
    }

    public long getToTal() {
        long res = 0;
        for (HoaDon hoaDon : danhSachHoaDon) {
            res += hoaDon.payment();
        }
        return res;
    }

    public int getKW() {
        int res = 0;
        for (HoaDon hoaDon : danhSachHoaDon) {
            res += hoaDon.getKW();
        }
        return res;
    }

    public void sortListByName() {
        try {
            Collections.sort(danhSachHoaDon, new Comparator<HoaDon>()
            {
                @Override
                public int compare(HoaDon hoaDon1, HoaDon hoaDon2) {
                    return hoaDon1.getTenKH().compareTo(hoaDon2.getTenKH());
                }
                
            }
            );
        } catch (Exception e) {
        }
    }
    
    public void sortListByPayment() {
        try {
            Collections.sort(danhSachHoaDon, new Comparator<HoaDon>()
            {
                @Override
                public int compare(HoaDon hoaDon1, HoaDon hoaDon2) {
                    return (int) (hoaDon1.payment() - hoaDon2.payment());
                }
                
            }
            );
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        QLHoaDonModel ql = new QLHoaDonModel();
//        HoaDon a = new HoaDon("1", "Hữu", "QN", "Khác", "1/2023", 134, 1550);
//        HoaDon b = new HoaDon("9", "Hữu", "QN", "Khác", "1/2023", 500, 1550);
//        HoaDon c = new HoaDon("7", "Hữu", "QN", "Khác", "1/2023", 13, 1550);
//        HoaDon d = new HoaDon("2", "Hữu", "QN", "Khác", "1/2023", 1334, 1550);
//        HoaDon e = new HoaDon("8", "Hữu", "QN", "Khác", "1/2023", 133, 1550);
//        ql.insert(a);
//        ql.insert(b);
//        ql.insert(c);
//        ql.insert(d);
//        ql.insert(e);
//        System.out.println("Truoc khi sap xep: ");
//        for (HoaDon hoaDon : ql.danhSachHoaDon) {
//            System.out.println(hoaDon.toString());
//        }
//
//        System.out.println("Sau khi sap xep: ");
//        ql.sortListByName();
//        for (HoaDon hoaDon : ql.danhSachHoaDon) {
//            System.out.println(hoaDon.toString());
//        }
//    }
}
