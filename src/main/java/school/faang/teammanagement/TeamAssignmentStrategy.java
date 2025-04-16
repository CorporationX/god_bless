package school.faang.teammanagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface TeamAssignmentStrategy {

    default List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> requiredEmployees = new ArrayList<>();
        Set<String> coveredRequiredSkills = new HashSet<>();

        for (Employee employee : employees) {
            Set<String> intersection = new HashSet<>(employee.getSkills());
            intersection.retainAll(project.getRequiredSkills());

            if (!intersection.isEmpty()) {
                requiredEmployees.add(employee);
                coveredRequiredSkills.addAll(intersection);
            }

            if (coveredRequiredSkills.containsAll(project.getRequiredSkills())) {
                break;
            }
        }

        return requiredEmployees;
    }
}
