public enum DivinesExtensions {
    CLIP_IN_EXTENSIONS(50, "Easy,reusable, and beginner-friendly for instant volume/length.", true),
    TAPE_IN_EXTENSIONS(180, "Natural-looking, flat laying,semi-permanent.", true),
    SEW_IN(450, "Long lasting and secure,best for thick/coarse hair.", true),
    HALO_EXTENSIONS(120, "Wire-based,no damage,and super quick to put on or take off.", true);


    private final double price;
    private final String descriptions;
    private final boolean isHuman;

    private static String formatEnum(String enumName) {
        String[] words = enumName.split("_");
        StringBuilder sb = new StringBuilder();
        for (String b : words) {
            sb.append(Character.toUpperCase(b.charAt(0))).append(sb.substring(1).toLowerCase()).append(" ");
        }
        return sb.toString().trim();
    }

    DivinesExtensions(double price, String descriptions, boolean isHuman) {
        this.price = price;
        this.descriptions = descriptions;
        this.isHuman = isHuman;
    }

    public double getPrice() {
        return price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isHuman() {
        return isHuman;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("---DIVINES EXTENSIONS--\n");
        for (DivinesExtensions extensions : DivinesExtensions.values()) {
            String formattedName = formatEnum(extensions.name());
            builder.append("Extension Type: ").append(formattedName).append("\n")
                    .append("Price $").append(extensions.getPrice()).append("\n")
                    .append("Description: ").append(extensions.getDescriptions()).append("\n\n");
        }
        builder.append("--HAIR TYPES--\n");
        for (hairTypes types : hairTypes.values()) {
            String formattedName = formatEnum(types.name());
            builder.append("Choosen extension Types: ").append(formattedName).append("\n");
            builder.append("Price $").append(types.getPrice()).append("\n\n");
        }
        return builder.toString();
    }

    public double basePrice(DivinesExtensions extensions, double tax, hairTypes selectedHairType) {
        double salesTax = getPrice() + (getPrice() + 5.80);
        double price = switch (extensions) {
            case CLIP_IN_EXTENSIONS -> 50.00;
            case TAPE_IN_EXTENSIONS -> 180.00;
            case SEW_IN -> 450.00;
            case HALO_EXTENSIONS -> 120.00;
            default -> 0.0;



        };
        return price + selectedHairType.getPrice();
    }

    enum hairTypes {
        REMY(50.75),
        VIRGIN_REMY(84.87),
        HUMAN(30.65),
        SYNTHETIC(0.0),
        RAW_HAIR(100.00);


        private final double price;

        hairTypes(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public double selectedHairTypes(hairTypes types, double tax) {
            double pricing = switch (types) {
                case REMY -> 50.75;
                case HUMAN -> 30.65;
                case RAW_HAIR -> 100.00;
                case VIRGIN_REMY -> 84.87;
                case SYNTHETIC -> 0.0;
            };
            return pricing;
        }

    }
}
