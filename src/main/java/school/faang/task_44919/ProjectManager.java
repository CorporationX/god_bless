package school.faang.task_44919;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    private List<Employee> employees;
    private List<Project> projects;

    @Setter
    private TeamAssignmentStrategy strategy;

    public ProjectManager(List<Employee> employees, List<Project> projects) {
        this.employees = employees;
        this.projects = projects;
    }

    public void assignTeamToProject(int projectId) {
        Project project = findById(projectId);
        if (strategy != null) {
            project.setTeamMembers(strategy.assignTeam(project, employees));
        }
    }

    public List<Employee> getTeamForProject(int projectId) {
        Project project = findById(projectId);
        return project.getTeamMembers();
    }

    public void removeIneligibleEmployees(Project project) {
        List<Employee> ineligibleEmployees = new ArrayList<>();
        for (Employee employee : project.getTeamMembers()) {
            boolean isEligible = false;
            for (String skill : employee.getSkills()) {
                if (project.getRequiredSkills().contains(skill)) {
                    isEligible = true;
                    break;
                }
            }
            if (!isEligible) {
                ineligibleEmployees.add(employee);
            }
        }
        project.getTeamMembers().removeAll(ineligibleEmployees);
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = findById(projectId);
        project.getTeamMembers().removeIf(employee -> employee.getId() == employeeId);
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = findById(projectId);
        for (String skill : employee.getSkills()) {
            if (project.getRequiredSkills().contains(skill)) {
                if (project.getTeamMembers() != null) {
                    project.getTeamMembers().add(employee);
                } else {
                    List<Employee> members = new ArrayList<>();
                    members.add(employee);
                    project.setTeamMembers(members);
                }
            }
        }
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> suitable = new ArrayList<>();
        for (Project project : projects) {
            for (String skill : employee.getSkills()) {
                if (project.getRequiredSkills().contains(skill)) {
                    suitable.add(project);
                    break;
                }
            }
        }
        return suitable;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    private Project findById(int id) {
        return projects.stream()
                .filter(p -> p.getProjectId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Project not found by id: " + id));
    }
}
