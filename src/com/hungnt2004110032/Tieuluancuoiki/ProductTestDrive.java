package com.hungnt2004110032.Tieuluancuoiki;

import java.util.Scanner;

import java.text.ParseException;

public class ProductTestDrive {
    
    static Scanner bienNhap = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        int luaChon;

        ChucNang chucNang = new ChucNang();

        chucNang.khoHangHoaCoSan(); // gọi phương thức hàng hóa có sẵn từ đối tượng Chức Năng

        do{
            System.out.println("================MENU=============");

            System.out.println("1> Nhập thêm, xóa hoặc sửa hàng hóa");
            System.out.println("2> Xuất danh sách hàng hóa");
            System.out.println("3> Tìm kiếm hàng hóa");
            System.out.println("4> Sắp xếp hàng hóa");
            System.out.println("5> Thống kê hàng hóa");
            System.out.println("6> Thoát chương trình");
            System.out.println("---------------------------------");

            System.out.print("Chọn chức năng: ");
            luaChon = bienNhap.nextInt();

            switch(luaChon){
                case 1:
                    chucNang.nhapXoaSua(); // Nhập thêm hàng hóa
                    break;
                case 2:
                    chucNang.inThongTinHangHoa(); // Xuất danh sách hàng hóa
                    break;
                case 3: 
                    chucNang.timKiem(); // Tìm kiếm hàng hóa
                    break;
                case 4:
                    chucNang.sapXepHangHoa();   // Sắp xếp hàng hóa
                    break;
                case 5:
                    chucNang.thongKe(); // Thống kê hàng hóa
                    break;
                case 6:
                     System.out.println("Thoát chương trình thành công !");
                     System.exit(0);
                     break;
                default:
                     System.out.println("nhập không đúng !");
            }
            System.out.print("quay về menu (1:yes, 0:no): ");
            bienNhap.nextLine();
        }while(bienNhap.nextInt() == 1);

    }

    
}

