package com.hungnt2004110032.Tieuluancuoiki;

import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product{

    String loai, tenHangHoa, ngayNhapKho;
    int maHang, gia, soLuong;
    
    Scanner nhap = new Scanner(System.in);

    public Product(){}

    public Product(String l, String t, String n, int ma, int g, int sl){
        loai = l;
        tenHangHoa = t;
        ngayNhapKho = n;
        maHang = ma;
        gia = g;
        soLuong = sl;
    }
    
    public void inThongTin(){
        
        System.out.println("Tên hàng hóa: " + tenHangHoa);
        System.out.println("Loại: " + loai);
        System.out.println("Ngày nhập kho: " + ngayNhapKho);
        System.out.println("Mã hàng: " + maHang);
        System.out.println("Giá nhập: " + gia + " đồng");
        System.out.println("Số lượng tồn kho: " + soLuong);
        System.out.println("======================================");
    }

    void nhapThongTin(){

        System.out.print("Nhập tên hàng hóa: ");
        tenHangHoa = nhap.nextLine();
        System.out.print("Nhập loại: ");
        loai = nhap.nextLine();
        System.out.print("Nhập ngày: ");
        ngayNhapKho = nhap.nextLine();
        System.out.print("Nhập mã hàng hóa: ");
        maHang = nhap.nextInt();
        System.out.print("Nhập giá: ");
        gia = nhap.nextInt();
        System.out.print("Nhập số lượng: ");
        nhap.nextLine();
        soLuong = nhap.nextInt();
        System.out.println("======================================");
    }

    public static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        //ngày việt nam
        Date date;
        /**
         * dd: ngày
         * mm: tháng
         * yyyy: năm
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }

}

