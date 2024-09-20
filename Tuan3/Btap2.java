import java.util.*;

public class Btap2 {
    static float diem;
    static Scanner sc;
    static String Hediem;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Nhap vao loai hinh tinh thang diem(thang diem 10/thang diem 4): ");
        Hediem = sc.nextLine();
        switch (Hediem) {
            case "thang diem 10":
                System.out.println("Nhap vao diem so:");
                diem = sc.nextFloat();
                String kq1 = (diem < 4 )? "Day la hoc sinh xep loai F":
                            (diem<5.5) ? "Day la hoc sinh xep loai D":
                            (diem<7)   ? "Day la hoc sinh xep loai C":
                            (diem<8.5) ? "Day la hoc sinh xep loai B":
                                         "Day la hoc sinh xep loai A";
                System.out.println(kq1);
                break;
            default:
                System.out.println("Nhap vao diem so:");
                diem = sc.nextFloat();
                String kq2 = (diem<2.0)? "Day la hoc sinh xep loai Yeu":
                             (diem<2.5)? "Day la hoc sinh xep loai Trung binh":
                             (diem<3.2)? "Day la hoc sinh xep loai Kha":
                             (diem<3.6)? "Day la hoc sinh xep loai Gioi":
                                         "Day la hoc sinh xep loai Xuat sac";
                System.out.println(kq2);
                break;
        }
    }
}
// thang diem 10
// thang diem 4