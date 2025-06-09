package school.faang.project;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import school.faang.project.domain.Employee;
import school.faang.project.domain.Project;
import school.faang.project.strategy.TeamAssignmentStrategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
@Slf4j
@Setter
public class ProjectManager {

    private final Map<Integer, Project> projectsById = new HashMap<>();
    private final Map<Integer, Employee> employeesById = new HashMap<>();

    private TeamAssignmentStrategy assignmentStrategy;

    public void assignTeamToProject(int projectId) {
        var project = findProject(projectId);
        if (project == null) {
            return;
        }
        assignmentStrategy.assignTeam(project, employeesById.values());
    }

    public Set<Employee> getTeamForProject(int projectId) {
        var project = findProject(projectId);
        if (project == null) {
            return Set.of();
        }
        return project.getTeamMembers();
    }

    public void addEmployee(Employee employee) {
        employeesById.put(employee.getId(), employee);
    }

    public void addProject(Project project) {
        projectsById.put(project.getId(), project);
    }

    public Set<Project> findProjectsForEmployee(Employee employee) {
        var projectsForEmployee = new HashSet<Project>();
        for (var project : projectsById.values()) {
            var requiredSkills = project.getRequiredSkills();
            for (var employeeSkill : employee.getSkills()) {
                if (requiredSkills.contains(employeeSkill)) {
                    projectsForEmployee.add(project);
                    break;
                }
            }
        }
        return projectsForEmployee;
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        var project = findProject(projectId);
        if (project == null) {
            return;
        }
        var requiredSkills = project.getRequiredSkills();
        for (var employeeSkill : employee.getSkills()) {
            if (!requiredSkills.contains(employeeSkill)) {
                log.info("Employee {} does not have required skill {}", employee, employeeSkill);
                return;
            }
        }
        project.getTeamMembers().add(employee);
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        var project = findProject(projectId);
        if (project == null) {
            return;
        }
        var employee = findEmployee(employeeId);
        if (employee == null) {
            return;
        }
        var isEmployeeRemoved = project.getTeamMembers().remove(employee);
        if (isEmployeeRemoved) {
            log.info("Employee {} has been removed", employee);
        }
    }

    public Set<Employee> getTeamMembers(int projectId) {
        var project = findProject(projectId);
        if (project == null) {
            return Set.of();
        }
        return project.getTeamMembers();
    }

    public void removeIneligibleEmployees(Project project) {
        var teamMembers = project.getTeamMembers();
        var requiredSkills = project.getRequiredSkills();
        var employeeIterator = teamMembers.iterator();
        while (employeeIterator.hasNext()) {
            var employee = employeeIterator.next();
            var employeeSkills = employee.getSkills();
            boolean atLeastOneSkillMatch = false;
            for (var employeeSkill : employeeSkills) {
                if (requiredSkills.contains(employeeSkill)) {
                    atLeastOneSkillMatch = true;
                    break;
                }
            }
            if (!atLeastOneSkillMatch) {
                employeeIterator.remove();
            }
        }
    }

    private Employee findEmployee(int employeeId) {
        var foundEmployee = employeesById.get(employeeId);
        if (foundEmployee == null) {
            log.warn("No employee with id {} found", employeeId);
            return null;
        }
        return foundEmployee;
    }

    private Project findProject(int projectId) {
        var project = projectsById.get(projectId);
        if (project == null) {
            log.warn("Project with id {} not found", projectId);
            return null;
        }
        return project;
    }
}
