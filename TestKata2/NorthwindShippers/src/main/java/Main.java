import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicDataSource dataSource = new BasicDataSource();
        String url = "jdbc:mysql://localhost:3306/northwind?user=root&password=yearup";
        dataSource.setUrl(url);

        while (true) {
            System.out.println("1.)---Display all Shipper---");
            System.out.println("2.)---Create New Shipper---");
            System.out.println("3.)---Change Shipper Phone Number---");
            System.out.println("4)---Delete Shipper---");
            NorthwindDataManager dataManager = new NorthwindDataManager(dataSource);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    displayAllShipper(dataManager);
                }
                case 2 -> {
                    System.out.println("Enter Shipper name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Shipper Phone: ");
                    String phone = scanner.nextLine();
                    dataManager.add(name, phone);
                    break;
                }
                case 3 -> {
                    System.out.println("Enter Shipper Phone number: ");
                    String phoneNum = scanner.nextLine();
                    System.out.println("Enter new Phone number: ");
                    String newPhone = scanner.nextLine();
                    if (newPhone == null || newPhone.isEmpty()) {
                        System.out.println("Can't be empty.Please Enter something at least...");
                    } else {
                        dataManager.update(phoneNum);
                        break;
                    }
                }

                case 4 -> {
                    System.out.println("Enter Shipper ID: ");
                    int shipperId = scanner.nextInt();
                    dataManager.delete(shipperId);
                    break;
                }
                default -> logger.log(Level.SEVERE, "Error Logging info.");

            }

        }
    }

    private static void displayAllShipper(NorthwindDataManager dataManager) {
        List<Shippers> shippersList = dataManager.getAllShippers();
        for (Shippers shippers : shippersList) {
            System.out.println("ID: " + shippers.shipperId() + ", Name: " + shippers.companyName() + ", Phone: " + shippers.phoneNumber());
        }

    }
}






