package school.faang.ProjectTeamManagement;

import school.faang.ProjectTeamManagement.manager.ProjectManager;
import school.faang.ProjectTeamManagement.model.Employee;
import school.faang.ProjectTeamManagement.model.Project;
import school.faang.ProjectTeamManagement.strategy.StandardTeamAssignmentStrategy;
import school.faang.ProjectTeamManagement.strategy.BalancedTeamAssignmentStrategy;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Alice", Set.of("Java", "SQL"));
        Employee emp2 = new Employee(2, "Bob", Set.of("Java", "Python"));
        Employee emp3 = new Employee(3, "Charlie", Set.of("HTML", "CSS"));
        Employee emp4 = new Employee(4, "Diana", Set.of("Python", "SQL"));

        Project project1 = new Project(101, "Website", Set.of("Java", "HTML", "CSS"));
        Project project2 = new Project(102, "DataPipeline", Set.of("Python", "SQL"));

        List<Employee> employees = List.of(emp1, emp2, emp3, emp4);
        List<Project> projects = List.of(project1, project2);

        ProjectManager manager = new ProjectManager(employees, projects);

        manager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        manager.assignTeamToProject(101);
        manager.assignTeamToProject(102);

        System.out.println("Команда для проекта " + project1.getName() + ":");
        manager.getTeamForProject(101);

        System.out.println("\nКоманда для проекта " + project2.getName() + ":");
        manager.getTeamForProject(102);

        Map<Integer, Integer> loadMap = new HashMap<>();
        manager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy(loadMap));

        manager.assignTeamToProject(101);
        manager.assignTeamToProject(102);

        System.out.println("\nКоманда для проекта " + project1.getName() + " (Balanced):");
        manager.getTeamForProject(101);

        System.out.println("\nКоманда для проекта " + project2.getName() + " (Balanced):");
        manager.getTeamForProject(102);
    }
}