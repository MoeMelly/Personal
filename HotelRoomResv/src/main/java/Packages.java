import java.util.Set;

public enum Packages {
    STANDARD("Standard - General guest with no loyalty status. Access to base-level hotel services with standard rates and policies.", Set.of()),
    SILVER("Silver - Entry-level loyalty status, typically earned after a few stays or nights. Includes basic benefits such as late checkout, priority check-in, and complimentary Wi-Fi when available.", Set.of(STANDARD)),
    GOLD("Gold - Mid-tier loyalty status earned through significant stay volume. Includes guaranteed room avaliablity, complimentary premium upgrades, early check-in, late checkout, and welcome gifts or amenities.", Set.of(STANDARD, SILVER)),
    PLATINUM("Platinum - High tier loyalty level achieved through significant stay volume. Includes guaranteed room availability, complimentary premium upgrades, early check-in, late checkout, and access to exclusive member support.", Set.of(STANDARD, SILVER, GOLD)),
    DIAMOND("Diamond - Elite loyalty status reserved for top-tier travelers. Includes suite upgrades (when available), executive lounge access, premium internet, 48-hour guaranteed availability, and welcome gifts or amenities.", Set.of(STANDARD, SILVER, GOLD, PLATINUM)),
    ELITE("Elite - Invitation-only status for ultra-high-value guests such as celebrities, dignitaries, or VIP clients. Includes full-service personalization, dedicated concierge, highest-level room upgrades (including presidential suites), and elevated privacy and discretion protocols. ", Set.of(STANDARD, SILVER, GOLD, PLATINUM, DIAMOND));

    private Set<Packages> tierLevel;
    private final String description;
    
    Packages(String description, Set<Packages> tierLevel) {
        this.tierLevel = tierLevel;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Package{" +
                "tierLevel=" + tierLevel +
                ", description='" + description + '\'' +
                '}';
    }
}