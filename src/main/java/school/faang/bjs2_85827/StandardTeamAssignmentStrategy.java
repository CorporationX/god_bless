package school.faang.bjs2_85827;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        List<Employee> team = new ArrayList<>();
        Set<String> coveredSkills = new HashSet<>();

        for (Employee e : employees) {
            Set<String> employeeSkills = e.getSkills();
            boolean hasNeededSkill = false;
            for (String skill : requiredSkills) {
                if (employeeSkills.contains(skill) && !coveredSkills.contains(skill)) {
                    hasNeededSkill = true;
                    break;
                }
            }

            if (hasNeededSkill) {
                team.add(e);

                for (String skill : employeeSkills) {
                    if (requiredSkills.contains(skill)) {
                        coveredSkills.add(skill);
                    }
                }
            }
            if (coveredSkills.containsAll(requiredSkills)) {
                break;
            }
        }
        return team;
    }
}
