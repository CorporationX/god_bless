package school.faang.task_44919;

import java.util.*;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Map<Employee, Integer> projectCounts = new HashMap<>();
        List<Employee> members = new ArrayList<>();

        for (Employee employee : employees) {
            projectCounts.put(employee, employee.getProjects().size());
        }

        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return projectCounts.getOrDefault(o1, 0) - projectCounts.getOrDefault(o2, 0);
            }
        });
        for (Employee employee : employees) {
            if (requiredSkills.isEmpty()) {
                break;
            }
            boolean added = false;
            for (String skill : employee.getSkills()) {
                if (requiredSkills.contains(skill)) {

                    if (!added) {
                        members.add(employee);
                        employee.getProjects().add(project);
                        added = true;
                    }
                    requiredSkills.remove(skill);
                }
            }
        }
        return members;
    }
}
