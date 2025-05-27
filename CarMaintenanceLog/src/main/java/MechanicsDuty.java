import java.util.*;
import java.util.stream.Stream;

public class MechanicsDuty {
    Mechanics mechanics;
    ServiceType type;
    List<ServiceType> duty;
    List<DetailedDuties> job;

    public MechanicsDuty(Mechanics mechanics, ServiceType type, List<ServiceType> duty, List<DetailedDuties> job) {
        this.mechanics = mechanics;
        this.type = type;
        this.duty = duty;
        this.job = job;
    }

    public static void assignMechanicsDuty() {
        Map<ServiceType, List<Mechanics>> roleAssignments = new EnumMap<>(ServiceType.class);

        for (ServiceType service : ServiceType.values()) {
            List<Mechanics> qualified = Arrays.stream(Mechanics.values()).filter(m -> isQualified(m, service)).toList();
            roleAssignments.put(service, qualified);
        }

    }

    private static boolean isQualified(Mechanics m, ServiceType service) {
        int level = extractLevel(m.getLevel());

        return switch (service) {
            case OIL_CHANGE, TIRE_ROTATION, AIR_FILTER_REPLACEMENT, BRAKE_INSPECTION, COOLANT_FLUSH, BATTERY_CHECK ->
                    level >= 1;
            default -> false;
        };
    }

    private static int extractLevel(int rawlevel) {
        int i = Integer.parseInt(String.valueOf(rawlevel));
        return i;
    }

    public static void moreDuties() {
        Map<Repairs, List<Mechanics>> repairAssignments = new EnumMap<>(Repairs.class);
        Map<DiagnosticsAndCheck, List<Mechanics>> diagnosticsAndCheckListMap = new EnumMap<>(DiagnosticsAndCheck.class);
        Map<otherServices, List<Mechanics>> otherServicesListMap = new EnumMap<>(otherServices.class);

        for (Repairs r : Repairs.values()) {
            List<Mechanics> qualified = Arrays.stream(Mechanics.values()).filter(m -> isQualified(m, r)).toList();
            repairAssignments.put(r, qualified);


            for (DiagnosticsAndCheck d : DiagnosticsAndCheck.values()) {
                List<Mechanics> whoQualify = Arrays.stream(Mechanics.values()).filter(m -> isQualified(m, d)).toList();


                diagnosticsAndCheckListMap.put(d, whoQualify);


                for (otherServices o : otherServices.values()) {
                    List<Mechanics> whoCanDoIt = Arrays.stream(Mechanics.values()).filter(m -> isQualified(m, o)).toList();

                    otherServicesListMap.put(o, whoCanDoIt);
                }
            }


        }
    }

    private static boolean isQualified(Mechanics mechanics, Enum<?> task) {
        return Arrays.stream(Mechanics.values()).filter(m -> {
            int level = mechanics.getLevel();



    }
}
