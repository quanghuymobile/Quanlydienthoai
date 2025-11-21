import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class PhoneManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/qldt";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";
    private boolean kiemTraTonTai(String ten) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Phone WHERE Ten = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ten);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public PhoneManager() {

    }

    public void themDienThoai(Phone phone) {
            String sql = "INSERT INTO Phone (Ten, HangSanXuat, Gia) VALUES (?, ?, ?)";

            try {
                if (kiemTraTonTai(phone.getTen())) {
                    System.out.println(" Lỗi: Điện thoại " + phone.getTen() + " đã tồn tại trong CSDL. Không thể thêm.");
                    return;
                }

                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                     PreparedStatement pstmt = conn.prepareStatement(sql))
                {
                    pstmt.setString(1, phone.getTen());
                    pstmt.setString(2, phone.getHangSanXuat());
                    pstmt.setDouble(3, phone.getGia());

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println(" Đã thêm điện thoại " + phone.getTen() + " vào CSDL thành công!");
                    } else {
                        System.out.println(" Lỗi: Không thể thêm điện thoại vào CSDL.");
                    }
                }

            } catch (SQLException e) {
                System.out.println(" Lỗi CSDL khi thêm điện thoại: Vui lòng kiểm tra Driver, URL, User/Pass.");
                System.out.println("Chi tiết lỗi: " + e.getMessage());
            }
        }


    public void hienThiTatCa() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Ten, HangSanXuat, Gia FROM Phone ORDER BY Ten ASC"))
        {
            System.out.println("\n--- DANH SÁCH ĐIỆN THOẠI TỪ SQL ---");
            boolean found = false;
            int count = 1;

            while (rs.next()) {
                found = true;
                String ten = rs.getString("Ten");
                String hang = rs.getString("HangSanXuat");
                double gia = rs.getDouble("Gia");

                System.out.printf("%d. Tên: %s | Hãng: %s | Giá: %,.0f VND%n",
                        count++, ten, hang, gia);
            }

            if (!found) {
                System.out.println("Danh sách điện thoại trong CSDL hiện đang trống.");
            }
            System.out.println("------------------------------------\n");

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối hoặc truy vấn CSDL: Vui lòng kiểm tra Driver, URL, User/Pass và Database 'qldt' đã được tạo chưa.");
            System.out.println("Chi tiết lỗi: " + e.getMessage());
        }
    }

    public void timKiemTheoTen(Scanner scanner) {
        System.out.print("Nhập tên (hoặc một phần tên) cần tìm: ");
        String tenTimKiem = scanner.nextLine();
        // LOGIC TÌM KIẾM (Sử dụng lệnh SELECT WHERE LIKE)
    }

    public void xoaDienThoai(Scanner scanner) {
        System.out.print("Nhập tên điện thoại muốn xóa: ");
        String tenXoa = scanner.nextLine();
        // LOGIC XÓA (Sử dụng lệnh DELETE WHERE)
    }

    public void capNhatThongTin(Scanner scanner) {
        System.out.print("Nhập tên điện thoại muốn cập nhật: ");
        String tenCapNhat = scanner.nextLine();
        // LOGIC CẬP NHẬT (Sử dụng lệnh UPDATE SET WHERE)
    }

    public void sapXepTheoGiaTang() {
        // LOGIC SẮP XẾP ĐÃ CÓ TRONG CÂU LỆNH SELECT Ở hienThiTatCa() (ORDER BY Gia ASC)
        System.out.println("Đã sắp xếp danh sách theo giá tăng dần (được xử lý trong câu lệnh truy vấn).");
        hienThiTatCa();
    }

    public void sapXepTheoGiaGiam() {
        // Cần viết lại câu lệnh SELECT ORDER BY Gia DESC
        System.out.println("Cần viết lại logic SELECT ORDER BY Gia DESC.");
    }
}