package school.faang.project_team_management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManager {
    private List<Project> projectList = new ArrayList<>();
    private List<Employee> employeeList = new ArrayList<>();
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void print() {
        System.out.println(projectList);
        System.out.println(employeeList);
    }

    public void assignTeamToProject(int projectId) {
        for (Project project : projectList) {
            if (project.getProjectId() == projectId) {
                project.setTeamMembers(strategy.assignTeam(project, employeeList));
            }
        }
    }

    public List<Employee> getTeamForProject(int projectId) {
        for (Project project : projectList) {
            if (project.getProjectId() == projectId) {
                return project.getTeamMembers();
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void addProject(Project project) {
        projectList.add(project);
    }

    public List<Project> findProjectForEmployee(Employee employee) {
        return projectList.stream()
                .filter(project -> project.getRequiredSkills().stream()
                        .anyMatch(skill -> employee.getSkills()
                                .contains(skill))).collect(Collectors.toList());
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        for (Project project : projectList) {
            if (project.getProjectId() == projectId) {
                if (employee.getSkills().containsAll(project.getRequiredSkills())) {
                    project.getTeamMembers().add(employee);
                    employee.setProjectEmploy(employee.getProjectEmploy() + 1);
                    return true;
                }
            }
        }

        return false;
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        for (Project project : projectList) {
            if (project.getProjectId() == projectId) {
                for (Employee employee : project.getTeamMembers()) {
                    if (employee.getId() == employeeId) {
                        project.getTeamMembers().remove(employee);
                        break;
                    }
                }
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