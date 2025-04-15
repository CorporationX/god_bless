package school.faang.bjs2_68908;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface TeamAssignmentStrategy {
    Set<Employee> acceptedEmployees = new HashSet<>();
    List<Employee> assignTeam(Project project, List<Employee> employees);
}
