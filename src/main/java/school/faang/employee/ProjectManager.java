package school.faang.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProjectManager {
    private final List<Project> allProjects = new ArrayList<>();
    private final List<Employee> allEmployees = new ArrayList<>();
    private TeamAssignmentStrategy teamAssignmentStrategy;

    public ProjectManager() {
        this.teamAssignmentStrategy = new StandardTeamAssignmentStrategy();
    }

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.teamAssignmentStrategy = strategy;
        if (strategy instanceof BalancedTeamAssignmentStrategy) {
            ((BalancedTeamAssignmentStrategy) strategy).transferAllProjects(allProjects);
        }
    }

    public void assignTeamToProject(int projectId) {
        teamAssignmentStrategy.assignTeam(findProjectById(projectId), allEmployees);
    }

    public List<Employee> getTeamForProject(int projectId) {
        return allProjects.stream().filter(project -> project.getProjectId().equals(projectId))
                .findFirst().map(Project::getTeamMembers)
                .orElseThrow(
                        () -> new ProjectException("Project with id %s does not exist".formatted(projectId))
                );
    }

    public void addEmployee(Employee employee) {
        if (!allEmployees.contains(employee)) {
            allEmployees.add(employee);
        } else {
            throw new ProjectException("Employee " + employee.getName() + " already exists.");
        }
    }

    public void addProject(Project project) {
        if (!allProjects.contains(project)) {
            allProjects.add(project);
        } else {
            throw new ProjectException("Project " + project.getName() + " already exists.");
        }
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> projects = new ArrayList<>();
        allProjects.forEach(project -> {
            if (project.getTeamMembers().contains(employee)) {
                projects.add(project);
            }
        });
        return projects;
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        Project project = findProjectById(projectId);

        if (!project.getTeamMembers().contains(employee)) {
            project.getTeamMembers().add(employee);
        }
    }

    public void removeEmployeeFromProject(int projectId, Employee employee) {
        findProjectById(projectId).getTeamMembers().remove(employee);
    }

    public List<Employee> getTeamMembers(int projectId) {
        return findProjectById(projectId).getTeamMembers();
    }

    public List<Project> getAllProjects() {
        return List.copyOf(allProjects);
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(allEmployees);
    }

    public void removeIneligibleEmployees(Project project) {
        Project foundProject = allProjects.stream().filter(p -> p.equals(project))
                .findFirst().orElseThrow(
                        () -> new ProjectException("Project with id does not exist " + project)
                );

        foundProject.getTeamMembers().removeIf(employee ->
                !employee.getSkills().containsAll(foundProject.getRequiredSkills())
        );
    }

    public void updateEmployeeInfo(int employeeId, Set<String> skills) {
        Employee employee = allEmployees.stream().filter(e -> e.getId().equals(employeeId))
                .findFirst().orElseThrow(
                        () -> new ProjectException("Employee with id %s does not exist".formatted(employeeId))
                );

        employee.setSkills(skills);
    }

    private Project findProjectById(int projectId) {
        return allProjects.stream().filter(project -> project.getProjectId().equals(projectId))
                .findFirst().orElseThrow(
                        () -> new ProjectException("Project with id %s does not exist".formatted(projectId))
                );
    }

}
