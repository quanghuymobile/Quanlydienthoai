import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
        System.out.println("1.Them dien thoai");
        System.out.println("2.Hien thi danh sach dien thoai");
        System.out.println("3.Tim kiem dien thoai");
        System.out.println("4.Xoa dien thoai");
        System.out.println("5.Cap nhat thong tin dien thoai");
        System.out.println("6.Sap xep dien thoai theo gia tang dan ");
        System.out.println("7.Sap xep dien thoai theo gia giam dan");
        System.out.println("8.Nhập vào lựa chon của bạn: ");
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
                    System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
                    System.out.println("1.Them dien thoai");
                    System.out.println("2.Hien thi danh sach dien thoai");
                    System.out.println("3.Tim kiem dien thoai");
                    System.out.println("4.Xoa dien thoai");
                    System.out.println("5.Cap nhat thong tin dien thoai");
                    System.out.println("6.Sap xep dien thoai theo gia tang dan ");
                    System.out.println("7.Sap xep dien thoai theo gia giam dan");
                    System.out.println("8.Nhập vào lựa chon của bạn: ");
                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 2:
                    System.out.println("Hiển thị danh sách điện thoại");
                    System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
                    System.out.println("1.Them dien thoai");
                    System.out.println("2.Hien thi danh sach dien thoai");
                    System.out.println("3.Tim kiem dien thoai");
                    System.out.println("4.Xoa dien thoai");
                    System.out.println("5.Cap nhat thong tin dien thoai");
                    System.out.println("6.Sap xep dien thoai theo gia tang dan ");
                    System.out.println("7.Sap xep dien thoai theo gia giam dan");
                    System.out.println("8.Nhập vào lựa chon của bạn: ");
                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 3:
                    System.out.println("Tìm kiếm điện thoại theo tên");
                    System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
                    System.out.println("1.Them dien thoai");
                    System.out.println("2.Hien thi danh sach dien thoai");
                    System.out.println("3.Tim kiem dien thoai");
                    System.out.println("4.Xoa dien thoai");
                    System.out.println("5.Cap nhat thong tin dien thoai");
                    System.out.println("6.Sap xep dien thoai theo gia tang dan ");
                    System.out.println("7.Sap xep dien thoai theo gia giam dan");
                    System.out.println("8.Nhập vào lựa chon của bạn: ");
                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 4:
                    System.out.println("Xoá điện thoại theo tên");
                    System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
                    System.out.println("1.Them dien thoai");
                    System.out.println("2.Hien thi danh sach dien thoai");
                    System.out.println("3.Tim kiem dien thoai");
                    System.out.println("4.Xoa dien thoai");
                    System.out.println("5.Cap nhat thong tin dien thoai");
                    System.out.println("6.Sap xep dien thoai theo gia tang dan ");
                    System.out.println("7.Sap xep dien thoai theo gia giam dan");
                    System.out.println("8.Nhập vào lựa chon của bạn: ");
                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 5:
                    System.out.println("Cập nhật thông tin điện thoại theo tên");
                    System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
                    System.out.println("1.Them dien thoai");
                    System.out.println("2.Hien thi danh sach dien thoai");
                    System.out.println("3.Tim kiem dien thoai");
                    System.out.println("4.Xoa dien thoai");
                    System.out.println("5.Cap nhat thong tin dien thoai");
                    System.out.println("6.Sap xep dien thoai theo gia tang dan ");
                    System.out.println("7.Sap xep dien thoai theo gia giam dan");
                    System.out.println("8.Nhập vào lựa chon của bạn: ");

                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 6:
                    System.out.println("Sắp xếp điện thoại theo giá (tăng dần)");

                    System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
                    System.out.println("1.Them dien thoai");
                    System.out.println("2.Hien thi danh sach dien thoai");
                    System.out.println("3.Tim kiem dien thoai");
                    System.out.println("4.Xoa dien thoai");
                    System.out.println("5.Cap nhat thong tin dien thoai");
                    System.out.println("6.Sap xep dien thoai theo gia tang dan ");
                    System.out.println("7.Sap xep dien thoai theo gia giam dan");
                    System.out.println("8.Nhập vào lựa chon của bạn: ");
                    while (choice <1 || choice >8) {
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                        choice = input.nextInt();
                        input.nextLine();

                    }
                    break;
                case 7:
                    System.out.println("Sắp xếp điện thoại theo giá (giam dần)");

                    System.out.println("Chào mừng bạn đến với chương trình quản lý cửa hàng điện thoại!");
                    System.out.println("1.Them dien thoai");
                    System.out.println("2.Hien thi danh sach dien thoai");
                    System.out.println("3.Tim kiem dien thoai");
                    System.out.println("4.Xoa dien thoai");
                    System.out.println("5.Cap nhat thong tin dien thoai");
                    System.out.println("6.Sap xep dien thoai theo gia tang dan ");
                    System.out.println("7.Sap xep dien thoai theo gia giam dan");
                    System.out.println("8.Nhập vào lựa chon của bạn: ");
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
}


