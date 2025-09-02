package school.faang.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final int MAX_FOR_EMPLOYEE = 2;
    private List<Project> allProjects;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> teamMembers = new ArrayList<>();
        Map<Employee, Integer> projectsByEmployee = new HashMap<>();
        employees.forEach(employee -> projectsByEmployee.put(employee, countEmployeeProjects(employee)));

        project.getRequiredSkills().forEach(skill -> employees.forEach(employee -> {
            if (projectsByEmployee.get(employee) < MAX_FOR_EMPLOYEE && employee.getSkills().contains(skill)
                    && !teamMembers.contains(employee)) {
                teamMembers.add(employee);
            }
        }));

        project.setTeamMembers(teamMembers);
        return teamMembers;
    }

    public void transferAllProjects(List<Project> allProjects) {
        this.allProjects = allProjects;
    }

    private int countEmployeeProjects(Employee employee) {
        AtomicInteger counter = new AtomicInteger(0);

        allProjects.forEach(project -> {
            if (project.getTeamMembers().contains(employee)) {
                counter.getAndIncrement();
            }
        });

        return counter.get();
    }
}
