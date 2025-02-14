import java.util.List;

interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);
}
