package school.faang.project_team_management;

import java.util.ArrayList;
import java.util.List;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final int MAX_PROJECTS_PER_EMPLOYEE = 2;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getProjectEmploy() <= MAX_PROJECTS_PER_EMPLOYEE) {
                for (String skill : employee.getSkills()) {
                    if (project.getRequiredSkills().contains(skill)) {
                        employeeList.add(employee);
                        employee.setProjectEmploy(employee.getProjectEmploy() + 1);
                        break;
                    }
                }
            }
        }
        return employeeList;
    }
}
