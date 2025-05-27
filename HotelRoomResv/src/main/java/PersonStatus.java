import java.lang.Package;
import java.util.Set;

public enum PersonStatus {
    REGULAR(Set.of(Packages.STANDARD)),
    VIP(Set.of(Packages.SILVER)),
    CELEBRITY(Set.of(Packages.GOLD)),
    WEALTHY(Set.of(Packages.PLATINUM)),
    INFLUENCER(Set.of(Packages.DIAMOND)),
    COPORATE_CLIENT(Set.of(Packages.STANDARD, Packages.SILVER)),
    ROYALTY(Set.of(Packages.GOLD, Packages.PLATINUM)),
    LOYALTY_MEMBER(Set.of(Packages.DIAMOND));

    private Set<Packages> tier;

    PersonStatus(Set<Packages> tier) {
        this.tier = tier;
    }

    private Set<Package> tiers;


    public Set<Packages> getTier() {
        return tier;
    }



    @Override
    public String toString() {
        return "PersonStatus{" +
                ", tier=" + tier +
                "} " + super.toString();
    }
}