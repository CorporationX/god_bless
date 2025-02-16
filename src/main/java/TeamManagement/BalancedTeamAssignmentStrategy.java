package TeamManagement;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final Logger logger = Logger.getLogger(BalancedTeamAssignmentStrategy.class.getName());

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Objects.requireNonNull(project, "Project cannot be null");
        Objects.requireNonNull(employees, "Employees list cannot be null");

        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        List<Employee> assignedEmployees = employees.stream()
                .filter(e -> !Collections.disjoint(e.getSkills(), requiredSkills))
                .sorted(Comparator.comparingInt(Employee::getAssignedProjects))
                .peek(e -> requiredSkills.removeAll(e.getSkills()))
                .collect(Collectors.toList());
        logger.info("Balanced strategy assigned team: " + assignedEmployees);
        return assignedEmployees;
    }
}