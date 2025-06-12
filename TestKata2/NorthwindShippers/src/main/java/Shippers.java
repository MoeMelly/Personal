public record Shippers(int shipperId, String companyName, String phoneNumber) {

    public Shippers(int shipperId, String companyName, String phoneNumber) {
        if (companyName == null || !phoneNumber.matches("(\"^\\\\d{3}[-\\\\s]?\\\\d{3}[-\\\\s]?\\\\d{4}$\")\n" )) {
            throw new IllegalArgumentException("Invalid input. Please Enter correct Information");
        }
        this.shipperId = shipperId;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;

    }
}