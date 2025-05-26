import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MotorcycleRegistry {
    private final List<Motorcycles> motorcycles;


    public MotorcycleRegistry(List<Motorcycles> motorcycles) {
        this.motorcycles = new ArrayList<>(motorcycles);
    }

    public static void motorcycleRegistry() {
        List<Motorcycles> motorcycles1 = new ArrayList<>();
        motorcycles1.add(new Motorcycles("Motorcycle", "Honda", "CBR500R", "Red", 2022, "VIN00000000000001", "471cc parallel-twin", 471, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Yamaha", "YZF-R3", "Blue", 2021, "VIN00000000000002", "321cc twin-cylinder", 321, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Suzuki", "GSX250R", "Black", 2020, "VIN00000000000003", "248cc parallel-twin", 248, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Kawasaki", "Ninja 400", "Green", 2023, "VIN00000000000004", "399cc parallel-twin", 399, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Ducati", "Monster 821", "White", 2024, "VIN00000000000005", "821cc L-Twin", 821, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "BMW", "G310R", "Black", 2021, "VIN00000000000006", "313cc single-cylinder", 313, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "KTM", "Duke 390", "Orange", 2022, "VIN00000000000007", "373cc single-cylinder", 373, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Triumph", "Street Triple", "Silver", 2023, "VIN00000000000008", "765cc triple-cylinder", 765, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Harley-Davidson", "Iron 883", "Black", 2020, "VIN00000000000009", "883cc V-Twin", 883, "Air-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Aprilia", "RS 660", "Red", 2021, "VIN00000000000010", "659cc parallel-twin", 659, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Honda", "CB500F", "Blue", 2022, "VIN00000000000011", "471cc parallel-twin", 471, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Yamaha", "MT-03", "Black", 2023, "VIN00000000000012", "321cc twin-cylinder", 321, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Suzuki", "SV650", "White", 2020, "VIN00000000000013", "645cc V-Twin", 645, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Kawasaki", "Z650", "Green", 2021, "VIN00000000000014", "649cc parallel-twin", 649, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Ducati", "Panigale V2", "Red", 2022, "VIN00000000000015", "955cc L-Twin", 955, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "BMW", "S1000RR", "Blue", 2023, "VIN00000000000016", "999cc inline-four", 999, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "KTM", "RC 390", "Orange", 2020, "VIN00000000000017", "373cc single-cylinder", 373, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Triumph", "Bonneville T100", "Silver", 2021, "VIN00000000000018", "900cc parallel-twin", 900, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Harley-Davidson", "Street 750", "Black", 2022, "VIN00000000000019", "749cc V-Twin", 749, "Liquid-cooled"));
        motorcycles1.add(new Motorcycles("Motorcycle", "Aprilia", "Tuono 660", "Red", 2023, "VIN00000000000020", "659cc parallel-twin", 659, "Liquid-cooled"));


        for (Motorcycles m : motorcycles1) {
            m.getVehicleDetails();

        }

    }

    public boolean addVehicle(Motorcycles m) {
        if (motorcycles == null) {
            return false;
        }
        if (motorcycles.contains(m)) {
            return false;
        }
        return motorcycles.add(m);
    }

    public boolean removeVehicle(Motorcycles m) {
        return motorcycles.remove(m);
    }

    public List<Motorcycles> getMotorcyclesByMakeAndModel(String make, String model) {
        if (motorcycles.isEmpty()) {
            return Collections.emptyList();
        }

        return motorcycles.stream().filter(m -> m.getMake().equalsIgnoreCase(make) && m.getModel().equalsIgnoreCase(model)).collect(Collectors.toList());
    }

    public void printMotorCyclesByEngineType() {
        Map<String, List<Motorcycles>> engineType = motorcycles.stream().collect(Collectors.groupingBy(Motorcycles::getEngine));

        for (Map.Entry<String, List<Motorcycles>> entry : engineType.entrySet()) {
            String engine = entry.getKey();
            List<Motorcycles> bikes = entry.getValue();
            System.out.println("\nEngine Types: " + engine);
            bikes.forEach(bike -> System.out.println("- " + bike.getMake() + " " + bike.getModel()));


        }
    }
}

