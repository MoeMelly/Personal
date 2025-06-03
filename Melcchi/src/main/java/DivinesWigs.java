public enum DivinesWigs {
    FRONT_LACE_WIG(100,9,130),
    LACE_FRONT_WIG(120,10,130),
    FULL_LACE_WIG(180,10,130),
    GLUELESS_WIG(130,12,130),
    V_PART_WIG(75,10,130);


    private final double price;
    private final int length;
    private final int density;


    DivinesWigs(double price, int length, int density) {
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

    public double extraWigs(double wigType) {
        double total = 0.0;
        int baseLength = 20;
        int baseDensity = 150;
        double costPerInch = 5.0;
        double densityCharge = 30.0;
        double price = switch ((int) wigType) {
            case FRONT_LACE_WIG -> 100;
            case LACE_FRONT_WIG -> 120.00;
            case FULL_LACE_WIG -> 150.00;
            case GLUELESS_WIG -> 110.00;
            case V_PART_WIG -> 85.00;
            default -> throw new IllegalStateException("Unexpected value: " + (int) wigType);
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
        StringBuilder word = new StringBuilder();
        for (String s : words) {
            word.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");


        }

        return word.toString().trim();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--DIVINES WIG SECTION--\n\n");
        for (DivinesWigs w : DivinesWigs.values()) {
            String formattedName = formatEnumName(w.name());
            sb.append("Wig type: ").append(formattedName).append("\n")
                    .append("Length: ").append(w.getLength()).append("\n")
                    .append("Density :").append(w.getDensity()).append("\n")
                    .append("Price $").append(w.getPrice()).append("\n\n");
        }

        return sb.toString();
    }
}
