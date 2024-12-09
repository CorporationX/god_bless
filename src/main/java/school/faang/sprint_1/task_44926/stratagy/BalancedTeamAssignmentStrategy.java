package school.faang.sprint_1.task_44926.stratagy;

import school.faang.sprint_1.task_44926.entity.Employee;
import school.faang.sprint_1.task_44926.entity.Project;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public Set<Employee> assignTeam(Project project, Set<Employee> employees) {
        double projectRate = getProjectRate(employees);
        return employees.stream()
                .filter(employee -> {
                    Set<String> employeeSkills = new HashSet<>(employee.getSkills());
                    employeeSkills.retainAll(project.getRequiredSkills());
                    return !employeeSkills.isEmpty();
                })
                .filter(employee -> employee.getProjects().size() <= projectRate + 1)
                .collect(Collectors.toSet());
    }

    private  double getProjectRate(Set<Employee> employees) {
        return employees.stream()
                .mapToDouble(employee -> employee.getProjects().size())
                .average()
                .orElse(0);
    }
}
