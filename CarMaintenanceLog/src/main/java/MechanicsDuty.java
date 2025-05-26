import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void assignMechanicsDuty() {}
   Map<ServiceType, List<Mechanics>> roleAssignments = new HashMap<>();

    List<Mechanics> qualifiedForOilChange = Arrays.stream(Mechanics.values())
            .filter(m -> Integer.parseInt(m.getLevel().replace("Level 1 ", "")) >= 2)
            .toList();
    




}
