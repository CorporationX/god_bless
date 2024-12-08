package school.faang.sprint_1.task_44926.service;

import lombok.Getter;
import lombok.Setter;

import school.faang.sprint_1.task_44926.entity.Employee;
import school.faang.sprint_1.task_44926.entity.Project;
import school.faang.sprint_1.task_44926.repository.EmployeeRepository;
import school.faang.sprint_1.task_44926.repository.ProjectRepository;
import school.faang.sprint_1.task_44926.stratagy.TeamAssignmentStrategy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//стоит ли дублировать (оборачивать) методы из репозитория, или можно просто дать внешним классам доступ к репозиторию
@Getter
@Setter
public class ProjectManager {
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final EmployeeRepository employeeRepository = new EmployeeRepository();
    private TeamAssignmentStrategy teamAssignmentStrategy;

    public void assignTeamToProject(int projectId) {
        Project project = projectRepository.getProjectById(projectId);
        Set<Employee> teamMembers = teamAssignmentStrategy.assignTeam(project, employeeRepository.getAllEmployees());
        project.addTeamMembers(teamMembers);
    }

    public Set<Project> findProjectsForEmployee(Employee employee) {
        Set<Project> projects = projectRepository.getAllProjects();

        return projects.stream()
                .filter(project -> {
                    Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
                    requiredSkills.retainAll(employee.getSkills());
                    return !requiredSkills.isEmpty();
                })
                .collect(Collectors.toSet());
    }

    public Set<Employee> getTeamForProject(int projectId) {
        return projectRepository.getProjectById(projectId)
                .getTeamMembers();
    }
}
