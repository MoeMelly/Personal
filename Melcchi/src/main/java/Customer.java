import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    String name;
    String phoneNumber;
    String email;
    String address;
    List<DivinesWigs> wigs;


    List<DivinesLashes> lashes;
    List<DivinesExtensions> extensions;
    Cart cart;


    public Customer(String name, String phoneNumber, String email, String address, DivinesWigs wigs, DivinesLashes lashes, DivinesExtensions extensions,Cart cart) {
        if (name == null || !name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Name must contain letters only and field cannot be empty.");
        }
        if (phoneNumber == null || !phoneNumber.matches("^\\+?[0-9]{10,15}$")) {
            throw new IllegalArgumentException("Invalid Phone Number. Please try again.");
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z)-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (address == null || !address.matches("^[a-zA-Z0-9\\s,.'-]+$")) {
            throw new IllegalArgumentException("Invalid address format.");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.wigs = (wigs != null) ? new ArrayList<>(Collections.singleton(wigs)) : new ArrayList<>();
        this.lashes = (lashes != null) ? new ArrayList<>(Collections.singleton(lashes)) : new ArrayList<>();
        this.extensions = (extensions != null) ? new ArrayList<>(Collections.singleton(extensions)) : new ArrayList<>();
        this.cart = (cart != null) ? cart : new Cart();
    }


    public List<DivinesWigs> getWigs() {
        return wigs;
    }

    public List<DivinesLashes> getLashes() {
        return lashes;
    }

    public List<DivinesExtensions> getExtensions() {
        return extensions;
    }
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }
    public void addWigs(DivinesWigs wig) {
        if (wigs!= null) {
            wigs.add(wig);

        }

    }

    public void addLashes(DivinesLashes lash) {
        if (lash != null) {
            lashes.add(lash);
        }
    }
    public void addExtensions(DivinesExtensions exten) {
        if (extensions != null) {
            extensions.add(exten);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", wigs=" + wigs +
                ", lashes=" + lashes +
                ", extensions=" + extensions +
                ", cart=" + cart +
                '}';
    }
}
