import java.io.Serializable;

public class SportsCar extends Vehicle implements Serializable {
    String type;
    String tireType;
    int numberOfDoors;


    public SportsCar(String type,String make, String model, String color, int year, String vin, String engine,String tireType, int numberOfDoors) {
        super(type,make, model, color, year, vin, engine);
        this.tireType = tireType;
        this.numberOfDoors = 2;
        this.type = type;


    }

    public String getTireType() {
        return tireType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    public String getType() {
        return type;
    }

    @Override
    public void getVehicleDetails() {

        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s%n" +
                "Make: %s%n" +
                        "Model: %s%n" +
                        "Color: %s%n" +
                        "Year: %d%n" +
                        "VIN: %s%n" +
                        "Engine: %s%n" +
                        "Tire Type: %s%n" +
                        "Number of Doors: %d",
                getType(),
                getMake(),
                getModel(),
                getColor(),
                getYear(),
                getVin(),
                getEngine(),
                tireType,
                numberOfDoors
        );
    }


}
