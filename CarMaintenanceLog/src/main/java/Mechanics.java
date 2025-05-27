import java.util.Set;

public enum Mechanics {
    APPRENTICE_MECHANIC("John Smith", "Apprentice Mechanic", 3, Set.of(Certifications.ASE)),
    JUNIOR_TECHNICIAN("Mike Wilson", "Junior Technician", 2,Set.of(Certifications.AC_TECHNICIAN)),
    AUTOMOTIVE_TECHNICIAN("David Chen", "Automotive Technician", 4,Set.of(Certifications.EPA)),
    SENIOR_TECHNICIAN("Robert Johnson", "Senior Technician", 1,Set.of(Certifications.ELECTRICAL_SPECIALIST)),
    SHOP_FOREMAN("James Anderson", "Shop Foreman", 4,Set.of(Certifications.AC_TECHNICIAN)),
    SERVICE_MANAGER("Sarah Martinez", "Service Manager", 5,Set.of(Certifications.STATE_INSPECTOR));

    private final String name;
    private final String title;
    private final int level;
    Set<Certifications> certifications;
    Mechanics(String name, String title, int level, Set<Certifications> certifications) {
        this.name = name;
        this.title = title;
        this.level = level;
        this.certifications = certifications;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getLevel() {
        return level;
    }

    public Set<Certifications> getCertifications() {
        return certifications;
    }
}