import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    private final String type;
    private final String make;
    private final String model;
    private final String color;
    private final int year;
    private final String vin;
    private final String engine;


    public Vehicle(String type, String make, String model, String color, int year, String vin, String engine) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.vin = vin;
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getVin() {
        return vin;
    }

    public String getEngine() {
        return engine;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %d %s %s", make, model, color, year, vin, engine);
    }

    public abstract void getVehicleDetails();
}
