import java.util.Scanner;

public class MainShop {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {



        System.out.println("---Welcome to Divines Beauty Shop-----");
        System.out.println("1. Browse Wigs");
        System.out.println("2. Browse Lashes And Accessories");
        System.out.println("3. Browse Extensions");
        System.out.println("4. Install Services");
        System.out.println("5. Assign Roles");
        System.out.println("Exit");

        System.out.println("Please Choose From Options Listed Above: ");
        String choice = scanner.nextLine();


        }
        public void showDivinesWigs() {
            System.out.println("\n--- Divines Wig Collection ---");
            for (DivinesWigs wigs : DivinesWigs.values()) {
                System.out.println("- " + wigs.name().replace("_", " "));
            }
        }
        p






    }
}
