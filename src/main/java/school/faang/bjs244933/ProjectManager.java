package school.faang.bjs244933;

import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ProjectManager {

    private final List<Employee> employees;
    private final Map<Integer, Project> projects;
    private final Map<Integer, Employee> employeeById;

    @Setter
    private TeamAssignmentStrategy assignmentStrategy;

    public ProjectManager(@NonNull List<Employee> employees, @NonNull Map<Integer, Project> projects) {
        this.employees = employees;
        this.projects = projects;
        employeeById = employees.stream().collect(Collectors.toMap(Employee::getId, item -> item));
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
            if (employeeById.containsKey(employeeId)) {
                List<Employee> teamMembers = project.getTeamMembers();
                teamMembers.remove(employeeById.get(employeeId));
                employeeById.remove(employeeId);
            } else {
                throw new IllegalStateException("In a project with this id" + projectId
                        + ", No employee with this id: " + employeeId + " was found!");
            }
        } else {
            throw new IllegalStateException("The project with the specified id was not found!");
        }
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
