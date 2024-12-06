package school.faang.task44925;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();
        Employee employee = new Employee(5, "Sergey",
                new HashSet<>(Set.of("SQL", "C++", "C#")));

        Employee employee1 = new Employee(6, "Maxim",
                new HashSet<>(Set.of("SQL", "C++", "C#")));

        Employee employee3 = new Employee(7, "Pavel",
                new HashSet<>(Set.of("SQL", "C++", "C#")));

        pm.addEmployee(employee);
        pm.getProjects().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        pm.assignEmployeeToProject(1, employee1);
        pm.getTeamForProject(1);
        pm.getProjects().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        pm.removeIneligibleEmployees(pm.getTeamForProject(2));
        pm.getProjects().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        pm.removeEmployeeFromProject(1, 6);
        pm.getProjects().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        pm.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        pm.addEmployee(employee3);
        pm.assignTeamToProject(2);
        pm.getProjects().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        pm.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        pm.assignTeamToProject(2);
        pm.getProjects().forEach(System.out::println);


    }
}
