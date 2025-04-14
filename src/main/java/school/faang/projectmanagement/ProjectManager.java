package school.faang.projectmanagement;

import school.faang.projectmanagement.strategy.TeamAssignmentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProjectManager {
    private final Map<Integer, Project> projectByProjectId;
    private final List<Employee> employees;

    private TeamAssignmentStrategy teamAssignmentStrategy;

    public ProjectManager(TeamAssignmentStrategy teamAssignmentStrategy) {
        this.teamAssignmentStrategy = teamAssignmentStrategy;
        this.projectByProjectId = new HashMap<>();
        this.employees = new ArrayList<>();
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.teamAssignmentStrategy = teamAssignmentStrategy;
    }

    public Project addProject(Project project) {
        return projectByProjectId.put(project.getProjectId(), project);
    }

    public boolean removeProject(int projectId) {
        Project project = projectByProjectId.remove(projectId);
        return project != null;
    }

    public List<Employee> assignTeamToProject(int projectId) {
        Project project = projectByProjectId.get(projectId);
        if (project == null) {
            throw new NoSuchElementException(String.format("Project with id %d doesn't exist", projectId));
        }
        return teamAssignmentStrategy.assignTeam(project, employees);
    }

    public List<Employee> getTeamForProject(int projectId) {
        return Optional.ofNullable(projectByProjectId.get(projectId))
                .map(Project::getTeamMembers)
                .orElseThrow(() -> new NoSuchElementException(String.format("Project with id %d doesn't exist")));
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        return projectByProjectId.values().stream()
                .filter(project -> project.getRequiredSkills().stream()
                .anyMatch(skill -> employee.getSkills().contains(skill)))
                .toList();
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projectByProjectId.get(projectId);
        if (project == null || project.getRequiredSkills().stream()
                .noneMatch(skill -> employee.getSkills().contains(skill))) {
            return false;
        }
        project.getTeamMembers().add(employee);
        return true;
    }

    public boolean removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = projectByProjectId.get(projectId);
        if (project == null) {
            return false;
        }
        Optional<Employee> employee = project.getTeamMembers().stream()
                .filter(member -> member.getId() == employeeId)
                .findFirst();
        if (employee.isEmpty()) {
            return false;
        }
        project.getTeamMembers().remove(employee);
        return true;
    }

    public List<Employee> getTeamMembers(int projectId) {
        Project project = projectByProjectId.get(projectId);
        List<Employee> teamMembers = new ArrayList<>();
        if (project != null) {
            teamMembers = project.getTeamMembers();
        }
        return teamMembers;
    }

    public List<Employee> removeIneligibleEmployees(Project project) {
        project.getTeamMembers().removeIf(member -> member.getSkills().stream()
                .noneMatch(skill -> project.getRequiredSkills().contains(skill)));
        return project.getTeamMembers();
    }
}