package school.faang.bjs2_85827;

import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
public class ProjectManager {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Project> projects = new HashMap<>();
    private TeamAssignmentStrategy assignmentStrategy;

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public void addProject(Project project) {
        projects.put(project.getProjectId(), project);
    }

    public void assignTeamToProject(int projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new IllegalArgumentException("Проект не найден");
        }
        if (assignmentStrategy == null) {
            throw new IllegalArgumentException("Стратегия распределения не установлена");
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

    public List<Employee> getTeamForProject(int projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            return Collections.emptyList();
        }
        return project.getTeamMembers();
    }

    public List<Project> findProjectsForEmployee(Employee employee) {
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
            throw new IllegalArgumentException("Проект не найден");
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

    public boolean removeEmployeeFromProject(int projectId, int employeeId) {
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

    public List<Employee> getTeamMembers(int projectId) {
        return getTeamForProject(projectId);
    }

    public void removeIneligibleEmployees(Project project) {
        Set<String> requiredSkills = project.getRequiredSkills();
        List<Employee> toRemove = new ArrayList<>();
        for (Employee e : project.getTeamMembers()) {
            if (!e.getSkills().containsAll(requiredSkills)) {
                toRemove.add(e);
            }
        }
        for (Employee e : toRemove) {
            project.removeTeamMemberById(e.getId());
            e.decrementProjectCount();
        }
    }
}
