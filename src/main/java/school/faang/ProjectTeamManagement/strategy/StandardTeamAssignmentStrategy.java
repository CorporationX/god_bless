package school.faang.ProjectTeamManagement.strategy;

import school.faang.ProjectTeamManagement.model.Employee;
import school.faang.ProjectTeamManagement.model.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {

        List<Employee> team = new ArrayList<>();
        for (Employee employee : employees) {
            Set<String> skills = new HashSet<>(employee.getSkills());
            skills.retainAll(project.getRequiredSkills());

            if (!skills.isEmpty()) {
                team.add(employee);
            }
        }
        return team;
    }

}
