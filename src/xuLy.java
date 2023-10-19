import java.util.ArrayList;
import java.util.Scanner;

public class xuLy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*
         * Xử lý đối với 1 sinh viên
         * QuanLySV sv1 = new QuanLySV();
         * sv1.nhap(scan);
         * sv1.tinhDTB();
         * sv1.xepLoai();
         * sv1.getDtb();
         * sv1.xepLoai();
         * sv1.xuat();
         */
        // Xử lý đối với nhiều sinh viên
        // DanhSachSV ds = new DanhSachSV();
        TruongHoc truong = new TruongHoc();
        truong.nhap();
        doMenu(truong);
    }

    private static void inMenu() {
        System.out.println("Vui long chon thuc hien: ");
        System.out.println("1.Nhap them sinh vien");
        System.out.println("2.Xuat danh sach sinh vien");
        System.out.println("3.Xuat danh sach sinh vien co DTB cao nhat");
        System.out.println("4.Xuat danh sach sinh vien co Xep loai: Kem");
        System.out.println("5.Tim kiem sinh vien theo ten ");
        System.out.println("6.Tim kiem sinh vien theo ma SV ");
        System.out.println("7.Xoa sinh vien theo ma SV ");

        System.out.println("0.Thoat!!!");
    }

    private static void doMenu(TruongHoc truong) {
        boolean flag = true;

        Scanner scan = new Scanner(System.in);
        do {
            inMenu();
            System.out.print("Vui long nhap :");
            int chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    QuanLySV sv = new QuanLySV();
                    sv.nhap(scan);
                    // ds.themSV(sv);
                    truong.themSinhVien(sv);
                    break;
                case 2:
                    truong.tinhDTB();
                    truong.xepLoai();
                    // truong.xuat();
                    truong.xuatTheoFormat(truong.getDssvToanTruong().getListSV());
                    break;
                case 3:
                    ArrayList<QuanLySV> listDTBMax = truong.timDSSVCoDTBCaoNhat();
                    // for (QuanLySV Sv : listDTBMax) {
                    // Sv.xuat();
                    // }
                    // truong.xuatHelper(listDTBMax);
                    truong.xuatTheoFormat(listDTBMax);
                    break;
                case 4:
                    ArrayList<QuanLySV> listYeu = truong.timDSSVXepLoaiyeu();
                    // for(QuanLySV Sv:listYeu){
                    // Sv.xuat();
                    // }
                    // truong.xuatHelper(listYeu);
                    truong.xuatTheoFormat(listYeu);
                    break;
                case 5:
                    System.out.print("Vui long nhap ten :");
                    String name = scan.nextLine();
                    ArrayList<QuanLySV> listName = truong.timDDSVTheoTen(name);
                    // for(QuanLySV Sv:listYeu){
                    // Sv.xuat();
                    // }
                    // truong.xuatHelper(listName);
                    truong.xuatTheoFormat(listName);
                    break;
                case 6:
                    System.out.print("Vui long nhap ID SV:");
                    String id = scan.nextLine();
                    QuanLySV SV = truong.timSVTheoMa(id);
                    if (SV != null)
                        SV.xuat();
                    else
                        System.out.println("Khong tim thay");
                    break;
                case 7:
                    System.out.print("Vui long nhap ID SV:");
                    String id1 = scan.nextLine();
                    boolean deleted = truong.xoaSvTheoMa(id1);
                    if (deleted == true)
                        System.out.println("Xoa thanh cong!!!");
                    else
                        System.out.println("Chua xoa duoc!!!");
                    break;

            }
        } while (flag);
    }

}