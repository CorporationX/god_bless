package school.faang.management.team_project;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class ProjectManager {
    private final List<Employee> dbEmployee = new ArrayList<>();
    private final List<Project> dbProject = new ArrayList<>();
    private TeamAssignmentStrategy assignmentStrategy = new StandardTeamAssignmentStrategy();

    public void addEmployee(Employee employee) {
        if (!dbEmployee.contains(employee)) {
            dbEmployee.add(employee);
        }
    }

    public void addProject(Project project) {
        if (!dbProject.contains(project)) {
            dbProject.add(project);
        }
    }

    public void assignTeamToProject(int projectId) throws IllegalArgumentException {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден"));

        List<Employee> assignedTeam = assignmentStrategy.assignTeam(project, dbEmployee);
        assignedTeam.forEach(project::addTeamMember);
    }

    private Optional<Project> findProjectById(int projectId) {
        return dbProject.stream()
                .filter(project -> project.getId() == projectId)
                .findFirst();
    }

    public List<Employee> getTeamForProject(int projectId) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден"));
        return project != null ? project.getTeamMembers() : Collections.emptyList();
    }

    public List<Employee> getTeamMembers(int projectId) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден"));
        return project.getTeamMembers();
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        return dbProject.stream()
                .filter(project -> project.getRequiredSkills().stream().anyMatch(s -> employee.getSkills().contains(s)))
                .collect(Collectors.toList());
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден"));
        if (dbEmployee.contains(employee) && employee.getSkills().containsAll(project.getRequiredSkills())) {
            return project.addTeamMember(employee);
        }
        return false;
    }

    public boolean removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = findProjectById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден"));
        Employee employee = findEmployeeById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Сотрудник не найден"));
        return project.removeTeamMember(employee);
    }

    private Optional<Employee> findEmployeeById(int employeeId) {
        return dbEmployee.stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst();
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers().removeIf(employee ->
                employee.getSkills().stream().noneMatch(project.getRequiredSkills()::contains)
        );
    }

}
