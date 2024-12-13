package school.faang.sprint_1.task_44950;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectManager {
    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void assignTeamToProject(int projectId) {
        Project project = projects.stream()
                .filter(p -> p.projectId == projectId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        project.teamMembers = strategy.assignTeam(project, employees);
    }

    public List<Employee> getTeamForProject(int projectId) {
        return projects.stream()
                .filter(p -> p.projectId == projectId)
                .findFirst()
                .map(p -> p.teamMembers)
                .orElse(Collections.emptyList());
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        return projects.stream()
                .filter(p -> p.requiredSkills.stream().anyMatch(employee.skills::contains))
                .collect(Collectors.toList());
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projects.stream()
                .filter(p -> p.projectId == projectId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        if (employee.skills.containsAll(project.requiredSkills)) {
            project.teamMembers.add(employee);
        }
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        projects.stream()
                .filter(p -> p.projectId == projectId)
                .findFirst()
                .ifPresent(p -> p.teamMembers.removeIf(emp -> emp.id == employeeId));
    }

    public void removeIneligibleEmployees(Project project) {
        project.teamMembers = project.teamMembers.stream()
                .filter(emp -> emp.skills.containsAll(project.requiredSkills))
                .collect(Collectors.toList());
    }
}
