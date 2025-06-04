public enum DivinesLashes {
    MINK_LASHES(23, "Premium cruelty-free mink lashes with a natural fluff finish."),
    NATURAL_DAILY_LASHES(11, "Lightweight and subtle lashes perfect for everyday use. "),
    FAUX_MINK_LASHES(10, "Vegan-friendly lashes that give a dramatic, mink-like effect without animal hair."),
    LASH_BUNDLES(26, "Value packs that offer variety! Choose your bundle-natural, glam, or mixed styles."),
    LASH_SERUM(30, "Nourishing lash serum designed to stimulate growth and strengthen natural lashes."),
    LASH_APPLICATOR_TOOL(7, "Stainless steel lash applicator to make placement precise and easy!");


    private final double price;
    private final String description;

    DivinesLashes(double price, String description) {
        this.price = price;
        this.description = description;
    }

    public static String formatEnumName(String enumName) {
        String[] words = enumName.split("_");
        StringBuilder word = new StringBuilder();
        for (String s : words) {
            word.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");



        }

        return word.toString().trim();
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double calculatePriceExtraPrice(boolean extra, double tax) {
        double taxes = getPrice()+(getPrice() * 3.60);
       double price = extra ? 1.5 : 0;
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--DIVINE LASH COLLECTION--\n\n");
        for (DivinesLashes store : DivinesLashes.values()) {
            String formattedName = formatEnumName(store.name());
            sb.append("Product: ").append(formattedName).append("\n")
                    .append("Price $").append(store.getPrice()).append("\n")
                    .append("Description: ").append(store.getDescription()).append("\n\n");
        }
        return sb.toString();
    }

}


