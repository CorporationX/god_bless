package school.faang.ProjectTeamManagement.manager;

import school.faang.ProjectTeamManagement.model.Employee;
import school.faang.ProjectTeamManagement.model.Project;
import school.faang.ProjectTeamManagement.strategy.TeamAssignmentStrategy;

import java.util.List;
import java.util.Map;

public class ProjectManager {
    private List<Employee> employees;
    private List<Project> projects;
    private TeamAssignmentStrategy strategy;

    public ProjectManager(List<Employee> employees, List<Project> projects) {
        this.employees = employees;
        this.projects = projects;
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        Project project = projects.stream().filter(p -> p.getProjectId() == projectId).findFirst().get();
        List<Employee> employees = this.employees;
        List<Employee> team = strategy.assignTeam(project, employees);
        project.setTeamMembers(team);
    }

    public void getTeamForProject(int projectId) {
        Project project = projects.stream().filter(p -> p.getProjectId() == projectId).findFirst().get();
        List<Employee> team = project.getTeamMembers();
        for (Employee employee : team) {
            System.out.println(employee.getName());
        }
    }

}