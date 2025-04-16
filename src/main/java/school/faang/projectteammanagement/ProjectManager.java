package school.faang.projectteammanagement;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Getter
public class ProjectManager {

    private final List<Project> companyProjects;
    private final List<Employee> allEmployees;
    private TeamAssignmentStrategy activeStrategy;

    public ProjectManager(List<Project> companyProjects, List<Employee> allEmployees,
                          TeamAssignmentStrategy activeStrategy) {
        this.companyProjects = companyProjects;
        this.allEmployees = allEmployees;
        this.activeStrategy = activeStrategy;
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.activeStrategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        Optional<Project> projectById = getProjectById(projectId);
        projectById.ifPresent(project -> {
            List<Employee> teamMembers = activeStrategy.assignTeam(project, allEmployees);
            project.setTeamMembers(teamMembers);
        });
    }

    public List<Employee> getTeamForProject(int projectId) {
        return getProjectById(projectId)
                .map(Project::getTeamMembers)
                .orElse(Collections.emptyList());
    }

    public boolean addEmployee(Employee employee) {
        return allEmployees.add(employee);
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        return companyProjects.stream()
                .filter(project -> project.getRequiredSkills().stream().anyMatch(employee.getSkills()::contains))
                .toList();
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        return getProjectById(projectId)
                .filter(project -> project.getRequiredSkills().containsAll(employee.getSkills()))
                .map(project -> project.getTeamMembers().add(employee))
                .orElse(false);
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        getProjectById(projectId).ifPresent(project -> {
            List<Employee> filteredTeamMembers = project.getTeamMembers().stream()
                    .filter(employee -> employee.getId() != employeeId)
                    .toList();
            project.setTeamMembers(filteredTeamMembers);
        }
        );
    }

    public List<Employee> getTeamMembers(int projectId) {
        return getTeamForProject(projectId);
    }

    public List<Employee> removeIneligibleEmployees(Project project) {
        List<Employee> employeesToRemove = project.getTeamMembers().stream()
                .filter(employee -> employee.getSkills().stream().noneMatch(project.getRequiredSkills()::contains))
                .toList();
        employeesToRemove.forEach(project.getTeamMembers()::remove);
        return employeesToRemove;
    }

    private Optional<Project> getProjectById(int id) {
        return companyProjects
                .stream()
                .filter(project -> (project.getProjectId() == id))
                .findFirst();
    }
}
