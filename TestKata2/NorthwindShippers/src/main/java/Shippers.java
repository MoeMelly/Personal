public record Shippers(int shipperId, String companyName, String phoneNumber) {

    public Shippers(int shipperId, String companyName, String phoneNumber) {
        this.shipperId = shipperId;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;

    }
}