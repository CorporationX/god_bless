package school.faang.models;

import lombok.Setter;
import school.faang.exceptions.EmployeeNotFoundException;
import school.faang.exceptions.ProjectNotFoundException;
import school.faang.strategies.TeamAssignmentStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Setter
public class ProjectManager {
    private final Map<Integer, Employee> employeeMap;
    private final Map<Integer, Project> projectMap;
    private TeamAssignmentStrategy teamAssignmentStrategy;

    public ProjectManager(Map<Integer, Employee> employeeMap, Map<Integer, Project> projectMap) {
        validateEmployeeMap(employeeMap);
        validateProjectMap(projectMap);
        this.employeeMap = employeeMap;
        this.projectMap = projectMap;
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        validateAssignmentStrategy(strategy);
        teamAssignmentStrategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        if (!projectMap.containsKey(projectId)) {
            throw new ProjectNotFoundException(projectId);
        }
        List<Employee> employees = new ArrayList<>(employeeMap.values());
        teamAssignmentStrategy.assignTeam(projectMap.get(projectId), employees);
        System.out.printf("A Team of %s is now working on a project %s\n",
                projectMap.get(projectId).getTeamMembers(), projectMap.get(projectId));
    }

    public List<Employee> getTeamForProject(int projectId) {
        if (!projectMap.containsKey(projectId)) {
            throw new ProjectNotFoundException(projectId);
        }
        return projectMap.get(projectId).getTeamMembers().stream().toList();
    }

    public boolean addEmployee(Employee employee) {
        validateEmployee(employee);
        if (!employeeMap.containsKey(employee.getId())) {
            employeeMap.put(employee.getId(), employee);
            return true;
        }
        return false;
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        validateEmployee(employee);
        List<Project> suitableProjects = new ArrayList<>();
        for (Project project : projectMap.values()) {
            if (employee.getSkills().containsAll(project.getRequiredSkills())) {
                suitableProjects.add(project);
            }
        }
        return suitableProjects;
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        validateEmployee(employee);
        Project project = projectMap.get(projectId);
        if (project == null) {
            throw new ProjectNotFoundException(projectId);
        }
        if (employee.getSkills().containsAll(project.getRequiredSkills())) {
            employeeMap.put(employee.getId(), employee);
            project.getTeamMembers().add(employee);
            employee.setAssignedProjects(employee.getAssignedProjects() + 1);
            System.out.printf("Employee %s assigned for project %s\n", employee, project);
            return true;
        }
        return false;
    }

    public boolean removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = projectMap.get(projectId);
        if (project == null) {
            throw new ProjectNotFoundException(projectId);
        }
        Employee employee = employeeMap.get(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeId);
        }
        if (project.getTeamMembers().contains(employee)) {
            project.getTeamMembers().remove(employee);
            System.out.printf("Employee %s removed from project %s\n", employee, project);
            return true;
        }
        return false;
    }

    public List<Employee> getTeamMembers(int projectId) {
        Project project = projectMap.get(projectId);
        if (project == null) {
            throw new ProjectNotFoundException(projectId);
        }
        return project.getTeamMembers().stream().toList();
    }

    public void removeIneligibleEmployees(Project project) {
        validateProject(project);
        Iterator<Employee> iterator = project.getTeamMembers().iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            boolean fits = false;
            for (String skill : employee.getSkills()) {
                if (project.getRequiredSkills().contains(skill)) {
                    fits = true;
                    break;
                }
            }
            if (!fits) {
                System.out.printf("The employee %s was removed from project %s\n", employee, project);
                iterator.remove();
            }
        }
    }

    private void validateAssignmentStrategy(TeamAssignmentStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("The assignment strategy can't be null");
        }
    }

    private void validateProject(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("The project can't be null");
        }
    }

    private void validateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("The employee can't be null");
        }
    }

    private void validateEmployeeMap(Map<Integer, Employee> employeeMap) {
        if (employeeMap == null) {
            throw new IllegalArgumentException("The employeeMap can't be null");
        }
        for (Employee employee : employeeMap.values()) {
            validateEmployee(employee);
        }
    }

    private void validateProjectMap(Map<Integer, Project> projectMap) {
        if (projectMap == null) {
            throw new IllegalArgumentException("The projectMap can't be null");
        }
        for (Project project : projectMap.values()) {
            validateProject(project);
        }
    }
}
