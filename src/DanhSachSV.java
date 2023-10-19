import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSV {
    // 1. Attributes
    private ArrayList<QuanLySV> listSV;
    // 2. Get, Set methods

    public ArrayList<QuanLySV> getListSV() {
        return listSV;
    }

    public void setListSV(ArrayList<QuanLySV> listSV) {
        this.listSV = listSV;
    }

    // 3. Constructors
    public DanhSachSV() {
        thietLapDefault();
    }

    // Hàm này dùng để khởi động các list và các giá trị mặc định cho lớp
    private void thietLapDefault() {
        this.listSV = new ArrayList<QuanLySV>();

    }

    // 4. Input, Output
    public void nhap(Scanner scan) {
        for (QuanLySV sv : this.listSV)
            sv.nhap(scan);
    }

    public void xuat() {
        for (QuanLySV sv : this.listSV)
            sv.xuat();
    }

    public void themSV(QuanLySV sv) {
        this.listSV.add(sv);
    }

    // 5. Business methods
    public void tinhDTB() {
        for (QuanLySV sv : this.listSV) {
            sv.tinhDTB();
        }
    }

    public void xepLoai() {
        for (QuanLySV sv : this.listSV)
            sv.xepLoai();
    }

    public ArrayList<QuanLySV> timDSSVCoDTBCaoNhat() {

        ArrayList<QuanLySV> list = new ArrayList<QuanLySV>();
        if (this.listSV.size() > 0) {

            QuanLySV svMax = this.listSV.get(0);
            int pos = 0;
            for (int i = 0; i < this.listSV.size(); i++) {
                QuanLySV svCurrent = this.listSV.get(i);
                if (svCurrent.getDtb() > svMax.getDtb()) {
                    svMax = svCurrent;
                    pos = i;
                }
            }
            // Thêm sv Max vào list
            list.add(svMax);
            for (int i = pos + 1; i < this.listSV.size(); i++) {
                QuanLySV SvCurrent = this.listSV.get(i);
                if (SvCurrent.getDtb() == svMax.getDtb()) {
                    list.add(SvCurrent);
                }
            }
        }
        return list;
    }

    public ArrayList<QuanLySV> timDSSVXepLoaiYeu() {
        ArrayList<QuanLySV> list = new ArrayList<QuanLySV>();
        if (this.listSV.size() > 0) {
            for (QuanLySV svCurrent : this.listSV) {
                if (svCurrent.getloai() == "Kem")
                    list.add(svCurrent);
            }
        }
        return list;
    }

    public ArrayList<QuanLySV> timDSSVTheoTen(String name) {
        ArrayList<QuanLySV> list = new ArrayList<QuanLySV>();
        if (this.listSV.size() > 0) {
            for (QuanLySV svCurrent : this.listSV) {
                if (svCurrent.getTenSV().equalsIgnoreCase(name)) {
                    list.add(svCurrent);
                }
            }
        }
        return list;
    }

    public QuanLySV timSVTheoMa(String id) {
        // QuanLySV sv=new QuanLySV();
        QuanLySV sv = null;
        if (this.listSV.size() > 0) {

            for (QuanLySV svCurrent : this.listSV) {
                if (svCurrent.getMaSV().equalsIgnoreCase(id)) {
                    sv = svCurrent;
                    break;
                }
            }
        }
        return sv;
    }

    public boolean xoaSvTheoMa(String id) {
        boolean deleted = false;
        if(this.listSV.size()>0){

            for(QuanLySV sv:this.listSV){
                if(sv.getMaSV().equalsIgnoreCase(id))
                {
                    this.listSV.remove(sv);
                    deleted=true;
                    break;
                }
            }
        }
        return deleted;

    }

}
