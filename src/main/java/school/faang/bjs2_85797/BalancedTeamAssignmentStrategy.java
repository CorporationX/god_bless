package school.faang.bjs2_85797;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> needSkills = new HashSet<>(project.getRequiredSkills());
        List<Employee> balancedTeam = new ArrayList<>();
        List<Employee> freeEmployees = new ArrayList<>();

        for (Employee e : employees) {
            if (e.getProjectCount() < 1) {
                freeEmployees.add(e);
            }
        }

        for (Employee e : freeEmployees) {
            boolean hasNeedSkill = false;
            for (String skill : e.getSkills()) {
                if (needSkills.contains(skill)) {
                    hasNeedSkill = true;
                    break;
                }
            }

            if (hasNeedSkill) {
                e.incrementCountProjects();
                balancedTeam.add(e);
                needSkills.removeAll(e.getSkills());
            }
        }
        return balancedTeam;
    }

    @Override
    public String toString() {
        return "BalancedTeamAssignmentStrategy";
    }
}
