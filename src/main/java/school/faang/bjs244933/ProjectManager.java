package school.faang.bjs244933;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ProjectManager {

    private List<Employee> employees;
    private Map<Integer, Project> projects;
    private Map<Integer, Employee> employeeById;
    private TeamAssignmentStrategy assignmentStrategy;

    public ProjectManager(@NonNull List<Employee> employees, @NonNull Map<Integer, Project> projects) {
        this.employees = employees;
        this.projects = projects;
        employeeById = employees.stream().collect(Collectors.toMap(Employee::getId, item -> item));
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        assignmentStrategy = strategy;
    }

    public void assignTeamToProject(int projectId) {

        Project project = projects.get(projectId);

        if (project != null && assignmentStrategy != null) {
            List<Employee> assignedTeam = assignmentStrategy.assignTeam(project, employees);
            project.getTeamMembers().clear();
            project.getTeamMembers().addAll(assignedTeam);
        }
    }

    public List<Employee> getTeamForProject(int projectId) {
        Project project = projects.get(projectId);
        return project != null ? project.getTeamMembers() : Collections.emptyList();
    }

    public void addEmployee(Employee employee) {
        if (!employeeById.containsKey(employee.getId())) {
            employeeById.put(employee.getId(), employee);
            employees.add(employee);
        } else {
            throw new IllegalStateException("The employee with the specified id was not found!");
        }
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> suitableProjects = new ArrayList<>();
        for (Project project : projects.values()) {
            if (employee.getSkills().containsAll(project.getRequiredSkills())) {
                suitableProjects.add(project);
            }
        }
        return suitableProjects;
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projects.get(projectId);
        if (project != null && employee.getSkills().containsAll(project.getRequiredSkills())) {
            project.getTeamMembers().add(employee);
            return true;
        }
        return false;
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = projects.get(projectId);
        if (project != null) {
            List<Employee> teamMembers = project.getTeamMembers();
            for (int i = 0; i < teamMembers.size(); i++) {
                if (teamMembers.get(i).getId() == employeeId) {
                    teamMembers.remove(i);
                    break;
                }
            }
        } else {
            throw new IllegalStateException("The project with the specified id was not found!");
        }
    }

    public List<Employee> getTeamMembers(int projectId) {
        Project project = projects.get(projectId);
        return project != null ? project.getTeamMembers() : Collections.emptyList();
    }

    public void removeIneligibleEmployees(Project project) {
        List<Employee> teamMembers = project.getTeamMembers();
        for (int i = 0; i < teamMembers.size(); i++) {
            Employee employee = teamMembers.get(i);
            if (!employee.getSkills().containsAll(project.getRequiredSkills())) {
                teamMembers.remove(i);
                i--;
            }
        }
    }
}
