import java.util.Collections;
import java.util.logging.Logger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final Logger logger = Logger.getLogger(StandardTeamAssignmentStrategy.class.getName());

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> remainingSkills = new HashSet<>(project.getRequiredSkills());
        List<Employee> assignedEmployees = employees.stream()
                .filter(e -> !Collections.disjoint(e.getSkills(), remainingSkills))
                .peek(e -> remainingSkills.removeAll(e.getSkills()))
                .collect(Collectors.toList());
        logger.info("Standard strategy assigned team: " + assignedEmployees);
        return assignedEmployees;
    }
}
