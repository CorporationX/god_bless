package school.faang.bjs2_68908;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class ProjectManager {

    private Map<Integer, Employee> companyEmployees;
    private Map<Integer, Project> companyProjects;
    private TeamAssignmentStrategy assignmentStrategy;

    public void addEmployee(Employee employee) {
        companyEmployees.put(employee.getId(), employee);
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = companyProjects.get(projectId);
        if (employee.getSkills().containsAll(project.getRequiredSkills())) {
            project.getTeamMembers().add(employee);
        }
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        companyProjects.get(projectId).getTeamMembers().remove(companyEmployees.get(employeeId));

    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> suitableProjects = new ArrayList<>();
        for (Map.Entry<Integer, Project> entry : companyProjects.entrySet()) {
            for (String skill : employee.getSkills()) {
                if (entry.getValue().getRequiredSkills().contains(skill)) {
                    suitableProjects.add(entry.getValue());
                    break;
                }
            }
        }
        return suitableProjects;
    }

    public void assignTeamToProject(int projectId) {
        companyProjects.get(projectId).setTeamMembers(assignmentStrategy
                .assignTeam(companyProjects.get(projectId), companyEmployees.values().stream().toList()));
    }

    public List<Employee> getTeamForProject(int projectId) {
        return companyProjects.get(projectId).getTeamMembers();
    }

    public List<Employee> getTeamMembers(int projectId) {
        return companyProjects.get(projectId).getTeamMembers();
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers()
                .removeIf(employee -> !findProjectsForEmployee(employee).contains(project));
    }
}
