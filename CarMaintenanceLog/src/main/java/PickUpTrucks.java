import java.io.Serializable;
import java.util.StringJoiner;

public class PickUpTrucks extends Vehicle implements Serializable {
    double towingCapacity;
    boolean offRoadCapability;
    boolean openCargoBed;


    public PickUpTrucks(String type,String make, String model, String color, int year, String vin, String engine, double towingCapacity, boolean offRoadCapability, boolean openCargoBed) {
        super(type,make, model, color, year, vin, engine);
        this.towingCapacity = towingCapacity;
        this.offRoadCapability = offRoadCapability;
        this.openCargoBed = openCargoBed;
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    public boolean isOffRoadCapability() {
        return offRoadCapability;
    }

    public boolean isOpenCargoBed() {
        return openCargoBed;
    }


    @Override
    public void getVehicleDetails() {
        System.out.println(this.toString());

    }


        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(System.lineSeparator());
            joiner.add("Make: " + getMake());
            joiner.add("Model: " + getModel());
            joiner.add("Color: " + getColor());
            joiner.add("Year: " + getYear());
            joiner.add("VIN: " + getVin());
            joiner.add("Engine: " + getEngine());
            joiner.add("Towing Capacity: " + towingCapacity);
            joiner.add("Off-Road Capability: " + offRoadCapability);
            joiner.add("Open Cargo Bed: " + openCargoBed);
            return joiner.toString();
        }


    }

