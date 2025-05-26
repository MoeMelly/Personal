import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleRegistry implements Serializable {
    List<Vehicle> vehicles;


    public VehicleRegistry(List<VehicleRegistry> vehicles) {
        this.vehicles = new ArrayList<>();
    }

    public static void vehicleRegistries() {
        List<SportsCar> vehicleRegistries = new ArrayList<>();
        vehicleRegistries.add(new SportsCar("Convertible", "Mazda", "MX-5 Miata", "Soul Red", 2024, "VIN001", "2.0L Inline-4, 181 hp", "Michelin Pilot Sport 4", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Toyota", "GR Supra", "Nitro Yellow", 2025, "VIN002", "3.0L Turbocharged Inline-6, 382 hp", "Bridgestone Potenza S007", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Nissan", "Z", "Passion Red", 2023, "VIN003", "3.0L Twin-Turbo V6, 400 hp", "Dunlop SP Sport Maxx GT600", 2));
        vehicleRegistries.add(new SportsCar("Supercar", "Chevrolet", "Corvette Z06", "Arctic White", 2023, "VIN004", "5.5L Naturally Aspirated V8, 670 hp", "Michelin Pilot Sport Cup 2", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Ford", "Mustang GT", "Grabber Blue", 2024, "VIN005", "5.0L V8, 450 hp", "Pirelli P Zero", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "BMW", "M4 Coupe", "San Marino Blue", 2025, "VIN006", "3.0L Twin-Turbo Inline-6, 503 hp", "Michelin Pilot Sport 4S", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Audi", "TT RS", "Glacier White", 2022, "VIN007", "2.5L Turbocharged Inline-5, 394 hp", "Continental SportContact 6", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Porsche", "911 Carrera", "Guards Red", 2024, "VIN008", "3.0L Twin-Turbo Flat-6, 379 hp", "Pirelli P Zero", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Jaguar", "F-Type R", "British Racing Green", 2023, "VIN009", "5.0L Supercharged V8, 575 hp", "Pirelli P Zero", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Lexus", "RC F", "Infrared", 2024, "VIN010", "5.0L V8, 472 hp", "Michelin Pilot Super Sport", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Mercedes-Benz", "AMG C63 Coupe", "Obsidian Black", 2025, "VIN011", "4.0L Twin-Turbo V8, 503 hp", "Michelin Pilot Sport 4S", 2));
        vehicleRegistries.add(new SportsCar("Convertible", "Alfa Romeo", "4C Spider", "Rosso Competizione", 2020, "VIN012", "1.7L Turbocharged Inline-4, 237 hp", "Pirelli P Zero", 2));
        vehicleRegistries.add(new SportsCar("Coupe", "Lotus", "Evora GT", "Solar Yellow", 2021, "VIN013", "3.5L Supercharged V6, 416 hp", "Michelin Pilot Sport Cup 2", 2));
        vehicleRegistries.add(new SportsCar("Supercar", "Aston Martin", "Vantage", "Magnetic Silver", 2025, "VIN014", "4.0L Twin-Turbo V8, 503 hp", "Pirelli P Zero", 2));
        vehicleRegistries.add(new SportsCar("Supercar", "McLaren", "Artura", "McLaren Orange", 2024, "VIN015", "3.0L Twin-Turbo V6 Hybrid, 671 hp", "Pirelli P Zero", 2));



        for (SportsCar car : vehicleRegistries) {
            System.out.println(car);
        }
    }

    public boolean addVehicles(Vehicle v) {

        if (vehicles == null) {
            return false;
        }
        if (vehicles.contains(v)) {
            return false;
        }

        return vehicles.add(v);
    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(vehicle -> vehicle.getVin().equals(vin));
    }

    public List<Vehicle> vehicleRegistryList(int year, String type) {
        if (vehicles.isEmpty()) {
            return Collections.emptyList();
        }
        return vehicles.stream()
                .filter(vehicle -> vehicle.getYear() > year)
                .filter(vehicle -> vehicle.getType().equalsIgnoreCase(type))
                .sorted(Comparator.comparing(Vehicle::getMake))
                .toList();
    }

    public static void printVehicleRegistryByCategory(List<Vehicle> vehicles) {
        List<String> types = Arrays.asList("coupe", "convertible", "supercar");
        
        for (String category : types) {
            System.out.println("\n" + category + " vehicles:");
            vehicles.stream()
                    .filter(vehicle -> vehicle.getType().equalsIgnoreCase(category))
                    .forEach(System.out::println);
        }


    }
}