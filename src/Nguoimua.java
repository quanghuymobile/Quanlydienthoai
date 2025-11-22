public class Nguoimua {

    // Thuộc tính (Attributes)
    public int IDNguoimua;
    public String Ten;
    public String SDT;

    // 1. Constructor không tham số (Default Constructor)
    public Nguoimua() {
    }

    // 2. Constructor có tham số (Dùng khi tạo đối tượng)
    public Nguoimua(String Ten, String SDT) {
        // KHÔNG cần IDNguoiMua vì ID này sẽ được Database tự động tạo (Auto-Increment)
        this.Ten = Ten;
        this.SDT = SDT;
    }

    // 3. Constructor đầy đủ tham số (Dùng khi đọc dữ liệu từ Database)
    public Nguoimua(int IDNguoimua, String Ten, String SDT) {
        this.IDNguoimua = IDNguoimua;
        this.Ten = Ten;
        this.SDT = SDT;
    }

    // --- Getters và Setters ---

    public int getIDNguoimua() {
        return IDNguoimua;
    }

    public void setIDNguoiMua(int IDNguoimua) {
        this.IDNguoimua = IDNguoimua;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    // 4. Phương thức toString() (Giúp hiển thị thông tin dễ dàng)
    @Override
    public String toString() {
        return "ID: " + IDNguoimua +
                " | Tên Khách hàng: " + Ten +
                " | SĐT: " + SDT;
    }
}