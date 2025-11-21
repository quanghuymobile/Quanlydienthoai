import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
          PhoneManager manager = new PhoneManager();



        Scanner input = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
       hienThiMenu();
        int choice = input.nextInt();
        input.nextLine();
        while (choice <1 || choice >8) {
            System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
            choice = input.nextInt();
            input.nextLine();

        }
        while (choice >=1 && choice <=8){

            switch (choice) {
                case 1:
                    System.out.println("THêm điện thoại");
                    System.out.println("Nhap ten ");
                   String ten=input.nextLine();
                    System.out.println("Nhâập haãng sản xuaâts");
                    String hangSanXuat=input.nextLine();
                    System.out.println("Nhập gia ");
                    Double gia=input.nextDouble();
                    Phone phone = new Phone(ten, hangSanXuat, gia);

manager.themDienThoai(phone);
                    hienThiMenu();

                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 2:
                    System.out.println("Hiển thị danh sách điện thoại");
                    manager.hienThiTatCa();
                    hienThiMenu();

                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 3:
                    System.out.println("Tìm kiếm điện thoại theo tên");
                    hienThiMenu();

                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 4:
                    System.out.println("Xoá điện thoại theo tên");
                    hienThiMenu();

                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 5:
                    System.out.println("Cập nhật thông tin điện thoại theo tên");
                    hienThiMenu();


                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 6:
                    System.out.println("Sắp xếp điện thoại theo giá (tăng dần)");

                    hienThiMenu();

                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 7:
                    System.out.println("Sắp xếp điện thoại theo giá (giam dần)");

                  hienThiMenu();
                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 8:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                    break;
            }

            choice = input.nextInt();
            input.nextLine();


        }

    }
    private static void hienThiMenu() {

        System.out.println("1.Them dien thoai");
        System.out.println("2.Hien thi danh sach dien thoai");
        System.out.println("3.Tim kiem dien thoai");
        System.out.println("4.Xoa dien thoai");
        System.out.println("5.Cap nhat thong tin dien thoai");
        System.out.println("6.Sap xep dien thoai theo gia tang dan ");
        System.out.println("7.Sap xep dien thoai theo gia giam dan");
        System.out.println("8.Nhap lua chon cua ban ");
    }
}



