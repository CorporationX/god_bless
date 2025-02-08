package school.faang.projectmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectManager {
    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private TeamAssignmentStrategy strategy;

    public ProjectManager(List<Employee> employees, List<Project> projects) {
        this.employees = employees;
        this.projects = projects;
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        for (Project project : projects) {
            if (project.getProjectId() == projectId && strategy != null) {
                List<Employee> team = strategy.assignTeam(project, employees);
                project.getTeamMembers().clear();
                project.getTeamMembers().addAll(team);
            }
        }
    }

    public List<Employee> getTeamForProject(int projectId) {
        for (Project project : projects) {
            if (project.getProjectId() == projectId) {
                return project.getTeamMembers();
            }
        }
        return Collections.emptyList();
    }
}
