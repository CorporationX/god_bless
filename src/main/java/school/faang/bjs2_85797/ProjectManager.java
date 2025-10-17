package school.faang.bjs2_85797;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    private List<Employee> employeeCompany;
    private List<Project> projectsCompany;
    private TeamAssignmentStrategy teamAssignmentStrategy;

    public ProjectManager(List<Employee> employeeCompany, List<Project> projectsCompany) {
        this.employeeCompany = employeeCompany;
        this.projectsCompany = projectsCompany;
        this.teamAssignmentStrategy = new StandardTeamAssignmentStrategy();
    }

    void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        if (strategy != null) {
            this.teamAssignmentStrategy = strategy;
        }
        System.out.println("Strategy: " + strategy);
    }

    void assignTeamToProject(int projectId) {
        if (projectsCompany == null || employeeCompany == null) {
            throw new IllegalStateException("Projects or Employees list cant be null");
        }
        if (projectId < 0 || projectId >= projectsCompany.size()) {
            throw new IllegalArgumentException("Invalid ID project");
        }
        Project project = projectsCompany.get(projectId);
        List<Employee> team = teamAssignmentStrategy.assignTeam(project, employeeCompany);
        project.setTeamMembers(team);
    }

    void getTeamForProject(int projectId) {
        if (projectsCompany == null || employeeCompany == null) {
            throw new IllegalStateException("Projects or Employees list cannot be null");
        }
        if (projectId < 0 || projectId >= projectsCompany.size()) {
            throw new IllegalArgumentException("Invalid ID project");
        }
        Project project = projectsCompany.get(projectId);
        for (Employee e : project.getTeamMembers()) {
            System.out.println("ID: " + e.getId() + ", Name: " + e.getName());
        }
    }

    void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (!employeeCompany.contains(employee)) {
            employeeCompany.add(employee);
            System.out.println("Employee " + employee.getName() + " added");
        } else {
            System.out.println("Employee already exists");
        }
    }

    void findProjectsForEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        for (Project p : projectsCompany) {
            for (String requiredSkill : p.getRequiredSkills()) {
                if (employee.getSkills().contains(requiredSkill)) {
                    System.out.println("ID project: " + p.getProjectId() + ", Name: " + p.getName());
                    break;
                }
            }
        }
    }

    void assignEmployeeToProject(int projectId, Employee employee) {
        if (projectId < 0 || projectId > projectsCompany.size()) {
            throw new IllegalArgumentException("ProjectID invalid");
        }
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        Project project = projectsCompany.get(projectId);

        boolean allSkills = employee.getSkills().containsAll(project.getRequiredSkills());
        if (allSkills) {
            if (!project.getTeamMembers().contains(employee)) {
                project.getTeamMembers().add(employee);
                employee.incrementCountProjects();
                System.out.println("Employee " + employee.getName() + " added for project " + project.getName());
            } else {
                System.out.println("Employee " + employee.getName() + " is already in the project");
            }
        } else {
            System.out.println(employee.getName() + " doesn't have all skills for this project");
        }
    }

    void removeEmployeeFromProject(int projectId, int employeeId) {
        if (projectId < 0 || projectId - 1 >= projectsCompany.size()) {
            throw new IllegalArgumentException("ProjectID invalid");
        }
        if (employeeId <= 0 || employeeId - 1 >= employeeCompany.size()) {
            throw new IllegalArgumentException("Employee invalid");
        }
        Project project = projectsCompany.get(projectId);
        Employee employee = employeeCompany.get(employeeId - 1);
        if (project == null || employee == null) {
            throw new IllegalStateException("Project or employee cannot be null");
        }
        boolean removed = project.getTeamMembers().remove(employee);
        if (removed) {
            employee.decrementCountProjects();
            System.out.println("Employee " + employee.getName()
                    + " removed from project " + project.getName());
        } else {
            System.out.println("Employee " + employee.getName()
                    + "was not in the project " + project.getName());
        }
    }

    List<Employee> getTeamMembers(int projectId) {
        if (projectId < 0 || projectId >= projectsCompany.size()) {
            throw new IllegalArgumentException("Project ID invalid");
        }
        Project project = projectsCompany.get(projectId);
        if (project == null) {
            throw new IllegalStateException("Project not found");
        }
        return new ArrayList<>(project.getTeamMembers());
    }

    void removeIneligibleEmployees(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Projects cannot be null");
        }
        project.getTeamMembers().removeIf(employee ->
                !employee.getSkills().containsAll(project.getRequiredSkills()));
        System.out.println("Project " + project.getName() + " update");
    }
}
