package school.faang.project_team_management;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProjectManager projectManager = new ProjectManager();
        projectManager.addEmployee(new Employee("Chubaka", new HashSet<>(Set.of("Добрый", "Общительный"))));
        projectManager.addEmployee(new Employee("Luk", new HashSet<>(Set.of("Добрый", "Стресоустойвый", "Джедай"))));
        projectManager.addEmployee(new Employee("Solo",
                new HashSet<>(Set.of("Прагматичный", "Предприимчивый", "Сокол"))));
        projectManager.addEmployee(new Employee("Waider", new HashSet<>(Set.of("Джедай", "Dark", "Любящий отец"))));

        projectManager.addProject(new Project("The Death Star", new HashSet<>(Set.of("Общительный", "Джедай"))));
        projectManager.addProject(new Project("New Korusant",
                new HashSet<>(Set.of("Добрый", "Предприимчивый", "Сокол"))));
        projectManager.addProject(new Project("At-At", new HashSet<>(Set.of("Джедай", "Dark"))));

        projectManager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());

        for (int i = 1; i < 5; i++) {
            System.out.println(projectManager.getTeamForProject(i));
        }

        projectManager.assignTeamToProject(1);
        System.out.println(projectManager.getTeamForProject(1));

        projectManager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        projectManager.assignTeamToProject(2);
        System.out.println(projectManager.getTeamForProject(2) + "\n");

        System.out.println(projectManager.findProjectForEmployee(new Employee("Chubaka",
                new HashSet<>(Set.of("Добрый", "Общительный")))));

        System.out.println(projectManager.assignEmployeeToProject(3, new Employee("Waider",
                new HashSet<>(Set.of("Джедай", "Dark", "Любящий отец")))));
        System.out.println(projectManager.getTeamForProject(3));

        projectManager.removeEmployeeFromProject(3, 5);
        System.out.println(projectManager.getTeamForProject(3));
    }
}
