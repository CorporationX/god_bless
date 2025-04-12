package school.faang.projectmanagement.strategy;

import school.faang.projectmanagement.Employee;
import school.faang.projectmanagement.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> projectEmployeeList = new ArrayList<>();
        Set<String> requiredSkills = project.getRequiredSkills();
        for (Employee employee : employees) {
            Optional<String> skillOptional = employee.getSkills().stream().filter(requiredSkills::contains).findFirst();
            if (skillOptional.isPresent()) {
                projectEmployeeList.add(employee);
                requiredSkills.remove(skillOptional.get());
            }
            if (requiredSkills.isEmpty()) {
                break;
            }
        }
        project.setTeamMembers(projectEmployeeList);
        return projectEmployeeList;
    }
}