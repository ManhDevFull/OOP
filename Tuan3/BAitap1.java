import java.util.*;
public class Baitap1 {
    static int A;
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Nhap vao so A:");
        A = sc.nextInt();
        String kq = (A>0)? "Day la so duong":
                    (A<0)? "Day la so am":
                            "Day la so 0";
        System.out.println(kq);
    }
}
