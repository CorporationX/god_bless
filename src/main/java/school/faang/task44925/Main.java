package school.faang.task44925;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();



        Employee employeeSergey = new Employee(5, "Sergey", new HashSet<>(Set.of("SQL", "C++", "C#")));
        pm.addEmployee(employeeSergey);
        pm.getProjects().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        Employee employeeMaxim = new Employee(6, "Maxim", new HashSet<>(Set.of("SQL", "C++", "C#")));
        pm.assignEmployeeToProject(1, employeeMaxim);
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
        Employee employeePavel = new Employee(7, "Pavel", new HashSet<>(Set.of("SQL", "C++", "C#")));
        pm.addEmployee(employeePavel);
        pm.assignTeamToProject(2);
        pm.getProjects().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        pm.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        pm.assignTeamToProject(2);
        pm.getProjects().forEach(System.out::println);


    }
}
