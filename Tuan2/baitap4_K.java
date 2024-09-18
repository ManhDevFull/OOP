import java.util.*;
public class Execrise_4{
    public static void main(String[] args) {
        //Lãi suất sẽ cộng vào số dư mỗi tháng.
        Scanner sc = new Scanner(System.in);
        System.out.printf("Xin moi nhap vao so tien can gui:"); //nhập tiền
        double Money = sc.nextDouble();
        System.out.printf("Xin moi nhap vao lai suat hang nam: "); //nhập lãi hằng năm
        double interest = sc.nextDouble();
        System.out.printf("Xin moi nhap vao thang bat dau gui: "); // tháng bắt đầu
        int ThangBegin = sc.nextInt();
        System.out.printf("Xin moi nhap vao nam gui: ");//năm gửi
        int Nambegin = sc.nextInt();
        System.out.printf("Xin moi nhap vao thang ket thuc: "); //tháng kết húc
        int ThangEndALL = sc.nextInt();
        System.out.printf("Xin moi nhap vao nam ket thuc: "); //năm kết thúc
        int NamEndALL = sc.nextInt();
        boolean Check = true;
        int SothangALL = Hamso3(ThangBegin, Nambegin, ThangEndALL, NamEndALL);
        System.out.println("tong so thang gui ca chu ky la: " + SothangALL);
        double LaiTongCacChuky = Hamso1(Money, interest, ThangBegin, Nambegin, ThangEndALL, NamEndALL) - Money;
        double TongtienALLthang = Money + LaiTongCacChuky;
        System.out.println("Tong lai ca chu ky: " + LaiTongCacChuky);
        System.out.println("Tien goc nhan duoc cuoi chu ky: " + TongtienALLthang);
        System.out.printf("Ban co muon rut tien giua chung ko(Yes/No): ");
        while (Check) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                System.out.printf("Xin moi nhap vao thang ket thuc: "); //tháng kết thúc giữa chu kỳ
                int ThangEndPART = sc.nextInt();
                System.out.printf("Xin moi nhap vao nam ket thuc: "); //năm kết thúc giữa chu kỳ
                int NamEndPART = sc.nextInt();
                // Hamso2(Money, interest, ThangBegin, Nambegin, ThangEndPART, NamEndPART);
                System.out.println(" ");
                int SothangPART = Hamso3(ThangBegin, Nambegin, ThangEndPART, NamEndPART);
                double LaiSuatNchuky = Hamso1(Money, interest, ThangBegin, Nambegin, ThangEndPART, NamEndPART) - Money;
                double TongtienNthang = Money + LaiSuatNchuky;
                System.out.println("Tong lai suat sau " + SothangPART + " chu ky la: " + LaiSuatNchuky);
                System.out.println("Tien goc nhan duoc sau " + SothangPART + " chu ky la: " + TongtienNthang);
                break;
            }
            if (input.equals("no")) {
                System.out.println("Chuong trinh ket thuc");
                break;
            }
        }
        sc.close();
    }
    //hàm tính lãi suất kép: compound interest ~ cpi
    public static double Hamso1(double M, double In, int beginM, int beginY, int endM, int endY) {
        double LaiSuatKep = 0;
        int SothangALL = Hamso3(beginM, beginY, endM, endY);
        for(int i = 1; i <= SothangALL; i++){
            LaiSuatKep = M*Math.pow((1+((In/100)/12)), i);
        }        
        return LaiSuatKep;
    }
    //hàm in thông tin lãi, tiền tổng hàng tháng
    public static void Hamso2(double M, double In, int beginM, int beginY, int endM, int endY) {
        double LaiSuatKep = 0;
        int SothangPART = Hamso3(beginM, beginY, endM, endY);
        for(int i = 1; i <= SothangPART; i++){
            LaiSuatKep = M*Math.pow((1+((In/100)/12)), i);
            System.out.println("Lai nhan duoc thang thu " + i + " la: " + LaiSuatKep);
            System.out.println("Tong tien thang thu " + i + " la: " + (M + LaiSuatKep));
            System.out.println(" ");
        }
    }
    // Hàm đếm số tháng trong khoảng thời gian
    public static int Hamso3(int beginM, int beginY, int endM, int endY) {
        int totalMonths = 0;
        for (int year = beginY; year <= endY; year++) {
            // Xác định tháng bắt đầu và kết thúc của mỗi năm
            int monthStart, monthEnd;
            if (year == 0) {
                return 0;
            } else {
                    if (year == beginY) {
                        monthStart = beginM;
                    } else {
                        monthStart = 1;  // Từ tháng 1 của các năm sau
                    }

                    if (year == endY) {
                        monthEnd = endM;
                    } else {
                        monthEnd = 12;  // Đến tháng 12 của các năm trước
                    }
                    

                    // Đếm số tháng từ monthStart đến monthEnd
                    totalMonths = totalMonths +  (monthEnd - monthStart + 1);
                    break;
            }
        }
        return totalMonths;
    }
}