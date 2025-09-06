package school.faang.bjs2_85817;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class ProjectManager {
    private final List<Employee> employeeList;
    private final Map<Integer, Project> projectSet;
    private TeamAssignmentStrategy assignmentStrategy;

    public void assignTeamToProject(int projectId) {
        Project project = projectSet.get(projectId);
        List<Employee> requiredEmployee = assignmentStrategy.assignTeam(project, employeeList);
        project.getTeamMembers().addAll(requiredEmployee);
        projectSet.put(projectId, project);
    }

    public List<Employee> getTeamForProject(int projectId) {
        return projectSet.get(projectId).getTeamMembers();
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> resultList = new ArrayList<>();
        Set<String> employeeSkills = employee.getSkills();
        projectSet.forEach((key, project) -> {
            if (employeeSkills.contains(project.getRequiredSkills())) {
                resultList.add(project);
            }
        });
        return resultList;
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projectSet.get(projectId);
        if (employee.getSkills().containsAll(project.getRequiredSkills())) {
            project.getTeamMembers().add(employee);
            employee.setProjectsCount(employee.getProjectsCount() + 1);
        }
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = projectSet.get(projectId);
        List<Employee> teamMembers = project.getTeamMembers();
        for (Employee employee : teamMembers) {
            if (employee.getId() == employeeId) {
                teamMembers.remove(employee);
                employee.setProjectsCount(employee.getProjectsCount() - 1);
                return;
            }
        }

    }

    public void removeIneligibleEmployees(Project project) {
        List<Employee> teamMembers = project.getTeamMembers();
        for (Employee employee : teamMembers) {
            if (employee.getSkills().contains(project.getRequiredSkills())) {
                teamMembers.remove(employee);
                employee.setProjectsCount(employee.getProjectsCount() - 1);
            }
        }
    }
}
