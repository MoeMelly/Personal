public enum LashTechs {
    JUNIOR_EXTENSION_TECH("Aaliyah","Level I", 6, 85),
    CERTIFIED_WIGS_TECH("Jayla","Level II", 1, 140),
    SENIOR_LASH_TECH("Mariah","Level III", 2, 180),
    MASTER_TECH("Rebecca","Level IV", 5, 250),
    EDUCATOR("Veronica","Masters/Trainer", 9, 350);

    private final String name;
    private final String level;
    private final int experienceRequired;
    private final int bookingPrice;


    LashTechs(String name, String level, int experienceRequired, int bookingPrice) {
        this.name = name;
        this.level = level;
        this.experienceRequired = experienceRequired;
        this.bookingPrice = bookingPrice;
    }


    public String getLevel() {
        return level;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public int getBookingPrice() {
        return bookingPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s, (%s) - $%d", level, experienceRequired, bookingPrice);
    }
    public String assignRoles() {
        if (experienceRequired > 5) {
            return "Educator/Trainer " + " " + "Artist";
        } else if (experienceRequired >= 4 ) {
            return "Master Lash Tech " + " " + "Artist";
        } else if (experienceRequired >= 3) {
            return "Senior Level Last Tech";

        } else if (experienceRequired >= 2) {
            return "Certified Level Last Tech";

        } else if (experienceRequired >= 1) {
            return "Junior Level Lash Tech";

        }
        return null;
    }
}


