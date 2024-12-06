package school.faang.task44925;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    private static final int MAX_PROJECT = 2;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        validation(project, employees);
        List<Employee> team = new ArrayList<>();
        Map<Employee, Integer> countProject = new HashMap<>();

        for (Employee employee : employees) {
            int count = countProject.getOrDefault(employee, 0);

            if (count < MAX_PROJECT) {
                countProject.put(employee, count + 1);
                team.add(employee);
            }
        }
        return team;
    }
}
