package school.faang.projectmanagement.strategy;

import school.faang.projectmanagement.Employee;
import school.faang.projectmanagement.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final int MAX_PROJECTS_PER_EMPLOYEE = 2;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> assignedTeam = new ArrayList<>();
        Map<Employee, Integer> projectCount = new HashMap<>();
        for (Employee employee : employees) {
            int count = projectCount.getOrDefault(employee, 0);
            boolean hasRequiredSkill = false;
            for (String skill : employee.getSkills()) {
                if (project.getRequiredSkills().contains(skill)) {
                    hasRequiredSkill = true;
                    break;
                }
            }
            if (count < MAX_PROJECTS_PER_EMPLOYEE && hasRequiredSkill) {
                assignedTeam.add(employee);
                projectCount.put(employee, count + 1);
            }
        }
        project.setTeamMembers(assignedTeam);
        return assignedTeam;
    }
}