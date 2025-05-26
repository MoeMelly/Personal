public enum Mechanics {
    Apprentice_Mechanic("Apprentice Mechanic", "Level 1"),
    Junior_Technician("Junior Technician", "Level 2"),
    Automotive_Technician("Automotive Technician", "Level 3"),
    Senior_Technician("Senior Technician", "Level 4"),
    Shop_Foreman("Shop Foreman", "Level 5"),
    Service_Manager("Service Manager", "Level 6");



    private final String role;
    private final String level;


    Mechanics(String role, String level) {
        this.role = role;
        this.level = level;
    }

    public String getRole() {
       return role;
   }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return role + " - " + level;

    }
}
