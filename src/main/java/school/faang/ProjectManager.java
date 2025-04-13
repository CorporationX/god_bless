package school.faang;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ProjectManager {
    public static final Map<Employee, Integer> PROJECTS_COUNT_BY_EMPLOYEE = new HashMap<>();

    private final Map<Long, Employee> employees = new HashMap<>();
    private final Map<Long, Project> projects = new HashMap<>();
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignTeamToProject(long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        strategy.assignTeam(project, (List<Employee>) employees.values());
    }

    public List<Employee> getTeamForProject(long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        return project.teamMembers();
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee must not be null");
        }
        employees.putIfAbsent(employee.id(), employee);
    }

    public void addProject(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project must not be null");
        }
        projects.putIfAbsent(project.projectId(), project);
    }

    public Set<Project> findProjectsForEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee must not be null");
        }
        Set<Project> employeeProjects = new HashSet<>();
        projects.forEach((projectId, project) -> {
            if (!Collections.disjoint(employee.skills(), project.requiredSkills())) {
                employeeProjects.add(project);
            }
        });
        return employeeProjects;
    }

    public void assignEmployeeToProject(long projectId, Employee employee) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        if (employee == null) {
            throw new IllegalArgumentException("Employee must not be null");
        }
        Set<String> requiredProjectSkills = new HashSet<>(project.requiredSkills());
        requiredProjectSkills.removeAll(employee.skills());
        if (requiredProjectSkills.isEmpty()) {
            project.teamMembers().add(employee);
            PROJECTS_COUNT_BY_EMPLOYEE.put(employee, PROJECTS_COUNT_BY_EMPLOYEE.getOrDefault(employee, 0) + 1);
        }
    }

    public void removeEmployeeFromProject(long projectId, long employeeId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        project.teamMembers().removeIf(employee -> employee.id() == employeeId);
    }

    public List<Employee> getTeamMembers(long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        return project.teamMembers();
    }

    public void removeIneligibleEmployees(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project must not be null");
        }
        project.teamMembers().removeIf(employee -> employee != null &&
                Collections.disjoint(employee.skills(), project.requiredSkills()));
    }
}
