package school.faang.task_44923;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectManager {
    private final List<Employee> employees;
    private final List<Project> projects;

    private final Map<Integer, Employee> employeeMap;
    private final Map<Integer, Project> projectMap;

    @Setter
    private TeamAssignmentStrategy assignmentStrategy;

    public ProjectManager() {
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();

        this.employeeMap = new HashMap<>();
        this.projectMap = new HashMap<>();
    }

    public void assignTeamToProject(int projectId) {
        Project project = projectMap.get(projectId);
        if (project != null && assignmentStrategy != null) {
            List<Employee> assignedTeam = assignmentStrategy.assignTeam(project, employees);
            project.teamMembers().clear();
            project.teamMembers().addAll(assignedTeam);

            System.out.printf("%s:%n", project);
            project.teamMembers().forEach(employee ->
                    System.out.printf("\t- %s%n", employee));
        }

    }

    public Project getProjectById(int projectId) {
        return projectMap.get(projectId);
    }

    public List<Employee> getTeamForProject(int projectId) {
        Project project = projectMap.get(projectId);
        return project != null ? project.teamMembers() : List.of();
    }

    public void addEmployee(Employee employee) {
        if (!employeeMap.containsKey(employee.id())) {
            employeeMap.put(employee.id(), employee);
            employees.add(employee);
        }
    }

    public void addProject(Project project) {
        if (!projectMap.containsKey(project.projectId())) {
            projectMap.put(project.projectId(), project);
            projects.add(project);
        }
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> suitableProjects = new ArrayList<>();
        for (Project project : projects) {
            if (employee.skills().containsAll(project.requiredSkills())) {
                suitableProjects.add(project);
            }
        }
        return suitableProjects;
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projectMap.get(projectId);
        if (project != null && employee.skills().containsAll(project.requiredSkills())) {
            project.teamMembers().add(employee);
            return true;
        }
        return false;
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = projectMap.get(projectId);
        Employee employee = employeeMap.get(employeeId);
        if (project != null && employee != null) {
            project.teamMembers().remove(employee);
        }
    }

    public void removeIneligibleEmployees(Project project) {
        project.teamMembers().removeIf(employee ->
                !employee.skills().containsAll(project.requiredSkills()));
    }

}
