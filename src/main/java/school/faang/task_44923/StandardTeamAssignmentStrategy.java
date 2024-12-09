package school.faang.task_44923;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> assignedTeam = new ArrayList<>();
        Set<String> requiredSkills = new HashSet<>(project.requiredSkills());

        for (Employee employee : employees) {
            Set<String> employeeSkills = new HashSet<>(employee.skills());
            employeeSkills.retainAll(requiredSkills);
            if (!employeeSkills.isEmpty()) {
                assignedTeam.add(employee);
                requiredSkills.removeAll(employeeSkills);
            }
            if (requiredSkills.isEmpty()) {
                break;
            }
        }
        return assignedTeam;
    }

}
