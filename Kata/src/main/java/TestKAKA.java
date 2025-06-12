import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class TestKAKA {
    public static void main(String[] args) {
        int h = 0;
        int m = 1;
        int s = 1;
        System.out.println(Past(h,m,s));






    }
    public static int Past(int h, int m, int s) {
        int sum = 0;
        sum += h * 60 * 60 * 60;
        sum += m * 60 * 60;
        sum += s * 60;

        return sum;
    }














}
