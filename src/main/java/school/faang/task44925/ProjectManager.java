package school.faang.task44925;

import lombok.Getter;

import java.util.*;

@Getter
public class ProjectManager {
    private List<Employee> employees;
    private Set<Project> projects;
    private TeamAssignmentStrategy strategy;

    public ProjectManager() {
        generateData();
    }

    private void generateData(){

        employees = new ArrayList<>(List.of(
                new Employee(1, "Alexey",
                        new HashSet<>(Set.of("C#"))),
                new Employee(2, "Sergey",
                        new HashSet<>(Set.of("C++", "SQL"))),
                new Employee(3, "Kirill",
                        new HashSet<>(Set.of("C#", "SQL"))),
                new Employee(4, "Vlad",
                        new HashSet<>(Set.of("Nothing")))
        ));


        projects = new HashSet<>(Set.of(
                new Project(1, "CodeAcademy",
                        Set.of("Java", "SQL", "C#", "C++"),
                        employees),
                new Project(2, "Database",
                        Set.of("SQL"),
                        employees),
                new Project(3, "ASP NET CORE",
                        Set.of("SQL", "C#"),
                        employees),
                new Project(4, "C++ Tutor ",
                        Set.of("C++"),
                        employees)
        ));
    }

    private void validationEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
    }

    private void validationProjectId(int projectId) {
        boolean isProjectContains = projects.stream().anyMatch(p -> p.getId() == projectId);

        if (!isProjectContains) {
            throw new IllegalArgumentException("Project does not exist");
        }
    }


    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }

        this.strategy = strategy;
    }

    public void assignTeamToProject(int projectId) {
        validationProjectId(projectId);

        if (strategy == null){
            throw new IllegalArgumentException("Choose strategy");
        }

        Project project = getProjects().stream().filter(proj -> proj.getId() == projectId).findFirst().get();
        strategy.assignTeam(project, employees);
    }

    public Project getTeamForProject(int projectId) {
        validationProjectId(projectId);
        if (projects.isEmpty()){
            throw new IllegalArgumentException("No projects found");
        }

        return projects.stream().filter(p -> p.getId() == projectId).findFirst().get();
    }

    public void addEmployee(Employee employee) {
        validationEmployee(employee);

        if (!employees.contains(employee)) {
            employees.add(employee);
            System.out.println("Employee added");
        }else{
            throw new IllegalArgumentException("Employee not added");
        }
    }

    public void removeEmployeeFromProject(int projectId, int employeeId) {
        validationProjectId(projectId);

        for (Project project : projects) {
            for (Employee employee : project.getTeamMembers()) {
                if (employee.getId() == employeeId) {
                    employees.remove(employee);
                    System.out.println(employee + " removed from project");
                    return;
                }
            }
        }

        throw new IllegalArgumentException("There is no such employee.");
    }

    public void assignEmployeeToProject(int projectId, Employee employee) {
        validationProjectId(projectId);
        validationEmployee(employee);

        Project project = projects.stream().filter(p -> p.getId() == projectId).findFirst().get();
        List<Employee> employees = project.getTeamMembers();

        if (!employees.contains(employee)) {
            employees.add(employee);
            System.out.println("Team assigned to " + employee);
            return;
        }

        throw new IllegalArgumentException("The employee was not added to the team");
    }

    public void removeIneligibleEmployees(Project project) {
        if (project == null){
            throw new IllegalArgumentException("Project cannot be null");
        }

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            Set<String> skills = employee.getSkills();
            skills.retainAll(project.getRequiredSkills());

            if (skills.isEmpty()) {
                project.getTeamMembers().remove(employee);
                i--;
            }
        }
    }
}
