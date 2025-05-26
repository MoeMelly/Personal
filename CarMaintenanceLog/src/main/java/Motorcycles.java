import java.io.Serializable;

public class Motorcycles extends Vehicle implements Serializable {
    int engineCC;
    String coolingMethod;


    public Motorcycles(String type, String make, String model, String color, int year, String vin, String engine, int engineCC, String coolingMethod) {
        super(type, make, model, color, year, vin, engine);
       this.engineCC = engineCC;
        this.coolingMethod = coolingMethod;
    }


    @Override
    public void getVehicleDetails() {
        System.out.println(this.toString());


    }

    public String getCoolingMethod() {
        return coolingMethod;
    }

    public int getEngineCC() {
        return engineCC;
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Make: %s, Model: %s, Color: %s, Year: %d, VIN: %s, Engine: %s, Engine CC: %d, Cooling Method: %s",
                getType(), getMake(), getModel(), getColor(), getYear(), getVin(), getEngine(), engineCC, coolingMethod
        );
    }


}
