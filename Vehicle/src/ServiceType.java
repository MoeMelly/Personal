public enum ServiceType {
    OIL_CHANGE("Oil Change", 65.00, 30, MechanicSkillLevel.JUNIOR),
    TIRE_ROTATION("Tire Rotation", 60.00, 45, MechanicSkillLevel.JUNIOR),
    BATTERY_REPLACEMENT("Battery Replacement", 120.00, 60, MechanicSkillLevel.INTERMEDIATE),
    BRAKE_INSPECTION("Brake Inspection", 80.00, 45, MechanicSkillLevel.JUNIOR),
    ENGINE_REPAIR("Engine Repair", 750.00, 240, MechanicSkillLevel.MASTER),
    FLUID_CHECKS("Fluid Checks", 50.00, 30, MechanicSkillLevel.JUNIOR),
    WHEEL_ALIGNMENT("Wheel Alignment", 90.00, 60, MechanicSkillLevel.INTERMEDIATE),
    AIR_FILTER_REPLACEMENT("Air Filter Replacement", 40.00, 20, MechanicSkillLevel.JUNIOR),
    CABIN_AIR_FILTER_REPLACEMENT("Cabin Air Filter Replacement", 45.00, 25, MechanicSkillLevel.JUNIOR),
    SPARK_PLUG_REPLACEMENT("Spark Plug Replacement", 110.00, 60, MechanicSkillLevel.INTERMEDIATE);


    private final String displayName;
    private final double basePrice;
    private final int estimatedMinutes;
    private final MechanicSkillLevel requiredSkillLevel;


    ServiceType(String displayName, double basePrice, int estimatedMinutes, MechanicSkillLevel requiredSkillLevel) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.estimatedMinutes = estimatedMinutes;
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public MechanicSkillLevel getRequiredSkillLevel() {
        return requiredSkillLevel;
    }




}
