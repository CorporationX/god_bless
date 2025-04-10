package school.faang.team_project_management;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ProjectManager {
    private List<Employee> employees;
    private List<Project> projects;
    private TeamAssignmentStrategy assignmentStrategy;
    private int employeesCount = 0;

    private void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.assignmentStrategy = strategy;
    }

    private void assignTeamToProject(int pojectId) {
        assignmentStrategy.assignTeam(projects.get(pojectId), employees);
    }

    private List<Employee> getTeamForProject(int projectId) {
        return projects.get(projectId).getTeamMembers();
    }

    private Employee addEmployee(String name, Set<String> skills) {
        employeesCount++;
        return new Employee(employeesCount, name, skills, 0);
    }

    private List<Project> findProjectsForEmployee(Employee employee) {
        return projects.stream().filter(
                project -> project.getRequiredSkills()
                        .stream()
                        .anyMatch(skill -> employee.getSkills().contains(skill)))
                .collect(Collectors.toList());
    }

    private void assignEmployeeToProject(Employee employee, int projectId) {
        projects.get(projectId).getTeamMembers().add(employee);
        employee.incrementProjectsAmount();
    }

    private void removeEmployeeFromProject(int employeeId, int projectId) {
        projects.get(projectId).getTeamMembers().remove(employeeId);
        employees.get(employeeId).decrementProjectsAmount();
    }

    private void removeIneligibleEmployees(Project project) {
        project.getTeamMembers().removeIf(
                employee -> Collections.disjoint(
                        employee.getSkills(), project.getRequiredSkills()));
    }
}
