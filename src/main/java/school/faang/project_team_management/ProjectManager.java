package school.faang.project_team_management;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectManager {
    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();
    private TeamAssignmentStrategy teamAssignmentStrategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.teamAssignmentStrategy = strategy;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> projectsForEmployee = new ArrayList<>();
        for (Project project : projects) {
            if (project.getRequiredSkills().containsAll(employee.getSkills())) {
                projectsForEmployee.add(project);
            }
        }
        return projectsForEmployee;
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        if (projects.size() <= projectId) {
            throw new IllegalArgumentException("Такого проекта нет");
        }
        if (projects.get(projectId - 1).getRequiredSkills().containsAll(employee.getSkills())) {
            projects.get(projectId - 1).getTeamMembers().add(employee);
        }
    }


    public void removeEmployeeFromProject(int projectId, int employeeId) {
        if (projects.size() <= projectId) {
            throw new IllegalArgumentException("Такого проекта нет");
        }
        if (employees.size() <= employeeId) {
            throw new IllegalArgumentException("Такого сотрудника нет");
        }
        projects.get(projectId - 1).getTeamMembers().remove(employees.get(employeeId - 1));
    }

    public List<Employee> getTeamMembers(int projectId) throws IllegalArgumentException {
        if (projects.size() < projectId) {
            throw new IllegalArgumentException("Такого проекта нет");
        }
        return new ArrayList<>(projects.get(projectId - 1).getTeamMembers());
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers().removeIf(employee -> !employee.getSkills()
                .containsAll(project.getRequiredSkills()));
    }
}

