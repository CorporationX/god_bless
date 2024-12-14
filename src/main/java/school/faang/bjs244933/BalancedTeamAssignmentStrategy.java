package school.faang.bjs244933;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final int MAX_PROJECTS_PER_EMPLOYEE = 1;

    @Override
    public List<Employee> assignTeam(@NonNull Project project, @NonNull List<Employee> employees) {

        List<Employee> employeesTeamBalanced = new ArrayList<>();
        Map<Employee, Integer> projectCount = new HashMap<>();
        Set<String> requiredSkills = project.getRequiredSkills();

        for (Employee employee : employees) {
            int count;

            for (String skill : employee.getSkills()) {
                count = projectCount.getOrDefault(employee, 0);

                if (count >= MAX_PROJECTS_PER_EMPLOYEE) {
                    break;
                }
                if (requiredSkills.contains(skill)) {
                    requiredSkills.remove(skill);
                    employeesTeamBalanced.add(employee);
                    projectCount.put(employee, count + 1);
                }
            }
            if (requiredSkills.isEmpty()) {
                break;
            }
        }
        if (!requiredSkills.isEmpty()) {
            System.out.println("!!! No performers with the following skills have been found for this strategy: ");
            requiredSkills.forEach(System.out::println);
        }
        return employeesTeamBalanced;
    }
}
