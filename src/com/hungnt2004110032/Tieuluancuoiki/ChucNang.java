package com.hungnt2004110032.Tieuluancuoiki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ChucNang {
    // Chức năng chương trình
    ArrayList<Product> khoHangHoa = new ArrayList<>();
    Scanner bienNhap = new Scanner(System.in);
    
    int luaChon;

    
    void inThongTinHangHoa(){
        
        System.out.println("=====DANH SÁCH HÀNG HÓA TRONG KHO=====");
            for(Product product : khoHangHoa){
                product.inThongTin();
            }
    }

    void nhapXoaSua(){
        
        System.out.println("1> Nhập thêm hàng hóa");
        System.out.println("2> Nhập mã hàng hóa muốn xóa");
        System.out.println("3> Nhập mã hàng hóa muốn sửa");
        System.out.println("Chọn chức năng: ");
        luaChon = bienNhap.nextInt();

        switch(luaChon){
            case 1:nhap();
                break;
            case 2:timVaXoa();
                break;
            case 3:timVaSua();
                break;
        }
    }

    void nhap(){
        do{
        System.out.println("- Nhập thông tin của hàng hóa:");
        Product product = new Product();
        product.nhapThongTin();
        khoHangHoa.add(product);
        System.out.print("- Bạn có muốn nhập thêm không (1:yes, 0:no): ");
        luaChon = bienNhap.nextInt();
        } while(luaChon == 1);
    }

    void timVaXoa(){
        System.out.print("Nhập mã hàng hóa muốn xóa: ");
        bienNhap.nextLine();
        int ma = bienNhap.nextInt();
        for(Product product : khoHangHoa){
           if(product.maHang == ma){
               khoHangHoa.remove(product);
               System.out.println("Xóa thành công");
               break;
           }
        }
        
    }
    void timVaSua(){

        System.out.print("Nhập mã hàng hóa cần tìm: ");
        int ma = bienNhap.nextInt();
        System.out.println("Nhập thông tin để sửa mã hàng hóa: ");
        bienNhap.nextLine();
        int edit = bienNhap.nextInt();
        for(int i = 0; i <= khoHangHoa.size(); i++){
            if(khoHangHoa.get(i).maHang == ma){
                khoHangHoa.get(i).maHang = edit;
                System.out.println("Sửa thành công");
                break;
            }
        }
    }

    void timKiem() throws ParseException {
        
        System.out.println("1> Tìm kiếm theo loại");
        System.out.println("2> Tìm kiếm theo giá");
        System.out.println("3> Tìm kiếm từ ngày đến ngày");
        System.out.println("Chọn chức năng: ");
        luaChon = bienNhap.nextInt();

        switch(luaChon){
            case 1:timKiemTheoLoai();
                break;
            case 2:timKiemTheoGia();
                break;
            case 3:timKiemTheoNgay();
                break;
        }

    }
    void timKiemTheoLoai(){
        System.out.println("Nhập loại hàng hóa cần tìm: ");
        bienNhap.nextLine();
        String loaiHangHoa = bienNhap.nextLine();

        System.out.println("================Đã tìm thấy hàng hóa================");
        for(Product product : khoHangHoa){
            if(product.loai.equalsIgnoreCase(loaiHangHoa)){
                product.inThongTin();
            }
        }
        System.out.println("Nhập 2 lần số 1 để quay lại Menu");
    }

    void timKiemTheoGia(){
        System.out.print("Nhập giá hàng hóa cần tìm: ");
        bienNhap.nextLine();
        int giaHangHoa = bienNhap.nextInt();

        System.out.println("================Đã tìm thấy hàng hóa================");
        for(Product product : khoHangHoa){
            if(product.gia == giaHangHoa){
                product.inThongTin();
            }
        }
    }

    void timKiemTheoNgay() throws ParseException{
        System.out.println("Nhập ngày/tháng/năm hàng hóa cần tìm (VD: 02/09/2021) ");
        System.out.print("Tìm kiếm từ ngày: ");
        bienNhap.nextLine();
        String ngay1 = bienNhap.nextLine();

        System.out.print("đến ngày: ");
        String ngay2 = bienNhap.nextLine();

        Date ngay1Java = chuyenChuoiSangNgay(ngay1);
        Date ngay2Java = chuyenChuoiSangNgay(ngay2);

        System.out.println("============Đã tìm thấy hàng hóa============");
        for(Product product : khoHangHoa){
            Date ngayJava = chuyenChuoiSangNgay(product.ngayNhapKho);
            if(ngayJava.after(ngay1Java) && ngayJava.before(ngay2Java)){
                product.inThongTin();
            }
        }
        System.out.println("Nhập 2 lần số 1 để quay lại Menu");
    }

    void sapXepHangHoa() throws ParseException{

        System.out.println("1> Sắp xếp tăng dần theo giá");
        System.out.println("2> Sắp xếp giảm dần theo giá");
        System.out.println("3> Sắp xếp tăng dần theo ngày");
        System.out.println("4> Sắp xếp giảm dần theo ngày");
        System.out.println("Chọn chức năng: ");
        luaChon = bienNhap.nextInt();

        switch(luaChon){
            case 1:sapXepTangDanTheoGia();
                break;
            case 2:sapXepGiamDanTheoGia();
                break;
            case 3:sapXepTangDanTheoNgay();
                break;
            case 4:sapXepGiamDanTheoNgay();
                break;
        }
    }
    
    void sapXepTangDanTheoGia(){
        
        Comparator<Product> comp;
        comp = new Comparator<Product>(){

            public int compare(Product o1, Product o2) {
                return Double.compare(o1.gia , o2.gia);
            }
            
        };

        Collections.sort(khoHangHoa, comp);
        System.out.println("==========Danh sách sau khi sắp xếp==========");
        inThongTinHangHoa();
    }

    void sapXepGiamDanTheoGia(){
        Comparator<Product> comp;
        comp = new Comparator<Product>(){

            public int compare(Product o1, Product o2) {
                return Double.compare(o1.gia, o2.gia);
            }
            
        };

        Collections.sort(khoHangHoa, comp);
        Collections.reverse(khoHangHoa);;
        System.out.println("==========Danh sách sau khi sắp xếp==========");
        inThongTinHangHoa();
    }

    void sapXepTangDanTheoNgay() throws ParseException{
        Collections.sort(khoHangHoa, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.ngayNhapKho.compareTo(o2.ngayNhapKho);
            }
        });
        System.out.println("==========Danh sách sau khi sắp xếp==========");
        inThongTinHangHoa();
    }

    void sapXepGiamDanTheoNgay() throws ParseException{
        Collections.sort(khoHangHoa, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.ngayNhapKho.compareTo(o2.ngayNhapKho);
            }
        });
        Collections.reverse(khoHangHoa);
        System.out.println("==========Danh sách sau khi sắp xếp==========");
        inThongTinHangHoa();
    }

    void thongKe(){

        int sum = 0;
        System.out.println("1> Tổng số lượng hàng hóa");
        System.out.println("2> Tổng giá trị nhập kho ");
        System.out.println("3> Số lượng từng loại hàng ");
        System.out.println("Chọn chức năng: ");
        luaChon = bienNhap.nextInt();

        System.out.println("==========Thống kê hàng hóa==========");
        if(luaChon == 1){

            int count = 0;
            for(int i = 0; i < khoHangHoa.size(); i++){
                count++;
            }
            System.out.println("Tổng số lượng hàng hóa: " + count + " hàng hóa");

        }else if(luaChon == 2){

            for(int i = 0; i < khoHangHoa.size(); i++){
                sum = sum + khoHangHoa.get(i).gia;
            }
            System.out.println("Tổng giá trị nhập kho: " + sum + " đồng");
        }else if(luaChon == 3){
            System.out.println("Số lượng từng loại hàng hóa: ");
            System.out.println("+ Số lượng Book: " + soLuongLoaiHangHoa("Book"));
            System.out.println("+ Số lượng Laptop: " + soLuongLoaiHangHoa("Laptop"));
            System.out.println("+ Số lượng Machine: " + soLuongLoaiHangHoa("Machine")); 
            System.out.println("+ Số lượng Phone: " + soLuongLoaiHangHoa("Phone"));
        }else{
            System.out.println("Nhập không đúng !");
        }
        
    }

    int soLuongLoaiHangHoa(String loai){
        int count = 0;
        for (Product product : khoHangHoa) {
            if(product.loai.equalsIgnoreCase(loai)){
                count++;
            }
        }
        return count;
    }

    void khoHangHoaCoSan(){

        // Kho hàng hóa có sẵn 20 dữ liệu
        khoHangHoa.add(new Product("Book", "200 bài code thiếu nhi", "21/07/2020", 1, 100000, 120));
        khoHangHoa.add(new Product("Book", "Bộ sách giáo khoa lớp 9", "16/07/2020", 2, 150000, 210));
        khoHangHoa.add(new Product("Book", "Bộ sách giáo khoa lớp 10", "20/08/2020", 3, 160000, 180));
        khoHangHoa.add(new Product("Book", "Bộ sách giáo khoa lớp 11", "26/09/2021", 4, 170000, 190));
        khoHangHoa.add(new Product("Book", "Bộ sách giáo khoa lớp 12", "10/05/2021", 5, 180000, 200));
        khoHangHoa.add(new Product("Laptop", "Laptop Dell", "21/02/2021", 6, 15000000, 50));
        khoHangHoa.add(new Product("Laptop", "Laptop Asus", "22/04/2021", 7, 14000000, 70));
        khoHangHoa.add(new Product("Laptop", "Laptop MSI", "12/03/2021", 8, 14500000, 60));
        khoHangHoa.add(new Product("Laptop", "Laptop Lenovo", "25/01/2021", 9, 13000000, 55));
        khoHangHoa.add(new Product("Laptop", "Laptop HP", "25/06/2021", 10, 14200000, 75));
        khoHangHoa.add(new Product("Machine", "Máy giặt", "11/07/2020", 11, 10000000, 100));
        khoHangHoa.add(new Product("Machine", "Máy lạnh", "01/07/2020", 12, 7000000, 120));
        khoHangHoa.add(new Product("Machine", "Tủ lạnh", "06/08/2020", 13, 7000000, 120));
        khoHangHoa.add(new Product("Machine", "Tivi Sony", "22/06/2020", 14, 11000000, 150));
        khoHangHoa.add(new Product("Machine", "Tivi Samsung", "29/08/2020", 15, 12000000, 180));
        khoHangHoa.add(new Product("Phone", "Samsung Galaxy A72", "05/04/2021", 16, 9980000, 500));
        khoHangHoa.add(new Product("Phone", "Xiaomi Redmi Note 10", "08/04/2021", 17, 4280000, 1000));
        khoHangHoa.add(new Product("Phone", "Iphone 13", "08/11/2021", 18, 24500000, 700));
        khoHangHoa.add(new Product("Phone", "Oppo A95", "10/07/2021", 19, 4800000, 800));
        khoHangHoa.add(new Product("Phone", "ROG phone 5", "21/11/2021", 20, 19000000, 600));
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
