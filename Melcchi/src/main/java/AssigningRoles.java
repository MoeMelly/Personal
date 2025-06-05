import java.util.*;

public class AssigningRoles {
    List<LashTechs> techs = new ArrayList<>();

    public AssigningRoles(List<LashTechs> techs) {
        this.techs = techs;
    }

    public List<LashTechs> getTechs() {
        return techs;
    }
    public List<LashTechs> techAssign(int experienceRequired) {
       List<LashTechs> qualified = new ArrayList<>();
       for (LashTechs techs1 : LashTechs.values()) {
           if (techs1.getExperienceRequired() >= experienceRequired) {
               qualified.add(techs1);
           }
       }
        return qualified;
    }
}
