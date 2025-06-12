import java.util.Scanner;

public class Design {
    static Scanner scanner = new Scanner(System.in);
    public static void titleNewLineTop() {
        System.out.println("\n━━━✦━━━✦━━━✦━━━✦━━━━━━✦━━━✦━━━✦━━━✦━━━━━━✦━━━✦━━━✦━━━✦━━━");
    }
    public static void titleLineBottom() {
        System.out.println("━━━✦━━━✦━━━✦━━━✦━━━━━━✦━━━✦━━━✦━━━✦━━━━━━✦━━━✦━━━✦━━━✦━━━");
    }
    public static void enterPrompt() {
        System.out.print("\n\nEnter:  ");
    }
    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }
    public static boolean isInt(String input, boolean isPositive) {
        try {
            if (input.matches("\\d+")) {
                Integer.parseInt(input);
                if (isPositive) {if (Integer.parseInt(input) < 0){System.out.println("Positive Number Only. Please try again.");return false;}}
                return true;
            } else {
                System.out.println("Incorrect Number: " + input);
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad boy/girl.");
            return false;
        }
        return false;
    }
    public static void cantBeEmpty() {
        System.out.println("This field cannot be empty!");
    }
    public static String autoCap(String capital) {
        String[] parts = capital.toLowerCase().split(" ");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].substring(0,1).toUpperCase()+parts[i].substring(1);
        }
        return String.join(" ",parts);
    }
    public static String getUserString(Scanner scanner, boolean prompt, String messages, boolean autoCap) {
        boolean keepGoing = true;
        String input = null;

        while (keepGoing) {
            if (prompt) {
                Design.titleNewLineTop();
                System.out.println(messages);
                Design.titleLineBottom();
            }
            Design.enterPrompt();
            input = scanner.nextLine().trim().replaceAll("\\s+"," ");
            if (Design.isEmpty(input)) {Design.cantBeEmpty(); continue;}
            if (autoCap) {input = Design.autoCap(input);}
            keepGoing = false;
        }
        return input;
    }
    public static int getUserInt(Scanner scanner, boolean prompt, String message, boolean isPositive) {
        boolean keepGoing = true;
        String input = null;
        while (keepGoing) {
             input = Design.getUserString(scanner, prompt, message, false);
            if (!isInt(input, isPositive)) continue;
            keepGoing = false;
        }
        return Integer.parseInt(input);
    }
    public static int minAndMax(Scanner scanner, boolean prompt, String message, boolean isPostive,int min, int max) {
        int i = 0;
        while (true) {
            i = Design.getUserInt(scanner,prompt,message,isPostive);
            if (min > i || max < i) {
                System.out.println("Please choose a number in range.");
                continue;
            }
            break;
        }
        return i;
    }


}




