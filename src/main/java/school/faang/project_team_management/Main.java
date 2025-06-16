package school.faang.project_team_management;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjectManager projectManager = new ProjectManager();
        projectManager.addEmployee(new Employee("Jon"));
        projectManager.addEmployee(new Employee("Ron"));
        projectManager.addEmployee(new Employee("Ivan"));
        projectManager.addEmployee(new Employee("Vlad"));
        projectManager.addEmployee(new Employee("Kris"));
        projectManager.getEmployees().get(0).getSkills().addAll(List.of("C++", "Java"));
        projectManager.getEmployees().get(1).getSkills().addAll(List.of("C++", "PHP"));
        projectManager.getEmployees().get(2).getSkills().addAll(List.of("JS", "C++"));
        projectManager.getEmployees().get(3).getSkills().addAll(List.of("Java", "JS"));
        projectManager.getEmployees().get(4).getSkills().addAll(List.of("Java", "C++", "JS"));
        System.out.println(projectManager.getEmployees().get(1));
        projectManager.getProjects().addAll(List.of(
                new Project("BankVTB"), new Project("MTC"),
                new Project("2T"), new Project("Titan")));
        projectManager.getProjects().get(0).getRequiredSkills().addAll(List.of("Java", "C++"));
        projectManager.getProjects().get(1).getRequiredSkills().addAll(List.of("PHP", "Java"));
        projectManager.getProjects().get(2).getRequiredSkills().addAll(List.of("JS", "Java"));
        projectManager.getProjects().get(3).getRequiredSkills().addAll(List.of("Java", "C++", "PHP", "JS"));
        projectManager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        for (Project project : projectManager.getProjects()) {
            project.getTeamMembers().addAll(projectManager.getTeamAssignmentStrategy()
                    .assignTeam(project, projectManager.getEmployees()));
        }
        projectManager.removeEmployeeFromProject(2, 2);
        System.out.println(projectManager.getProjects());
        System.out.println(projectManager.getTeamMembers(4));
        projectManager.getProjects().get(2).getRequiredSkills().removeAll(List.of("Java", "JS"));
        projectManager.getProjects().get(2).getRequiredSkills().addAll(List.of("PHP", "C++"));
        projectManager.removeIneligibleEmployees(projectManager.getProjects().get(2));
        projectManager.assignEmployeeToProject(3, projectManager.getEmployees().get(1));
        System.out.println(projectManager.getProjects().get(2));
        System.out.println(projectManager.findProjectsForEmployee(projectManager.getEmployees().get(2)));
        System.out.println(projectManager.findProjectsForEmployee(projectManager.getEmployees().get(0)));

    }
}