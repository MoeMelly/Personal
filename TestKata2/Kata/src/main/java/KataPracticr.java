import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KataPracticr {
    private static final Logger logger = Logger.getLogger(String.valueOf(KataPracticr.class));
    public static void main(String[] args) {

    }


    static String greet(String name, String owner) {
        if (name.equals(owner)) {
            return "Hello boss";
        } else {
            return "Hello guest";
        }
    }

    public static boolean feast(String beast, String dish) {
        if (beast == null || dish == null || beast.isEmpty() || dish.isEmpty()) {
            return false;

        }
        return beast.toLowerCase().charAt(0) == dish.toLowerCase().charAt(0) && beast.toLowerCase().charAt(beast.length() - 1) == dish.toLowerCase().charAt(dish.length() - 1);
    }

    public static boolean setAlarm(boolean employed, boolean vacation) {
        boolean setAlarm = false;
        if (employed && vacation) {
            setAlarm = false;
        } else if (employed && !vacation) {
            setAlarm = true;
        } else if (!employed && vacation) {
            setAlarm = false;

        } else if (!employed && !vacation) {
            setAlarm = false;

        }

        return setAlarm;
    }

    public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
        return mpg * fuelLeft >= distanceToPump;
    }

    public static int enough(int cap, int on, int wait) {
        int availableSpace = cap - on;
        if (availableSpace >= wait) {
            return 0;
        } else {
            return wait - availableSpace;
        }
    }


    public static String findNeedle(Object[] haystack) {
        for (int i = 0; i < haystack.length; i++) {
            if ("needle".equals(haystack[i])) {
                return "found the needle at position " + i;
            }

        }

        return "needle not found";
    }

    public static int[] map(int[] arr) {
        return Arrays.stream(arr).map(n -> n * 2).toArray();
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        if (arrayOfSheeps == null) return 0;

        return (int) Arrays.stream(arrayOfSheeps).filter(Boolean.TRUE::equals)
                .count();
    }

    public static String binaryAddition(int a, int b) {
        int num = a + b;
        return (String) Integer.toBinaryString(num);
    }

    public static List<String> friend(List<String> x) { // makes sure name length is no more than 4
        return (List<String>) x.stream().filter(name -> name.length() == 4).toList();

    }
    public static String solution(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0 ; i--) {
            reversed.append(str.charAt(i));


        }

        return reversed.toString() ;
    }
    public static int summation(int n) {
        return n * (n + 1) / 2;
    }
    public static String updateLight(String current) {
       if (current.equalsIgnoreCase("green"))
           return "red";
       else if (current.equalsIgnoreCase("yellow")) {
           return "green";
       } else if (current.equalsIgnoreCase("red")) {
           return "yellow";

       } else {
           logger.log(Level.SEVERE, "Error With Lights");

       }

        return current;
    }
    public static int squareSum(int[] n)
    {
        int sum = 0;
        for (int j : n) {
            sum += (int) Math.sqrt(j);

        }
        return sum;
    }
}
















