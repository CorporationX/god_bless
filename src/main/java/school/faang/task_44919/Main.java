package school.faang.task_44919;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "Alice", Set.of("Java", "Spring", "JavaScript"));
        Employee emp2 = new Employee(2, "Bob", Set.of("JavaScript", "React", "HTML"));
        Employee emp3 = new Employee(3, "Bob2", Set.of("JavaScript", "React", "CSS"));
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        List<Project> projects = new ArrayList<>();
        Project proj1 = new Project(1, "E-Commerce App", Set.of("Java", "Spring", "React"));
        Project proj2 = new Project(2, "E-Commerce App2", Set.of("JavaScript", "Spring", "React"));
        Project proj3 = new Project(3, "E-Commerce App3", Set.of("JavaScript", "HTML", "React"));
        projects.add(proj1);
        projects.add(proj2);
        projects.add(proj3);
        ProjectManager projectManager = new ProjectManager(employees, projects);
        projectManager.setStrategy(new StandardTeamAssignmentStrategy());
        projectManager.assignTeamToProject(1);
        projectManager.setStrategy(new StandardTeamAssignmentStrategy());
        projectManager.assignTeamToProject(2);
        projectManager.setStrategy(new BalancedTeamAssignmentStrategy());
        projectManager.assignTeamToProject(3);
        System.out.println(projectManager.getTeamForProject(3));

    }
}
