package school.faang.project_team_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> employeeList = new ArrayList<>();
        Set<String> setEmployee = project.getRequiredSkills();

        employees.forEach(employee -> employee.getSkills()
                .forEach(skill -> {
                    if (setEmployee.contains(skill)) {
                        if (!employeeList.contains(employee)) {
                            employeeList.add(employee);
                            employee.setProjectEmploy(employee.getProjectEmploy() + 1);
                        }
                        setEmployee.remove(skill);
                    }
                }));
        return employeeList;
    }
}
