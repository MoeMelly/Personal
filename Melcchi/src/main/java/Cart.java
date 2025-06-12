import java.util.List;

public class Cart {
   private String productType;
    private Enum<?> product;
    private double price;
    public Cart() {
        this.price = price;
        this.product = product;
        this.productType = productType;
    }
    @Override
    public String toString() {
        return productType + ": " + product.toString() + " ($" + price + ")";
    }


}
