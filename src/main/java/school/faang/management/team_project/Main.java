package school.faang.management.team_project;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();

        Employee employee = new Employee("Иван", Set.of("A", "B", "C"));
        pm.addEmployee(employee);
        pm.addEmployee(new Employee("Мария", Set.of("D", "E", "F")));
        pm.addEmployee(new Employee("Алексей", Set.of("G")));
        pm.addEmployee(new Employee("Елена", Set.of("A", "H")));
        pm.addEmployee(new Employee("Дмитрий", Set.of("D", "I")));

        pm.addProject(new Project("Веб-приложение ABC", Set.of("A", "B", "C")));
        pm.addProject(new Project("Микросервисы ADI", Set.of("A", "D", "I")));

        System.out.println("Стандартное назначение:");
        pm.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        pm.assignTeamToProject(1);
        System.out.println("Команда проекта 1: " + pm.getTeamMembers(1));
        pm.assignTeamToProject(2);
        System.out.println("Команда проекта 2: " + pm.getTeamMembers(2));

        pm.clearProjectTeam(1);
        pm.clearProjectTeam(2);

        System.out.println("\nСбалансированное назначение:");
        pm.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        pm.assignTeamToProject(1);
        System.out.println("Команда проекта 1: " + pm.getTeamMembers(1));
        pm.assignTeamToProject(2);
        System.out.println("Команда проекта 2: " + pm.getTeamMembers(2));

        System.out.printf("\nПроекты для сотрудника %s: %s\n",
                employee.getName(), pm.findProjectsForEmployee(employee));

        pm.removeEmployeeFromProject(2, 2);
        System.out.println("Команда проекта 2 после удаления: " + pm.getTeamForProject(2));
    }
}
