package school.faang.project_team_management;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> staffForTheProject = new ArrayList<>();
        Set<String> skills = new HashSet<>(project.getRequiredSkills());
        for (Employee employee : employees) {
            if (skills.isEmpty()) {
                break;
            }
            if (employee.getSkills().containsAll(skills)) {
                staffForTheProject.add(employee);
                skills.removeAll(employee.getSkills());
                continue;
            }
            for (String skill : skills) {
                if (employee.getSkills().contains(skill)) {
                    staffForTheProject.add(employee);
                    skills.remove(skill);
                    break;
                }
            }
        }
        return staffForTheProject;
    }
}
