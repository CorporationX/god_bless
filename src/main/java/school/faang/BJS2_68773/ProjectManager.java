package school.faang.BJS2_68773;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ProjectManager {
    private final Map<Long, Employee> employees = new HashMap<>();
    private final Map<Long, Project> projects = new HashMap<>();
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Employee> assignTeamToProject(long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        return strategy.assignTeam(project, (List<Employee>) employees.values());
    }

    public List<Employee> getTeamForProject(long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        return project.getTeamMembers();
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee must not be null");
        }
        employees.putIfAbsent(employee.getId(), employee);
    }

    public void addProject(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project must not be null");
        }
        projects.putIfAbsent(project.getProjectId(), project);
    }

    public Set<Project> findProjectsForEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee must not be null");
        }
        Set<Project> employeeProjects = new HashSet<>();
        projects.forEach((projectId, project) -> {
            if (SkillUtils.hasCommonSkills(project.getRequiredSkills(), employee.getSkills())) {
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
        Set<Skill> requiredProjectSkills = new HashSet<>(project.getRequiredSkills());
        SkillUtils.subtractSkillsCoveredBy(employee, requiredProjectSkills);
        if (requiredProjectSkills.isEmpty()) {
            project.getTeamMembers().add(employee);
        }
    }

    public void removeEmployeeFromProject(long projectId, long employeeId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        project.getTeamMembers().removeIf(employee -> employee.getId().equals(employeeId));
    }

    public List<Employee> getTeamMembers(long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new NoSuchElementException("Project with id = " + projectId + " was not found");
        }
        return project.getTeamMembers();
    }

    public void removeIneligibleEmployees(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project must not be null");
        }
        project.getTeamMembers().removeIf(employee -> employee != null &&
                !SkillUtils.hasCommonSkills(project.getRequiredSkills(), employee.getSkills()));
    }
}
