package school.faang.project_team_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectManager {
    private final Map<Integer, Project> projectsMap = new HashMap<>();
    private final Map<Integer, Employee> employeesMap = new HashMap<>();
    private final List<Project> projectList = new ArrayList<>();
    private final List<Employee> employeeList = new ArrayList<>();
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        Project project = projectsMap.get(projectId);
        project.setTeamMembers(strategy.assignTeam(project, employeeList));
    }

    public List<Employee> getTeamForProject(int projectId) {
        return projectsMap.get(projectId).getTeamMembers();
    }

    public void addEmployee(Employee employee) {
        employeesMap.put(employee.getId(), employee);
        employeeList.add(employee);
    }

    public void addProject(Project project) {
        projectsMap.put(project.getProjectId(), project);
        projectList.add(project);
    }

    public List<Project> findProjectForEmployee(Employee employee) {
        return projectList.stream()
                .filter(project -> project.getRequiredSkills()
                        .stream()
                        .anyMatch(skill -> employee.getSkills().contains(skill)))
                .collect(Collectors.toList());
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projectsMap.get(projectId);
        if (employee.getSkills().containsAll(project.getRequiredSkills())) {
            project.getTeamMembers().add(employee);
            employee.setProjectEmployCount(employee.getProjectEmployCount() + 1);
            return true;
        }
        return false;
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = projectsMap.get(projectId);
        for (Employee employee : project.getTeamMembers()) {
            if (employee.getId() == employeeId) {
                project.getTeamMembers().remove(employee);
                break;
            }
        }
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers()
                .removeIf(employee -> employee.getSkills().stream()
                        .noneMatch(skill -> project.getRequiredSkills().contains(skill)));
    }
}