package school.faang.project_team_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final int MAX_PROJECT = 2;
    private final Map<Employee, Integer> employeeMap = new HashMap<>();

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> staffForTheProject = new ArrayList<>();
        Set<String> skills = new HashSet<>(project.getRequiredSkills());
        for (Employee employee : employees) {
            if (skills.isEmpty()) {
                break;
            }
            int countProject = employeeMap.getOrDefault(employee, 0);
            if (countProject >= MAX_PROJECT) {
                continue;
            }
            if (employee.getSkills().containsAll(skills)) {
                staffForTheProject.add(employee);
                skills.removeAll(employee.getSkills());
                employeeMap.put(employee, ++countProject);
                continue;
            }
            for (String skill : skills) {
                if (employee.getSkills().contains(skill)) {
                    staffForTheProject.add(employee);
                    skills.remove(skill);
                    employeeMap.put(employee, ++countProject);
                    break;
                }
            }
        }
        return staffForTheProject;
    }
}