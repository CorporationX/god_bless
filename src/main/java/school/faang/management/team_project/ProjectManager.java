package school.faang.management.team_project;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class ProjectManager {
    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();
    private TeamAssignmentStrategy assignmentStrategy = new StandardTeamAssignmentStrategy();

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public void addProject(Project project) {
        if (!projects.contains(project)) {
            projects.add(project);
        }
    }

    public void assignTeamToProject(int projectId) throws IllegalArgumentException {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Проект id=%d не найден", projectId)));

        List<Employee> assignedTeam = assignmentStrategy.assignTeam(project, employees);
        assignedTeam.forEach(project::addTeamMember);
    }

    private Optional<Project> findProjectById(int projectId) {
        return projects.stream()
                .filter(project -> project.getId() == projectId)
                .findFirst();
    }

    public List<Employee> getTeamForProject(int projectId) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Проект id=%d не найден", projectId)));
        return project.getTeamMembers();
    }

    public List<Employee> getTeamMembers(int projectId) {
        return findProjectById(projectId)
                .map(Project::getTeamMembers)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Проект id=%d не найден", projectId)));
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        return projects.stream()
                .filter(project -> project.getRequiredSkills().stream().anyMatch(s -> employee.getSkills().contains(s)))
                .collect(Collectors.toList());
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Проект id=%d не найден", projectId)));
        if (employees.contains(employee) && employee.getSkills().containsAll(project.getRequiredSkills())) {
            return project.addTeamMember(employee);
        }
        return false;
    }

    public boolean removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Проект id=%d не найден", projectId)));
        Employee employee = findEmployeeById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Сотрудник id=%d не найден", employeeId)));
        return project.removeTeamMember(employee);
    }

    private Optional<Employee> findEmployeeById(int employeeId) {
        return employees.stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst();
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers().removeIf(employee ->
                employee.getSkills().stream().noneMatch(project.getRequiredSkills()::contains)
        );
    }

    public void clearProjectTeam(int projectId) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Проект id=%d не найден", projectId)));
        project.clearTeamMembers();
    }

}
