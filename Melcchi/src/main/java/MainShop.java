import java.util.LinkedHashMap;
import java.util.Scanner;

public class MainShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean keepGoing = false;
        while (!keepGoing) {
            System.out.println("---DIVINES BEAUTY STORE-----");
            System.out.println("1. Browse Wigs");
            System.out.println("2. Browse Lashes And Accessories");
            System.out.println("3. Browse Extensions");
            System.out.println("4. Assign Roles");
            System.out.println("5. View Cart");
            System.out.println("6. Exit");

            System.out.println("Please Choose From Options Listed Above: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showDivinesWigs(scanner);
                case "2" -> showLashesAndAccessories(scanner);
                case "3" -> showExtensions(scanner);


                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }


        }
    }

    public static DivinesWigs showDivinesWigs(Scanner scanner) {
        while (true) {
            LinkedHashMap<Integer, DivinesWigs> wigsMap = new LinkedHashMap<>();
            int counter = 0;

            for (int i = 0; i < DivinesWigs.values().length; i++) {
                counter++;
                System.out.println(counter + ") " + DivinesWigs.values()[i]);
                wigsMap.put(counter, DivinesWigs.values()[i]);
            }
            int choice = Design.minAndMax(scanner, true,
                    "Choose a wig to add to cart", true,
                    1, DivinesWigs.values().length
            );
            DivinesWigs selectedWig = wigsMap.get(choice);
            System.out.println("You Selected: " + selectedWig);
            System.out.println("Do you like this wig? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")) {
                System.out.println("Would you like install services for this wig? (yes/no): ");
                String install = scanner.nextLine().trim().toLowerCase();

                if (install.equals("yes") || install.equals("y")) {
                    boolean customize = false;

                    while (true) {
                        System.out.println("Would you like customization? (yes/no): ");
                        String inputs = scanner.nextLine().trim().toLowerCase();

                        if (inputs.equals("yes") || inputs.equals("y")) {
                            customize = true;
                            break;
                        } else if (inputs.equals("no") || inputs.equals("n")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter yes or no.");

                        }
                    }
                    boolean wigRevamp = false;
                    while (true) {
                        System.out.println("Would you like a wig revamp? (yes/no): ");
                        String enter = scanner.nextLine().trim().toLowerCase();
                        if (enter.equals("yes") || enter.equals("y")) {
                            wigRevamp = true;
                        } else if (enter.equals("no") || enter.equals("n")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter yes or no.");
                        }
                    }
                    boolean bringOwnPrep = false;
                    while (true) {
                        System.out.println("Did you bring your own prep? (yes/no): ");
                        String yesOrNo = scanner.nextLine().trim().toLowerCase();
                        if (yesOrNo.equals("yes") || yesOrNo.equals("y")) {
                            bringOwnPrep = true;
                            break;
                        } else if (yesOrNo.equals("no") || yesOrNo.equals("n")) {
                            break;

                        } else {
                            System.out.println("Invalid input. Please enter yes or no.");
                        }

                    }
                    boolean extraHair = false;
                    while (true) {
                        System.out.println("Would you like extra hair added? (yes/no): ");
                        String inputs = scanner.nextLine().trim().toLowerCase();
                        if (inputs.equals("yes") || inputs.equals("y")) {
                            extraHair = true;
                            break;
                        } else if (inputs.equals("no") || inputs.equals("n")) {
                            break;

                        } else {
                            System.out.println("Invalid input. Please enter yes or no.");
                        }
                    }
                    boolean installationFee = false;
                    while (true) {
                        System.out.print("Apply installation fee? (yes/no): ");
                        String inputs = scanner.nextLine().trim().toLowerCase();
                        if (inputs.equals("yes") || inputs.equals("y")) {
                            installationFee = true;
                            break;
                        } else if (input.equals("no") || input.equals("n")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter yes or no.");


                        }
                    }
                    return new InstallServices(
                            null,
                            customize,
                            wigRevamp,
                            extraHair,
                            bringOwnPrep,
                            installationFee,
                            null,
                            selectedWig
                    ).getWigs();


                } else {
                    return new InstallServices(
                            null, false, false, false, false, false, null, selectedWig
                    ).getWigs();
                }
            } else {
                System.out.println("No problem, let's try again.\n");
            }


        }
    }

        public static DivinesLashes showLashesAndAccessories (Scanner scanner){
        LinkedHashMap<Integer, DivinesLashes> divinesLashesLinkedHashMap = new LinkedHashMap<>();
            int counter = 0;
            for (int i = 0; i < divinesLashesLinkedHashMap.size(); i++) {
                counter++;
                System.out.println(counter + ") " + DivinesLashes.values()[i]);
                divinesLashesLinkedHashMap.put(counter, DivinesLashes.values()[i]);
            }
            int choice = Design.minAndMax(scanner, true, "Choose Lashes and/or accessories", true,
                    1, DivinesLashes.values().length

            );
            return null;
        }

    public static DivinesExtensions showExtensions (Scanner scanner){

        return null;
    }
}











