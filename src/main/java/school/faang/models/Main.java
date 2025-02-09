package school.faang.models;

import school.faang.strategies.BalancedTeamAssignmentStrategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Employee> employees = new HashMap<>();
        Set<String> skills1 = Set.of("Communication", "Teamwork");
        Set<String> skills2 = Set.of("Communication", "Time Management");
        employees.put(1, new Employee(1, 1, "James", skills1));
        employees.put(2, new Employee(2, 0, "David", skills2));

        Map<Integer, Project> projects = new HashMap<>();
        projects.put(1, new Project(1, "project1", Set.of("Communication"), new HashSet<>()));
        projects.put(2, new Project(2, "project2", Set.of("Management"), new HashSet<>()));
        ProjectManager projectManager = new ProjectManager(employees, projects);
        projectManager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());

        projectManager.assignTeamToProject(1);
        projectManager.addEmployee(new Employee(3, 0, "Anton", skills2));
        System.out.println(projectManager.getTeamForProject(1));
        System.out.println(projectManager.findProjectsForEmployee(new Employee(1, 1, "James", skills1)));

        System.out.println(projectManager.assignEmployeeToProject(1,
                new Employee(5, 0, "Jane", skills1)));
        System.out.println(projectManager.removeEmployeeFromProject(1, 5));
        System.out.println(projectManager.getTeamMembers(1));

        projectManager.removeIneligibleEmployees(projects.get(2));

    }

}
