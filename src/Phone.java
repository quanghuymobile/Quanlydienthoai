public class Phone {
    public String ten;
    public String hangSanXuat;
    public double gia;

    public Phone(String ten, String hangSanXuat, double gia) {
        this.ten = ten;
        this.hangSanXuat = hangSanXuat;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public double getGia() {
        return gia;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Tên: " + ten + " | Hãng: " + hangSanXuat + " | Giá: " + String.format("%,.0f", gia) + " VND";
    }
}