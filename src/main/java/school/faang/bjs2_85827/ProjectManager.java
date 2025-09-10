package school.faang.bjs2_85827;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
public class ProjectManager {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Project> projects = new HashMap<>();
    private TeamAssignmentStrategy assignmentStrategy;

    public void addEmployee(Employee employee) {
        employee.put(employee.getId(), employee);
    }

    public void addProject(Project project) {
        project.put(project.getProjectId(), project);
    }

    public void assignTeamToProject(int projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new IllegalArgumentException("The project was not found");
        }
        if (assignmentStrategy == null) {
            throw new IllegalArgumentException("The distribution strategy has not been established");
        }

        List<Employee> employeeList = new ArrayList<>(employees.values());

        List<Employee> assignedTeam = assignmentStrategy.assignTeam(project, employeeList);

        for (Employee e : project.getTeamMembers()) {
            e.decrementProjectCount();
        }
        project.clearTeam();

        for (Employee e : assignedTeam) {
            project.addTeamMember(e);
            e.incrementProjectsCount();
        }
    }

    public List<Project> findProjectForEmployee(Employee employee) {
        List<Project> suitableProjects = new ArrayList<>();
        for (Project p : projects.values()) {
            if (employee.getSkills().containsAll(p.getRequiredSkills())) {
                suitableProjects.add(p);
            }
        }
        return suitableProjects;
    }

    public boolean assignEmployeeToProject(int projectId, Employee employee) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new IllegalArgumentException("The project was not found");
        }
        if (employee.getSkills().containsAll(project.getRequiredSkills())) {
            if (!project.getTeamMembers().contains(employee)) {
                project.addTeamMember(employee);
                employee.incrementProjectsCount();
            }
            return true;
        }
        return false;
    }

    public boolean removeEmployeeFromProject(int project, int employeeId) {
        Project project = projects.get(projectId);
        if (project == null) {
            return false;
        }
        List<Employee> team = project.getTeamMembers();
        for (Employee e : team) {
            if (e.getId() == employeeId) {
                project.removeTeamMemberById(employeeId);
                e.decrementProjectCount();
                return true;
            }
        }
        return false;
    }
}
