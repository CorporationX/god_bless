package school.faang.BJS2_68773;

import java.util.Collections;
import java.util.Set;

public class SkillUtils {
    public static boolean hasCommonSkills(Set<Skill> requiredProjectSkills, Set<Skill> employeeSkills) {
        return !Collections.disjoint(requiredProjectSkills, employeeSkills);
    }

    public static void subtractSkillsCoveredBy(Employee employee, Set<Skill> projectRequiredSkills) {
        projectRequiredSkills.removeAll(employee.getSkills());
    }
}
