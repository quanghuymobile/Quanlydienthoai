import java.nio.channels.ScatteringByteChannel;
import java.security.KeyStore;
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
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, phone.getTen());
                pstmt.setString(2, phone.getHangSanXuat());
                pstmt.setDouble(3, phone.getGia());

                int row = pstmt.executeUpdate();

                if (row > 0) {
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
             ResultSet rs = stmt.executeQuery("SELECT Ten, HangSanXuat, Gia FROM Phone ORDER BY Ten ASC")) {
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

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối hoặc truy vấn CSDL: Vui lòng kiểm tra Driver, URL, User/Pass và Database 'qldt' đã được tạo chưa.");
            System.out.println("Chi tiết lỗi: " + e.getMessage());
        }
    }

    public void timKiemTheoTen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên (hoặc một phần tên) cần tìm: ");
        String tenTimKiem = scanner.nextLine();
        String sql = "SELECT Ten, HangSanXuat, Gia FROM Phone WHERE LOWER(Ten) LIKE ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + tenTimKiem.toLowerCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {

                boolean found = false;
                int count = 1;

                while (rs.next()) {
                    found = true;
                    String ten = rs.getString("Ten");
                    String hang = rs.getString("HangSanXuat");
                    double gia = rs.getDouble("Gia");

                    // In thông tin tìm thấy
                    System.out.printf("%d. Tên: %s | Hãng: %s | Giá: %,.0f VND%n",
                            count++, ten, hang, gia);
                }

                if (!found) {
                    System.out.println("Không tìm thấy điện thoại nào khớp với tên (hoặc một phần tên) đã nhập.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối hoặc truy vấn CSDL: Vui lòng kiểm tra Driver, URL, User/Pass và Database 'qldt' đã được tạo chưa.");
            System.out.println("Chi tiết lỗi: " + e.getMessage());
        }
        // LOGIC TÌM KIẾM (Sử dụng lệnh SELECT WHERE LIKE)
    }

    public void xoaDienThoai(String tenXoa) {
        String sql = "DELETE FROM Phone WHERE Ten = ?";
//        System.out.println("Xóa Điện Thoại");
//        System.out.print("Nhập tên điện thoại muốn xóa: ");
//        tenXoa = scanner.nextLine();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tenXoa);
            ;
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Xoa dien thoai thanh cong " + tenXoa);
            } else {
                System.out.println("Khong tim thay dien thoai ");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi CSDL khi xóa điện thoại: " + e.getMessage());

        }

        // LOGIC XÓA (Sử dụng lệnh DELETE WHERE)
    }

    public void capNhatThongTin(Phone phone) {

        String sql = "UPDATE Phone SET hangSanXuat = ?, gia = ? WHERE ten = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, phone.hangSanXuat);
            ps.setDouble(2, phone.gia);
            ps.setString(3, phone.ten);
            int row = ps.executeUpdate();
            if (row > 0) {
                // Kiểm tra thành công
                System.out.println("Cập nhật thành công thông tin điện thoại: " + phone.ten);
            } else {
                // Kiểm tra thất bại (Không tìm thấy bản ghi)
                System.out.println(" Không tìm thấy điện thoại có tên '" + phone.ten + "' để cập nhật.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi CSDL khi xóa điện thoại: " + e.getMessage());

        }


    }

    public void sapXepTheoGiaTang() {
        // LOGIC SẮP XẾP ĐÃ CÓ TRONG CÂU LỆNH SELECT Ở hienThiTatCa() (ORDER BY Gia ASC)
        String sql = "SELECT ten, hangSanXuat, gia FROM Phone ORDER BY gia ASC";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- DANH SÁCH ĐIỆN THOẠI SẮP XẾP THEO GIÁ TĂNG DẦN ---");
            boolean found = false;
            int count = 1;

            while (rs.next()) {
                found = true;
                String ten = rs.getString("ten");
                String hang = rs.getString("hangSanXuat");
                double gia = rs.getDouble("gia");

                // In thông tin
                System.out.printf("%d. Tên: %s | Hãng: %s | Giá: %,.0f VND%n",
                        count++, ten, hang, gia);
            }

            if (!found) {
                System.out.println("Danh sách điện thoại trong CSDL hiện đang trống.");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối hoặc truy vấn CSDL: " + e.getMessage());
        }

        System.out.println("Đã sắp xếp danh sách theo giá tăng dần (được xử lý trong câu lệnh truy vấn).");


}
//public void sapXepTheoGiaTang() {
//    // Câu lệnh SQL (ORDER BY gia ASC)
//    String sql = "SELECT ten, hangSanXuat, gia FROM Phone ORDER BY gia ASC";
//
//    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//         Statement stmt = conn.createStatement();
//         ResultSet rs = stmt.executeQuery(sql)) {
//
//        System.out.println("\n--- DANH SÁCH ĐIỆN THOẠI SẮP XẾP THEO GIÁ TĂNG DẦN (ASC) ---");
//        boolean found = false;
//        int count = 1;
//
//        while (rs.next()) {
//            found = true;
//
//
//            String ten = rs.getString("ten");
//            String hang = rs.getString("hangSanXuat");
//            double gia = rs.getDouble("gia");
//
//            // In thông tin
//            System.out.printf("%d. Tên: %s | Hãng: %s | Giá: %,.0f VND%n",
//                    count++, ten, hang, gia);
//        }
//
//        if (!found) {
//            System.out.println("Danh sách điện thoại trong CSDL hiện đang trống.");
//        }
//
//    } catch (SQLException e) {
//        System.out.println("Lỗi kết nối hoặc truy vấn CSDL: " + e.getMessage());
//    }
//
//    // LỖI 2 ĐÃ SỬA: Bỏ gọi hienThiTatCa() và thông báo ở cuối
//    // vì việc hiển thị đã được thực hiện bên trong khối try-catch.
//}


    public void sapXepTheoGiaGiam() {
        // Cần viết lại câu lệnh SELECT ORDER BY Gia DESC
        System.out.println("Cần viết lại logic SELECT ORDER BY Gia DESC.");
    }
    public void Themnguoimua(Nguoimua nguoimua){
        String sql = "INSERT INTO Nguoimua (Ten,SDT) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps=conn.prepareStatement(sql))

        {
                ps.setString(1, nguoimua.getTen());
                ps.setString(2,nguoimua.getSDT());
                int row = ps.executeUpdate();
                if(row>0){
                    System.out.println("Đã thêm thành công ");
                }
                else {
                    System.out.println("Không thể thêm ");
                }


        }
 catch (SQLException e) {
            System.out.println("Lỗi CSDL khi xóa điện thoại: " + e.getMessage());

        }

    }
}
