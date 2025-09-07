package school.faang.bjs2_85797;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Employee employeeOne = new Employee(1, "Oleg", Set.of("Java", "SQL", "Docker"));
        Employee employeeTwo = new Employee(2, "Anna", Set.of("Python", "GIT", "Spring"));
        Employee employeeThree = new Employee(3, "Olga", Set.of("C++", "Linux", "Algorithms"));
        Employee employeeFour = new Employee(4, "Ruslan", Set.of("C#", ".NET", "ASP.NET"));
        Employee employeeFive = new Employee(5, "Egor", Set.of("Ruby", "Rails", "PostgreSQL"));
        Employee employeeSix = new Employee(6, "Vadim", Set.of("JavaScript", "React", "Node.js"));

        List<Employee> employees = new ArrayList<>();
        employees.add(employeeOne);
        employees.add(employeeTwo);
        employees.add(employeeThree);
        employees.add(employeeFour);
        employees.add(employeeFive);
        employees.add(employeeSix);

        Project projectOne = new Project(1, "Project One", Set.of("Java", "Rails", "Node.js"));
        Project projectTwo = new Project(2, "Project Two", Set.of("Python", "Linux", ".NET"));

        Employee employeeSeven = new Employee(7, "Michail", Set.of("Python", "React",
                "ASP.NET", "Super-puper-navyk"));

        List<Project> projects = List.of(projectOne, projectTwo);

        ProjectManager projectManager = new ProjectManager(employees, projects);

        System.out.println("---------------TEST for add employee-----------------");
        projectManager.addEmployee(employeeSeven);
        System.out.println();

        System.out.println("---------------TEST for assign team to project-------");
        projectManager.assignTeamToProject(0); //id 1,5,6
        projectManager.assignTeamToProject(1); //id 2,3,4
        System.out.println("Employees for ProjectOne");
        System.out.println(projectManager.getTeamMembers(0));
        System.out.println();
        System.out.println("Employees for ProjectTwo");
        System.out.println(projectManager.getTeamMembers(1));
        System.out.println();

        System.out.println("---------------TEST for find projects for employee-------");
        projectManager.findProjectsForEmployee(employeeSeven);
        System.out.println();

        System.out.println("---------------TEST for get team for project-------");
        System.out.println("For project 0");
        projectManager.getTeamForProject(0);
        System.out.println();
        System.out.println("For project 1");
        projectManager.getTeamForProject(1);
        System.out.println();

        System.out.println("---------------TEST for assign employee to project-------");
        projectTwo.setRequiredSkills(Set.of("Python", "React", "ASP.NET", "Super-puper-navyk"));
        projectManager.assignEmployeeToProject(1, employeeSeven);
        projectManager.getTeamForProject(1);
        System.out.println();

        System.out.println("---------------TEST for remove employee from project-------");
        projectManager.removeEmployeeFromProject(1, 7);
        projectManager.getTeamForProject(1);
        projectManager.assignEmployeeToProject(1, employeeSeven);
        System.out.println();

        System.out.println("---------------TEST for remove ineligible employees-------");
        projectManager.getTeamForProject(1);
        projectManager.removeIneligibleEmployees(projectTwo);
        projectManager.getTeamForProject(1);

        System.out.println("---------------TEST for set assignment strategy-------");
        TeamAssignmentStrategy balance = new BalancedTeamAssignmentStrategy();
        TeamAssignmentStrategy standart = new StandardTeamAssignmentStrategy();

        projectManager.removeEmployeeFromProject(1, 7);
        projectManager.setAssignmentStrategy(balance);
    }
}
