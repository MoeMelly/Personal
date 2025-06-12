import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CustomerOrderReceipt {
    private Customer customer;

    public CustomerOrderReceipt(Customer customer) {
        this.customer = customer;
    }

        public void saveToFile() throws IOException, IllegalAccessException {
            DivinesExtensions extensions = DivinesExtensions.SEW_IN;
            DivinesWigs wigs = DivinesWigs.FRONT_LACE_WIG;
            DivinesLashes lashes = DivinesLashes.FAUX_MINK_LASHES;
            String fileName = "src/main/resources/Receipt.txt";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = formatter.format(LocalDateTime.now());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write("CUSTOMER RECEIPT\n");
                writer.write("---------------------------\n");
                writer.write("Customer Name: " + customer.getName() + "\n");
                writer.write("Customer Phone Number: " + customer.getPhoneNumber() + "\n");
                writer.write("Customer Email: " + customer.getEmail() + "\n");
                writer.write("Customer Address: " + customer.getAddress() + "\n\n");

                double total = 0.0;

                List<DivinesExtensions> extensions1 = customer.getExtensions();
                if (!extensions1.isEmpty()) {
                    writer.write("Extensions Purchased:\n");
                    for (DivinesExtensions ext : extensions1) {
                        writer.write(" - " + ext.getDescriptions() + " - $" + ext.getPrice() + "\n");
                        total += ext.getPrice();
                    }

            }
                List<DivinesLashes> list = customer.getLashes();
                if (!list.isEmpty()) {
                    writer.write("Lashes and Accessories Purchased:\n");
                    for (DivinesLashes lash : list) {
                        writer.write(" - " + lash.getDescription() + " - $" + lash.getPrice());
                        total += lash.getPrice();
                    }
                }
                List<DivinesWigs> wigsList = customer.getWigs();
                if (!wigsList.isEmpty()) {
                    writer.write("Wigs Purchased:\n");
                    for (DivinesWigs divinesWigs : wigsList) {
                        writer.write(" - " + divinesWigs.getName() + " -$" + divinesWigs.getPrice());
                        total += divinesWigs.getPrice();
                    }
                }
                writer.write("----------------------------------------------\n");
                writer.write("Total: $" + String.format("%.2f" , total) + "\n");
                writer.write("\n");
                System.out.println("Receipt Written!");


        } catch (IOException e) {
                e.printStackTrace();
            }

    }
}



