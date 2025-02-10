package school.faang.teammanagement;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
public class ProjectManager {
    private List<Employee> employees;
    private List<Project> projects;
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    private boolean addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            System.out.println("Employee already exist");
            return false;
        } else {
            employees.add(employee);
            return true;
        }
    }

    private void assignTeamToProject(int projectId) {
        for (Project project : projects) {
            if (project.getProjectId() == projectId) {
                strategy.assignTeam(project, employees);
            }
        }
    }

    private List<Employee> getTeamForProject(int projectId) {
        List<Employee> teamMembers = new ArrayList<>();
        for (Project project : projects) {
            if (project.getProjectId() == projectId) {
                teamMembers = project.getTeamMembers();
            }
        }

        return teamMembers;
    }

    private List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> suitableProjects = new ArrayList<>();
        Set<String> employeeSkills = employee.getSkills();

        for (Project project : projects) {
            if (employeeSkills.containsAll(project.getRequiredSkills())) {
                suitableProjects.add(project);
            }
        }

        return suitableProjects;
    }

    private boolean assignEmployeeToProject(int projectId, Employee employee) {
        for (Project project : projects) {
            if (project.getProjectId() == projectId) {
                if (employee.getSkills().containsAll(project.getRequiredSkills())) {
                    project.getTeamMembers().add(employee);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean removeEmployeeFromProject(int projectId, int employeeId) {
        for (Project project : projects) {
            if (project.getProjectId() == projectId) {
                return project.getTeamMembers().removeIf(employee -> employee.getId() == employeeId);
            }
        }

        return false;
    }

    private List<Employee> getTeamMembers(int projectId) {
        List<Employee> teamMembers = new ArrayList<>();
        for (Project project : projects) {
            if (project.getProjectId() == projectId) {
                teamMembers = project.getTeamMembers();
            }
        }

        return teamMembers;
    }

    private void removeIneligibleEmployees(Project project) {
        List<Employee> teamMembers = project.getTeamMembers();
        Set<String> requiredSkills = project.getRequiredSkills();
        teamMembers.removeIf(employee -> !employee.getSkills().containsAll(requiredSkills));
    }
}
