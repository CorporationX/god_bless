package school.faang.teammanagement;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
public class ProjectManager {

    private final Set<Project> companyProjects = new HashSet<>();
    private final List<Employee> companyEmployees = new ArrayList<>();
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        Optional<Project> foundProjectById = companyProjects.stream()
                .filter(project -> project.getProjectId() == projectId)
                .findFirst();

        foundProjectById.ifPresent(project -> {
            List<Employee> employees = strategy.assignTeam(project, companyEmployees);
            project.setTeamMembers(employees);
        });
    }

    public List<Employee> getTeamForProject(int projectId) {
        for (Project project : companyProjects) {
            if (project.getProjectId() == projectId) {
                return project.getTeamMembers();
            }
        }
        return new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (!companyEmployees.contains(employee)) {
            companyEmployees.add(employee);
        }
    }

    public void addProject(Project project) {
        companyProjects.add(project);
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
        List<Project> projectsSuitableForEmployee = new ArrayList<>();

        for (Project project : companyProjects) {
            if (project.getRequiredSkills().containsAll(employee.getSkills())) {
                projectsSuitableForEmployee.add(project);
            }
        }

        return projectsSuitableForEmployee;
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Optional<Project> foundProject = companyProjects.stream()
                .filter(value -> value.getProjectId() == projectId)
                .findFirst();

        return foundProject.map(project -> {
            if (!project.getTeamMembers().contains(employee)) {
                if (project.getRequiredSkills().isEmpty()
                        || employee.getSkills().containsAll(project.getRequiredSkills())) {
                    project.getTeamMembers().add(employee);
                }
            }
            return true;
        }).orElse(false);
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        Optional<Project> foundProject = companyProjects.stream()
                .filter(project -> project.getProjectId() == projectId)
                .findFirst();

        Optional<Employee> foundEmployee = companyEmployees.stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst();

        foundProject.ifPresentOrElse(
                project -> {
                    foundEmployee.ifPresentOrElse(
                            employee -> {
                                project.getTeamMembers().remove(employee);
                            }, () -> {
                                System.out.println("Employee with ID " + employeeId + " not found.");
                            });
                }, () -> {
                    System.out.println("Project with ID " + projectId + " not found.");
                });
    }

    public List<Employee> getTeamMembers(int projectId) {
        Optional<Project> foundProject = companyProjects.stream()
                .filter(project -> project.getProjectId() == projectId)
                .findFirst();

        return foundProject.map(Project::getTeamMembers).orElseGet(ArrayList::new);
    }

    public void removeIneligibleEmployees(Project project) {
        project.getTeamMembers()
                .removeIf(employee -> !employee.getSkills().containsAll(project.getRequiredSkills()));
    }
}
