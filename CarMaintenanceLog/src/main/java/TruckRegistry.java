import java.util.*;
import java.util.stream.Collectors;

public class TruckRegistry {

    private final List<PickUpTrucks> trucks;

    public TruckRegistry(List<PickUpTrucks> trucks) {
        this.trucks = new ArrayList<>(trucks);
    }


    public boolean addVehicle(PickUpTrucks truck) {
        return trucks.add(truck);
    }


    public boolean removeVehicle(PickUpTrucks truck) {
        return trucks.remove(truck);
    }

    public List<PickUpTrucks> getTrucksByMakeAndModel(String make, String model) {
        if (trucks.isEmpty()) {
            return Collections.emptyList();
        }

        return trucks.stream()
                .filter(t -> t.getMake().equalsIgnoreCase(make) && t.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }


    public void printTrucksByCategory() {
        Map<String, List<PickUpTrucks>> trucksByType = new HashMap<>();

        for (PickUpTrucks truck : trucks) {
            String type = truck.getType();
            trucksByType.computeIfAbsent(type, k -> new ArrayList<>()).add(truck);
        }

        for (Map.Entry<String, List<PickUpTrucks>> entry : trucksByType.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (PickUpTrucks t : entry.getValue()) {
                System.out.println(t);
            }
            System.out.println();
        }


    }

    public static Map<String, List<PickUpTrucks>> printTrucksByMake(List<PickUpTrucks> trucks) {
        Map<String, List<PickUpTrucks>> map = new HashMap<>();

        for (PickUpTrucks pickUpTrucks : trucks) {
            String make = pickUpTrucks.getMake();
            map.computeIfAbsent(make, k -> new ArrayList<>())
                    .add(pickUpTrucks);



        }
        return map;
    }

    public static void printFilteredMakes(Map<String, List<PickUpTrucks>> map, List<String> makesToFilter) {
        for (String make : makesToFilter) {
            if (map.containsKey(make)) {
                System.out.println("Make: " + make);
                for (PickUpTrucks truck : map.get(make))
                    System.out.println(" " + truck);

            } else {
                System.out.println("no trucks found for make: " + make);
            }
        }
    }











    public void populateSampleTrucks() {
        List<PickUpTrucks> truck = new ArrayList<>();
        trucks.add(new PickUpTrucks("Pickup", "Dodge", "Ram 1500", "Red", 2021, "1C6RR7KT0MS500001", "V6", 7200.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Ford", "F-150", "Blue", 2022, "1FTFW1E50NFA00002", "V8", 7500.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Chevrolet", "Silverado", "Black", 2023, "3GCUYDEDXPG100003", "V8", 7600.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Toyota", "Tundra", "White", 2024, "5TFDY5F14RX100004", "V6", 7300.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Nissan", "Titan", "Gray", 2025, "1N6AA1E56PN100005", "V8", 7400.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "GMC", "Sierra", "Red", 2021, "1GTU9DED1MZ100006", "V8", 7500.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Honda", "Ridgeline", "Blue", 2022, "5FPYK3F70NB100007", "V6", 5000.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Ford", "Ranger", "Black", 2023, "1FTER4FH0P1000008", "V6", 7000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Chevrolet", "Colorado", "White", 2024, "1GCGTDEN5R1000009", "V6", 7000.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Ram", "2500", "Gray", 2025, "3C6UR5DLXMG100010", "V8", 8000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Toyota", "Tacoma", "Red", 2021, "3TMCZ5AN8MM100011", "V6", 6800.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Nissan", "Frontier", "Blue", 2022, "1N6ED1EK8NN100012", "V6", 6700.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "GMC", "Canyon", "Black", 2023, "1GTG6FEN0P1000013", "V6", 7000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Honda", "Ridgeline", "White", 2024, "5FPYK3F70RB100014", "V6", 5000.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Ford", "F-250", "Gray", 2025, "1FT7W2BT5NE100015", "V8", 8000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Chevrolet", "Silverado HD", "Red", 2021, "1GC4YUEY1MF100016", "V8", 8500.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Ram", "3500", "Blue", 2022, "3C63RRJLXNG100017", "V8", 9000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Toyota", "Tundra", "Black", 2023, "5TFAY5F18PX100018", "V6", 7300.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Nissan", "Titan XD", "White", 2024, "1N6AA1F49RN100019", "V8", 7800.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "GMC", "Sierra HD", "Gray", 2025, "1GT49UEY5MF100020", "V8", 8500.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Honda", "Ridgeline", "Red", 2021, "5FPYK3F70MB100021", "V6", 5000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Ford", "F-350", "Blue", 2022, "1FT8W3BT5NE100022", "V8", 9000.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Chevrolet", "Colorado ZR2", "Black", 2023, "1GCGTEEN5P1000023", "V6", 7000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Ram", "1500 Rebel", "White", 2024, "1C6SRFLT4RN100024", "V8", 7500.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Toyota", "Tacoma TRD", "Gray", 2025, "3TMCZ5AN9SM100025", "V6", 6800.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Nissan", "Frontier PRO-4X", "Red", 2021, "1N6ED1EK9MN100026", "V6", 6700.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "GMC", "Canyon AT4", "Blue", 2022, "1GTG6FEN1N1100027", "V6", 7000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Honda", "Ridgeline RTL-E", "Black", 2023, "5FPYK3F70PB100028", "V6", 5000.0, false, true));
        trucks.add(new PickUpTrucks("Pickup", "Ford", "Ranger FX4", "White", 2024, "1FTER4FH1R1000029", "V6", 7000.0, true, true));
        trucks.add(new PickUpTrucks("Pickup", "Chevrolet", "Silverado Trail Boss", "Gray", 2025, "1GCUYDED5SG100030", "V8", 7600.0, false, true));
    }


    public void printAllTrucks() {
        for (PickUpTrucks truck : trucks) {
            System.out.println(truck);
        }
    }
}



