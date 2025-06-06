public enum DivinesWigs {
    FRONT_LACE_WIG("Front Lace Wig",100,9,130),
    LACE_FRONT_WIG("Lace Front Wig",120,10,130),
    FULL_LACE_WIG("Full Lace Wig",180,10,130),
    GLUELESS_WIG("Glueless Wig",130,12,130),
    V_PART_WIG("V Part Wig",75,10,130);

    private final String name;
    private final double price;
    private final int length;
    private final int density;


    DivinesWigs(String name, double price, int length, int density) {
        this.name = name;
        this.price = price;
        this.length = length;
        this.density = density;
    }

    public double getPrice() {
        return price;
    }

    public int getDensity() {
        return density;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public double extraWigs(DivinesWigs wigType) {
        double total = 0.0;
        int baseLength = 20;
        int baseDensity = 150;
        double costPerInch = 5.0;
        double densityCharge = 30.0;
        double price = switch (wigType) {
            case FRONT_LACE_WIG -> 100;
            case LACE_FRONT_WIG -> 120.00;
            case FULL_LACE_WIG -> 150.00;
            case GLUELESS_WIG -> 110.00;
            case V_PART_WIG -> 85.00;
            default -> throw new IllegalStateException("Unexpected value: " + wigType);
        };
        if (length > baseLength) {
            total += (length - baseLength) * costPerInch;
        }
        if (density > baseDensity) {
            total += densityCharge;
        }
        return total;
    }
    public static String formatEnumName(String enumName) {
        String[] words = enumName.split("_");
        for (int i = 0; i < words.length ; i++) {
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();

        }


        return String.join(" " ,words);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.name).append("\n\n");
        s.append("length: ").append(this.getLength()).append("\n");
        s.append("Density: ").append(this.getDensity()).append("\n");
        s.append("Price $").append(this.getPrice()).append("\n");


        return s.toString();
    }
}
