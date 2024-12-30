package school.faang.task_45005.strategies;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.project.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> requiredSkills = project.getRequiredSkills();

        Set<String> remainingSkills = new HashSet<>(requiredSkills);

        List<Employee> assignedEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            Set<String> intersection = new HashSet<>(employee.getSkills());
            intersection.retainAll(remainingSkills);

            if (!intersection.isEmpty()) {
                assignedEmployees.add(employee);

                remainingSkills.removeAll(intersection);
            }

            if (remainingSkills.isEmpty()) {
                return assignedEmployees;
            }
        }

        return List.of();
    }
}