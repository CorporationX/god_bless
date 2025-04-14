package school.faang.teammanagement;

import java.util.List;

public interface TeamAssignmentStrategy {
    public default void assignTeam(Project project, List<Employee> employees){

    }
}
