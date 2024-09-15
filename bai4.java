import java.util.*;
public class bai4{
    public static void main(String[] args) {
        //Lãi suất sẽ cộng vào số dư mỗi tháng.
        //
        //
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your deposite amount:"); //nhập tiền
        double Money = sc.nextDouble();

        System.out.println("Please enter the annual interest rate: "); //nhập lãi hằng năm
        double interest = sc.nextDouble();

        System.out.println("Enter the start month  to send (1-12): "); // tháng bắt đầu
        int startMonth = sc.nextInt();

        System.out.println("Enter the start year: ");//năm gửi
        int startYear = sc.nextInt();

        System.out.println("Enter the end month  to send (1-12): "); //tháng kết húc
        int endMonth = sc.nextInt();

        System.out.println("Enter the end year: "); //tháng kết thúc
        int endYear = sc.nextInt();

        int totalDays = no2_CountDIR(startMonth, startYear, endMonth, endYear);
        System.out.println("Total number of days during the cycle: " + totalDays);

        int totalMonths = no3_CountMIR(startMonth, startYear, endMonth, endYear);
        System.out.println("Total number of months during the cycle: " + totalMonths);

        double last_interest = no1_cpi(Money, interest, startMonth, startYear, endMonth, endYear);
        double total_amount = Money + last_interest;

        System.out.println("Amount of interest earned after the cycle: " + last_interest);
        System.out.println("Amount and interest received after the cycle: " + total_amount);
        sc.close();
    }
    //hàm tính lãi suất kép: compound interest ~ cpi
    public static double no1_cpi(double M, double In, int beginM, int beginY, int endM, int endY) {
        double interest = 0;
        double last_interest = 0;
        int totalDays = no2_CountDIR(beginM, beginY, endM, endY);
        if (no5_LeapY(beginY)) {
            for(int i = 1; i <= totalDays; i++){
                interest = M*((In/100)/366);
                M = M + interest;
                last_interest = last_interest + interest;
            }
        } else{
            for(int i = 1; i <= totalDays; i++){
                interest = M*((In/100)/365);
                M = M + interest;
                last_interest = last_interest + interest;
            }
        }
        return last_interest;
    }
    // Hàm đếm số ngày trong khoảng thời gian
    //ngày trong khoảng thời gian ~ no2_CountDIR
    public static int no2_CountDIR(int beginM, int beginY, int endM, int endY) {
        int totalDays = 0;
        // Lặp qua từng năm từ beginY đến endY
        for (int year = beginY; year <= endY; year++) {
            // Xác định tháng bắt đầu và kết thúc của mỗi năm
            int monthStart = (year == beginY) ? beginM : 1;
            int monthEnd = (year == endY) ? endM : 12;
            // Lặp qua từng tháng trong khoảng thời gian của năm hiện tại
            for (int month = monthStart; month <= monthEnd; month++) {
                totalDays = totalDays + no4_DayIN(month, year);
            }
        }

        return totalDays;
    }
    // Hàm đếm số tháng trong khoảng thời gian
    //ngày trong khoảng thời gian ~ no3_CountMIR
    public static int no3_CountMIR(int beginM, int beginY, int endM, int endY) {
        int totalMonths = 0;
        for (int year = beginY; year <= endY; year++) {
            // Xác định tháng bắt đầu và kết thúc của mỗi năm
            int monthStart, monthEnd;
            
            switch (year) {
                case 0: // Không thể có năm 0, thêm case này cho đầy đủ cú pháp
                    break;
                default:
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
    // Hàm tính số ngày trong một tháng, sử dụng switch-case
    // ngày trong một tháng ~ no4_DayIN
    public static int no4_DayIN(int month, int year) {
        int days = 0;

        switch (month) {
            case 1:case 3:  case 5:  case 7:  case 8:  case 10:case 12: //tháng 1,3,5,7,8,10,12
                days = 31;
                break;
            case 4: case 6: case 9: case 11: //tháng 4,6,9,11
                days = 30;
                break;
            case 2:  // Tháng 2
                // Kiểm tra xem có phải năm nhuận hay không
                if (no5_LeapY(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                System.out.println("Tháng không hợp lệ");
                break;
        }

        return days;
    }
    // Hàm kiểm tra năm nhuận ~ leap year ~ no5_LeapY
    //trả về giá trị true
    public static boolean no5_LeapY(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}