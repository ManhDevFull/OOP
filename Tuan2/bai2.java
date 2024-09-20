import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap ten cua ban: ");
        String name = sc.nextLine();
        
        System.out.print("Nhap tuoi cua ban: ");
        int age = sc.nextInt();
        
        System.out.print("Nhap chieu cao cua ban (cm): ");
        double height = sc.nextDouble();
        
        System.out.print("Ban co thich lap trinh khong (true/false): ");
        boolean like = sc.nextBoolean();

        System.out.println("\nThong tin ca nhan cua ban:");
        System.out.println("Ten: " + name);
        System.out.println("Tuoi: " + age);
        System.out.println("Chieu cao: " + height + " cm");
        System.out.println("Co thich lap trinh khong: " + like);

        sc.close(); 
    }
}
