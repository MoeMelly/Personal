import java.io.Serializable;

public enum ServiceType implements Serializable, Comparable<ServiceType> {
    OIL_CHANGE("Replace engine oil and filter", 30, 50.00),
    TIRE_ROTATION("Rotate all four tires", 20, 25.00),
    AIR_FILTER_REPLACEMENT("Replace engine air intake", 15, 30.00),
    BRAKE_INSPECTION("Check brake pads, Rotors and fluids", 30, 40.00),
    BATTERY_CHECK("Test battery health,Check terminal condition", 10, 15.99),
    COOLANT_FLUSH("Flush and replace engine", 60, 110.99);


    private final String description;
    private final int estimatedTime;
    private final double baseCost;

    ServiceType(String description, int estimatedTime, double baseCost) {
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.baseCost = baseCost;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public double getBaseCost() {
        return baseCost;
    }


    @Override
    public String toString() {
        return String.format("%s: %s | Time: %d mins | Cost: $%.2f", name().replace('_', ' '), description, estimatedTime, baseCost);
    }


}


enum Repairs {
    BRAKE_REPLACEMENT("Replace brake pads and resurface rotors", 90, 249.99),
    ENGINE_REPAIR("Diagnose and repair engine issues", 240, 689.73),
    TRANSMISSION_SERVICE("Drain and replace transmission fluid/filter", 120, 290.99),
    SUSPENSION_REPAIR("Inspect and replace suspension components", 180, 404.99),
    EXHAUST_REPAIR("Repair or replace exhaust/muffler", 90, 150.99);


    private final String description;
    private final int estimatedTime;
    private final double baseCost;

    Repairs(String description, int estimatedTime, double baseCost) {
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.baseCost = baseCost;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public double getBaseCost() {
        return baseCost;
    }

    @Override
    public String toString() {
        return String.format("%s: %s | Time: %d mins | Cost: $%.2f", name().replace('_', ' '), description, estimatedTime, baseCost);

    }
}

enum DiagnosticsAndCheck {
    ENGINE_DIAGNOSTIC("Run computer diagnostics on engine", 45, 75.99), CHECK_ENGINE_LIGHT("Scan error codes from ECU", 15, 40.98), ELECTRICAL_SYSTEM_CHECK("Diagnose electrical issues", 60, 100.64), AC_SYSTEM_DIAGNOSTIC("Check refrigerant,leaks,and cooling level", 60, 80.99);

    private final String description;
    private final int estimatedTime;
    private final double baseCost;

    DiagnosticsAndCheck(String description, int estimatedTime, double baseCost) {
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.baseCost = baseCost;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public double getBaseCost() {
        return baseCost;
    }


}


enum otherServices {
    WHEEL_ALIGNMENT("Align wheels for even tire wear", 45, 89.99), TIRE_REPLACEMENT("Replace old or damaged tires", 60, 120.00), WINDSHIELD_WIPER_REPLACEMENT("Install new wiper blades", 10, 25.00), LIGHT_BULB_REPLACEMENT("Replaces headlight or taillights bulbs", 15, 19.99), STATE_INSPECTION("Preforms required vehicle inspection", 30, 35.00), EMISSIONS_TEST("Tests vehicle emissions system compliance", 20, 29.99);

    private final String description;
    private final int estimatedTime;
    private final double baseCost;


    otherServices(String description, int estimatedTime, double baseCost) {
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.baseCost = baseCost;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public double getBaseCost() {
        return baseCost;
    }


    public String toString() {
        return String.format("%s: %s | Time: %d mins | Cost: $%.2f", name().replace('_', ' '), description, estimatedTime, baseCost);
    }
}