import java.util.Scanner;
// Edit by github nef hehehe
public class QuanLySV {
    // 1. Các thuộc tính
    private float diemToan;
    private float diemLy;
    private float diemHoa;
    private String tenSV;
    private String maSV;
    private float dtb;
    private String loai;

    // 2. Các phương thức get, set
    public String getTenSV() {
        return this.tenSV;
    }

    public void setTenSV(String name) {
        this.tenSV = name;
    }

    public String getMaSV() {
        return this.maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public float getDiemToan() {
        return this.diemToan;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }

    public float getDiemLy() {
        return this.diemLy;
    }

    public void setDiemLy(float diemLy) {
        this.diemLy = diemLy;
    }

    public float getDiemHoa() {
        return this.diemHoa;
    }

    public void setDiemHoa(float diemHoa) {
        this.diemHoa = diemHoa;
    }

    public float getDtb() {
        return this.dtb;
    }

    public String getloai() {
        return this.loai;
    }

    // 3. Các phương thức khởi tạo
    public QuanLySV() {

    }

    public QuanLySV(String ten, String i, float toan, float ly, float hoa) {
        this.tenSV = ten;
        this.maSV = i;
        this.diemHoa = hoa;
        this.diemLy = ly;
        this.diemToan = toan;

    }

    // 4. Các phương thức nhập, xuất
    public void nhap(Scanner scan) {
        System.out.print("Nhap Ho va Ten SV: ");
        this.tenSV = scan.nextLine();

        System.out.print("Nhap ma SV: ");
        this.maSV = scan.nextLine();

        System.out.print("Nhap diem Toan: ");
        this.diemToan = Float.parseFloat(scan.nextLine());

        System.out.print("Nhap diem Ly: ");
        this.diemLy = Float.parseFloat(scan.nextLine());

        System.out.print("Nhap diem Hoa: ");
        this.diemHoa = Float.parseFloat(scan.nextLine());

    }

    public void xuat() {
        System.out.println(
                "MaSV:\t" + this.maSV + "\t TenSV:\t" + this.tenSV + "\tToan:\t" + this.diemToan + "\tLy:\t"
                        + this.diemLy + "\t Hoa:\t" + this.diemHoa + "\tDTB: " + this.dtb + "\tXep loai: " + this.loai);
    }

    // 5. Các phương thức xử lý nghiệp vụ liên quan
    public void tinhDTB() {
        this.dtb = (diemHoa + diemLy + diemToan) / 3;
    }

    public void xepLoai() {
        if (this.dtb >= 9)
            this.loai = "Xuat sac";
        else if (this.dtb >= 8 && this.dtb < 9)
            this.loai = "Gioi";
        else if (this.dtb >= 7 && this.dtb < 8)
            this.loai = "Kha";
        else if (this.dtb >= 6 && this.dtb < 7)
            this.loai = "TB";
        else if (this.dtb >= 5 && this.dtb < 6)
            this.loai = "Yeu";
        else
            this.loai = "Kem";
    }

    private String formatNumCellS(String num) {
        String paddLeft = "%5s";
        String paddRight = "%-8s";
        return String.format(paddLeft, " ") + String.format(paddRight, num) + "|";
    }

    private String formatNumCellN(Number num) {
        String paddLeft = "%5s";
        String paddRight = "%-8s";
        return String.format(paddLeft, " ") + String.format(paddRight, num) + "|";
    }

    private String formatTextCell(String text) {
        String paddLeft = "%-15s"; // CHiều dài 15 kí tự
        return String.format(paddLeft, " " + text);
    }

    public void xuatRowFormat() {
        String text;
        text = formatNumCellS(this.maSV);
        text += formatTextCell(this.tenSV) + "|";
        text += formatNumCellN(this.diemToan);
        text += formatNumCellN(this.diemLy);
        text += formatNumCellN(this.diemHoa);
        double diemTB = Math.round(this.dtb * 100.0) / 100.0; // Làm tròn đến 2 chữ số thập phân
        text += formatNumCellN(diemTB);
        text+=formatTextCell(this.loai)+"||";
        System.out.println(text);
    }

}
