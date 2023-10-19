import java.util.ArrayList;

public class TruongHoc {
    // 1.Attributes
    private DanhSachSV dssvToanTruong;
    // 2.Get,Set methods

    public DanhSachSV getDssvToanTruong() {
        return dssvToanTruong;
    }

    public void setDssvToanTruong() {
        this.dssvToanTruong = dssvToanTruong;
    }

    // 3.Constructors
    public TruongHoc() {
        this.dssvToanTruong = new DanhSachSV();
    }

    // 4.Input, Output
    public void nhap() {
        QuanLySV sv = new QuanLySV("Lan", "1", 9.2f, 9, 9);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Hung", "2", 4.2f, 3, 2);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Vu", "3", 7.2f, 7, 7);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Huy", "4", 2.2f, 4, 3);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Toan", "5", 9.2f, 9, 9);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Hau", "6", 6.2f, 7, 8);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Lan", "7", 9.2f, 4, 9);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Tu", "8", 9.2f, 10, 10);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Trung", "9", 9.2f, 10, 10);
        this.dssvToanTruong.themSV(sv);

        sv = new QuanLySV("Vu", "10", 9.2f, 8, 6);
        this.dssvToanTruong.themSV(sv);
    }

    public void xuat() {
        this.dssvToanTruong.xuat();
    }

    // 5.Business methods
    public void tinhDTB() {
        this.dssvToanTruong.tinhDTB();
    }

    public void xepLoai() {
        this.dssvToanTruong.xepLoai();
    }

    public ArrayList<QuanLySV> timDSSVCoDTBCaoNhat() {
        return this.dssvToanTruong.timDSSVCoDTBCaoNhat();
    }

    public ArrayList<QuanLySV> timDSSVXepLoaiyeu() {
        return this.dssvToanTruong.timDSSVXepLoaiYeu();
    }

    public ArrayList<QuanLySV> timDDSVTheoTen(String name) {
        return this.dssvToanTruong.timDSSVTheoTen(name);
    }

    public QuanLySV timSVTheoMa(String id) {
        return dssvToanTruong.timSVTheoMa(id);
    }

    public boolean xoaSvTheoMa(String id) {
        return this.dssvToanTruong.xoaSvTheoMa(id);
    }

    public void themSinhVien(QuanLySV sv) {
        this.dssvToanTruong.themSV(sv);
    }

    public void xuatHelper(ArrayList<QuanLySV> list) {
        for (QuanLySV sv : list) {
            sv.xuat();
        }
    }

    private void xuatLine() {
        System.out.println(
                "======================================================================================================================");

    }

    private String formatCell(String paddLeft, String title, String paddRight) {
        return String.format(paddLeft, " ") + title + String.format(paddRight, " ");

    }

    private void xuatRowHeader() {
        String paddString1 = "%3s";
        String paddString2 = "%4s";
        String paddString3 = "%5s";
        String paddString4 = "%6s";

        xuatLine();
        String text;
        text = "||" + formatCell(paddString1, "STT", paddString1)+"|";
        text += formatCell(paddString2, "Ma SV", paddString2)+"|";
        text += formatCell(paddString3, "Ten SV", paddString3)+"|";
        text += formatCell(paddString3, "Toan", paddString3)+"|";
        text += formatCell(paddString4, "Ly", paddString4)+"|";
        text += formatCell(paddString3, "Hoa", paddString3)+"|";
        text += formatCell(paddString3, "DTB", paddString1)+"|";
        text += formatCell(paddString2, "Xep loai", paddString1)+"||";
        System.out.println(text);
        xuatLine();
    }

    private void xuatCellThuTu(int i){
        String paddLeft="%3s";
        String paddRight="%-6s";
        String text="||"+String.format(paddLeft, " ")+String.format(paddRight, ""+i)+"|";
        System.out.print(text);
    }

    public void xuatTheoFormat(ArrayList<QuanLySV> list){
        xuatRowHeader();
        int i=1;
        for(QuanLySV sv: list){
            xuatCellThuTu(i);
            sv.xuatRowFormat();
            i++;
        }
        xuatLine();
    }

}
