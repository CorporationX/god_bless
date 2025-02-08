package school.faang.projectmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> team = new ArrayList<>();
        Set<String> requiredSkills = project.getRequiredSkills();
        for (Employee employee : employees) {
            Set<String> employeeSkills = employee.getSkills();
            for (String skill : employeeSkills) {
                if (requiredSkills.contains(skill)) {
                    requiredSkills.remove(skill);
                    team.add(employee);
                }
            }
        }
        if (requiredSkills.isEmpty()) {
            return team;
        } else {
            System.out.println("Этими сотрудниками не удалось покрыть все навыки");
            return List.of();
        }
    }
}
