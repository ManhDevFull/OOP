import java.util.*;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập độ dài của mảng
        System.out.print("Nhap so phan tu cua mang: ");
        int n = scanner.nextInt();

        // Khởi tạo mảng với kích thước n
        int[] a = new int[n];

        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            a[i] = scanner.nextInt();
        }

        int tong = 0;
        for (int i = 0; i < n; i++) {
            tong += a[i];
        }

        System.out.println("Tong cac phan tu cua mang la: " + tong);
    }
}
