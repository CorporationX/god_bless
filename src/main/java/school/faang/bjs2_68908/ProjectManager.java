package school.faang.bjs2_68908;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ProjectManager {

    private List<Employee> companyEmployees;
    private List<Project> companyProjects;
    private TeamAssignmentStrategy assignmentStrategy;

    public void addEmployee(Employee employee) {
        companyEmployees.add(employee);
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = findProjectById(projectId);
        List<String> sortedEmployeeSkills = employee.getSkills()
                .stream()
                .sorted()
                .toList();
        List<String> sortedProjectSkills = project.getRequiredSkills()
                .stream()
                .sorted()
                .toList();
        if (sortedEmployeeSkills.equals(sortedProjectSkills)) {
            project.getTeamMembers().add(employee);
        }
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = findProjectById(projectId);
        Employee employee = companyEmployees.stream()
                .filter(e -> e.getId() == employeeId)
                .findFirst().orElse(null);
        project.getTeamMembers().remove(employee);

    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> suitableProjects = new ArrayList<>();
        for (Project project : companyProjects) {
            for (String skill : employee.getSkills()) {
                if (project.getRequiredSkills().contains(skill)) {
                    suitableProjects.add(project);
                    break;
                }
            }
        }
        return suitableProjects;
    }

    public void assignTeamToProject(int projectId) {
        Project project = findProjectById(projectId);
        project.setTeamMembers
                (assignmentStrategy.assignTeam(companyProjects.get(projectId), companyEmployees));
    }

    public List<Employee> getTeamToProject(int projectId) {
        Project project = findProjectById(projectId);
        return project.getTeamMembers();
    }

    public List<Employee> getTeamMembers(int projectId) {
        Project project = findProjectById(projectId);
        return project.getTeamMembers();
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers()
                .removeIf(employee -> !findProjectsForEmployee(employee).contains(project));
    }

    private Project findProjectById(int projectId) {
        return companyProjects.stream()
                .filter(project -> project.getProjectId() == projectId)
                .findFirst()
                .orElse(null);
    }
}
