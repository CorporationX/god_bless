package school.faang.task_44919;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        List<Employee> members = new ArrayList<>();
        for (Employee employee : employees) {
            if (requiredSkills.isEmpty()) {
                break;
            }
            boolean added = false;
            for (String skill : employee.getSkills()) {
                if (requiredSkills.contains(skill)) {
                    if (!added) {
                        members.add(employee);
                        employee.getProjects().add(project);
                        added = true;
                    }
                    requiredSkills.remove(skill);
                }
            }
        }
        return members;

    }
}
