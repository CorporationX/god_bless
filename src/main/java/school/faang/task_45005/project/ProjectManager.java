package school.faang.task_45005.project;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.strategies.TeamAssignmentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Getter
@ToString
public class ProjectManager {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Project> projects = new HashMap<>();
    private final Map<Integer, Set<Integer>> projectsByEmployee = new HashMap<>();
    private final Map<Integer, Set<Integer>> employeesByProject = new HashMap<>();

    private TeamAssignmentStrategy strategy;

    public void addProject(Project project) {
        final int projectId = project.getId();

        if (projects.containsKey(projectId)) {
            log.warn("Project with ID `{}` already exists", projectId);
            return;
        }

        projects.putIfAbsent(projectId, project);
        log.debug("Project added to ProjectManager: {}", project);
    }

    public void addEmployee(Employee employee) {
        final int employeeId = employee.getId();

        if (employees.containsKey(employeeId)) {
            log.warn("Employee with ID `{}` already exists", employeeId);
            return;
        }

        employees.putIfAbsent(employee.getId(), employee);
        log.debug("Employee added to ProjectManager: {}", employee);
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
        log.debug("Strategy `{}` has been set", strategy.getClass().getSimpleName());
    }

    public void assignTeamToProject(int projectId) {
        Project project = projects.get(projectId);

        if (project == null) {
            log.warn("Project with ID `{}` not found", projectId);
            return;
        }
        if (strategy == null) {
            log.warn("No strategy has been set");
            return;
        }

        if (!project.getTeamMembers().isEmpty()) {
            log.debug("Clearing existing team members for project `{}`", project.getId());
            List<Employee> mutableTeamMembers = new ArrayList<>(project.getTeamMembers());
            mutableTeamMembers.clear();
            project.setTeamMembers(mutableTeamMembers);
        }

        List<Employee> team = strategy.assignTeam(project, new ArrayList<>(employees.values()));

        if (team.isEmpty()) {
            log.warn("No team assigned for project `{}`. Team is empty.", projectId);
            return;
        }

        project.setTeamMembers(new ArrayList<>(team));

        updateMappings(projectId, team);

        projectsByEmployee.forEach((id, projects) -> {
            log.debug("Employee ID: {}", id);
            log.debug("Assigned Projects: {}", projects);
        });

        employeesByProject.forEach((id, employees) -> {
            log.debug("Project ID: {}", id);
            log.debug("Assigned Employees: {}", employees);
        });

        log.debug("Team assigned to project `{}`: {}", project.getName(), team);
    }

    private void updateMappings(int projectId, List<Employee> employees) {
        for (Employee employee : employees) {
            projectsByEmployee
                    .computeIfAbsent(employee.getId(), id -> new HashSet<>())
                    .add(projectId);

            employeesByProject
                    .computeIfAbsent(projectId, id -> new HashSet<>())
                    .add(employee.getId());
        }

        List<Integer> employeeIds = employees.stream().map(Employee::getId).toList();
        log.debug("Mappings updated: Project `{}` › Employees `{}`, Employees › Projects `{}`",
                projectId, employeeIds, projectsByEmployee);
    }

    public List<Employee> getTeamForProject(int projectId) {
        if (!projects.containsKey(projectId)) {
            log.warn("Project with ID `{}` not found", projectId);
            return null;
        }

        return projects.get(projectId).getTeamMembers();
    }

    public List<Project> findProjectsForEmployee(int employeeId) {
        Employee employee = employees.get(employeeId);

        if (employee == null) {
            log.warn("Employee with ID `{}` not found", employeeId);

            return List.of();
        }

        List<Project> eligibleProjects = projects.values().stream()
                .filter(project -> !projectsByEmployee.getOrDefault(employeeId, Set.of()).contains(project.getId()))
                .filter(project -> employee.getSkills().stream()
                        .anyMatch(skill -> project.getRequiredSkills().contains(skill)))
                .toList();

        log.debug("Eligible projects for employee `{}`: {}", employee.getName(), eligibleProjects);
        return eligibleProjects;
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projects.get(projectId);
        if (project == null) {
            log.warn("Project with ID `{}` not found", projectId);
            return;
        }

        List<Project> eligibleProjects = findProjectsForEmployee(employee.getId());
        if (!eligibleProjects.contains(project)) {
            log.warn("Employee `{}` does not meet the skill requirements for project `{}`",
                    employee.getName(), project.getName());
            return;
        }

        project.getTeamMembers().add(employee);

        projectsByEmployee.computeIfAbsent(employee.getId(), id -> new HashSet<>()).add(projectId);
        employeesByProject.computeIfAbsent(projectId, id -> new HashSet<>()).add(employee.getId());

        log.debug("Employee `{}` successfully assigned to project `{}`", employee.getName(), project.getName());
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = projects.get(projectId);
        if (project == null) {
            log.warn("Project with ID `{}` not found", projectId);
            return;
        }

        Employee employee = employees.get(employeeId);
        if (employee == null) {
            log.warn("Employee with ID `{}` not found", employeeId);
            return;
        }

        if (!project.getTeamMembers().contains(employee)) {
            log.warn("Employee `{}` is not part of the project `{}`", employee.getName(), project.getName());
            return;
        }

        project.getTeamMembers().remove(employee);

        Set<Integer> projectsForEmployee = projectsByEmployee.getOrDefault(employeeId, new HashSet<>());
        projectsForEmployee.remove(projectId);
        if (projectsForEmployee.isEmpty()) {
            projectsByEmployee.remove(employeeId);
        }

        Set<Integer> employeesForProject = employeesByProject.getOrDefault(projectId, new HashSet<>());
        employeesForProject.remove(employeeId);
        if (employeesForProject.isEmpty()) {
            employeesByProject.remove(projectId);
        }

        log.debug("Employee `{}` successfully removed from project `{}`", employee.getName(), project.getName());
    }

    public void getTeamMembers(int projectId) {
        if (!projects.containsKey(projectId)) {
            log.warn("Project with ID `{}` not found", projectId);
            return;
        }

        Set<Integer> employeeIds = employeesByProject.getOrDefault(projectId, Set.of());
        if (employeeIds.isEmpty()) {
            log.debug("No team members assigned to project with ID `{}`", projectId);
            return;
        }

        List<Employee> teamMembers = new ArrayList<>();
        for (Integer employeeId : employeeIds) {
            Employee employee = employees.get(employeeId);
            if (employee != null) {
                teamMembers.add(employee);
            } else {
                log.warn("Employee with ID `{}` not found in records but is mapped to project `{}`",
                        employeeId, projectId);
            }
        }

        log.debug("Team members for project `{}`: {}", projectId, teamMembers);
    }

    public void removeIneligibleEmployees(Project project) {
        if (project == null) {
            log.warn("Provided project is null");
            return;
        }

        List<Employee> teamMembers = project.getTeamMembers();
        if (teamMembers.isEmpty()) {
            log.debug("No team members to check for project `{}`", project.getName());
            return;
        }

        Set<String> requiredSkills = project.getRequiredSkills();
        if (requiredSkills.isEmpty()) {
            log.warn("Project `{}` has no required skills defined", project.getName());
            return;
        }

        List<Employee> ineligibleEmployees = new ArrayList<>();

        for (Employee employee : teamMembers) {
            boolean hasRequiredSkills = employee.getSkills().stream()
                    .anyMatch(requiredSkills::contains);
            if (!hasRequiredSkills) {
                ineligibleEmployees.add(employee);
            }
        }

        for (Employee ineligible : ineligibleEmployees) {
            teamMembers.remove(ineligible);
            int employeeId = ineligible.getId();

            Set<Integer> projectsForEmployee = projectsByEmployee.getOrDefault(employeeId, new HashSet<>());
            projectsForEmployee.remove(project.getId());
            if (projectsForEmployee.isEmpty()) {
                projectsByEmployee.remove(employeeId);
            }

            Set<Integer> employeesForProject = employeesByProject.getOrDefault(project.getId(), new HashSet<>());
            employeesForProject.remove(employeeId);
            if (employeesForProject.isEmpty()) {
                employeesByProject.remove(project.getId());
            }

            log.info("Employee `{}` removed from project `{}` due to insufficient skills.",
                    ineligible.getName(), project.getName());
        }

        log.debug("Remove ineligible employees completed for project `{}`", project.getName());
    }
}
