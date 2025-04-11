package school.faang.team_project_management;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ProjectManager {
    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private TeamAssignmentStrategy assignmentStrategy;
    private int employeesCount = 0;
    private int projectsCount = 0;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {

        this.assignmentStrategy = strategy;
    }

    public List<Employee> assignTeamToProject(int pojectId) {

        return assignmentStrategy.assignTeam(projects.get(pojectId), employees);
    }

    public  void setTeamForProject(int projectId) {
        projects.get(projectId).setTeamMembers(assignTeamToProject(projectId));
    }

    public  List<Employee> getTeamForProject(int projectId) {

        return projects.get(projectId).getTeamMembers();
    }

    public void addEmployee(String name, Set<String> skills) {
        employeesCount++;
        employees.add(new Employee(employeesCount, name, skills, 0));
    }

    public void addProject(String name, Set<String> requiredSkills, List<Employee> teamMembers) {
        projectsCount++;
        projects.add(new Project(employeesCount, name, requiredSkills, teamMembers));
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        return projects.stream().filter(
                project -> project.getRequiredSkills()
                        .stream()
                        .anyMatch(skill -> employee.getSkills().contains(skill)))
                .collect(Collectors.toList());
    }

    public void assignEmployeeToProject(Employee employee, int projectId) {
        projects.get(projectId).getTeamMembers().add(employee);
        employee.incrementProjectsAmount();
    }

    public void removeEmployeeFromProject(int employeeId, int projectId) {
        projects.get(projectId).getTeamMembers().remove(employeeId);
        employees.get(employeeId).decrementProjectsAmount();
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers().removeIf(
                employee -> Collections.disjoint(
                        employee.getSkills(), project.getRequiredSkills()));
    }
}
