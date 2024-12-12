package school.faang.bjs244933;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(@NonNull Project project, @NonNull List<Employee> employees) {

        List<Employee> employeesTeamStandard = new ArrayList<>();
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());

        for (Employee employee : employees) {

            Set<String> employeeSkills = new HashSet<>(employee.getSkills());
            employeeSkills.retainAll(requiredSkills);

            if (!employeeSkills.isEmpty()) {
                employeesTeamStandard.add(employee);
                requiredSkills.removeAll(employeeSkills);
            }
            if (requiredSkills.isEmpty()) {
                break;
            }
        }
        return employeesTeamStandard;
    }
}
