package school.faang.projectteammanagement;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    private final List<Project> projects;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> sortedListOfEmployees = employees
                .stream()
                .sorted(Comparator.comparing(this::countNumberOfProjects))
                .toList();
        return TeamAssignmentStrategy.coverAllSkills(project.getRequiredSkills(), sortedListOfEmployees);
    }

    private long countNumberOfProjects(Employee employee) {
        return projects.stream().filter(p -> p.getTeamMembers().contains(employee)).count();
    }
}
