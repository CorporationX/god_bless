package school.faang.teammanagement;

import java.util.List;

public interface TeamAssignmentStrategy {
    default void assignTeam(Project project, List<Employee> employees) {

    }
}
