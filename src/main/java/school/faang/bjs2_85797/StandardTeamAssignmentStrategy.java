package school.faang.bjs2_85797;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> needSkills = new HashSet<>(project.getRequiredSkills());
        List<Employee> standartTeam = new ArrayList<>();

        for (Employee e : employees) {
            boolean hasNeedSkill = false;
            for (String skill : e.getSkills()) {
                if (needSkills.contains(skill)) {
                    hasNeedSkill = true;
                    break;
                }
            }

            if (hasNeedSkill) {
                e.incrementCountProjects();
                standartTeam.add(e);
                needSkills.removeAll(e.getSkills());
                if (needSkills.isEmpty()) {
                    break;
                }
            }
        }
        return standartTeam;
    }

    @Override
    public String toString() {
        return "StandardTeamAssignmentStrategy";
    }
}
