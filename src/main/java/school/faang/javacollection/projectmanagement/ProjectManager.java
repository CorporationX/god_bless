package school.faang.javacollection.projectmanagement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static school.faang.javacollection.projectmanagement.EmployeeProjectsCount.incrementEmployeeProjectsCount;
import static school.faang.javacollection.projectmanagement.EmployeeProjectsCount.decrementEmployeeProjectsCount;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class ProjectManager {

    private final List<Employee> employeeList;
    private final Map<Integer, Project> projectSet;
    private TeamAssignmentStrategy assignmentStrategy;

    public void assignTeamToProject(int projectId) {
        Project project = Optional.ofNullable(projectSet.get(projectId)).orElseThrow();
        List<Employee> requiredEmployee = assignmentStrategy.assignTeam(project, employeeList);
        project.getTeamMembers().addAll(requiredEmployee);
        projectSet.put(projectId, project);
    }

    public List<Employee> getTeamForProject(int projectId) {
        return Optional.ofNullable(projectSet.get(projectId)).orElseThrow().getTeamMembers();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> resultList = new ArrayList<>();
        Set<String> employeeSkills = employee.getSkills();
        projectSet.forEach((key, project) -> {
            if (employeeSkills.contains(project.getRequiredSkills())) {
                resultList.add(project);
            }
        });
        return resultList;
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = Optional.ofNullable(projectSet.get(projectId)).orElseThrow();
        if (employee.getSkills().containsAll(project.getRequiredSkills())) {
            project.getTeamMembers().add(employee);
            incrementEmployeeProjectsCount(employee);
        }
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Project project = Optional.ofNullable(projectSet.get(projectId)).orElseThrow();
        List<Employee> teamMembers = project.getTeamMembers();
        for (Employee employee : teamMembers) {
            if (Objects.equals(employee.getId(), employeeId)) {
                teamMembers.remove(employee);
                decrementEmployeeProjectsCount(employee);
                return;
            }
        }

    }

    public void removeIneligibleEmployees(Project project) {
        List<Employee> teamMembers = project.getTeamMembers();
        for (Employee employee : teamMembers) {
            if (employee.getSkills().contains(project.getRequiredSkills())) {
                teamMembers.remove(employee);
                decrementEmployeeProjectsCount(employee);
            }
        }
    }
}
