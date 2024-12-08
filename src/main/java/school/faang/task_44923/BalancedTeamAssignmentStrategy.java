package school.faang.task_44923;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final int MAX_PROJECTS_PER_EMPLOYEE = 3;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> assignedTeam = new ArrayList<>();
        Map<Employee, Integer> projectCount = new HashMap<>();

        for (Employee employee : employees) {
            int count = projectCount.getOrDefault(employee, 0);
            boolean hasRequiredSkill = false;

            for (String skill : employee.skills()) {
                if (project.requiredSkills().contains(skill)) {
                    hasRequiredSkill = true;
                    break;
                }
            }

            if (count < MAX_PROJECTS_PER_EMPLOYEE && hasRequiredSkill) {
                assignedTeam.add(employee);
                projectCount.put(employee, count + 1);
            }
        }
        return assignedTeam;
    }

}
