package school.faang.projectteammanagement;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Employee> allEmployees = List.of(
                new Employee(0, "Mr.X", Set.of("calm", "smart", "cunning")),
                new Employee(1, "Ivan", Set.of("stress resistant", "active", "dumb")),
                new Employee(2, "Alexey", Set.of("strong", "lazy", "alcoholic")),
                new Employee(3, "Peter", Set.of("old", "calm", "cunning")),
                new Employee(4, "Marya", Set.of("stress resistant", "woman", "smart")),
                new Employee(5, "Alyona", Set.of("calm", "woman", "cunning")),
                new Employee(6, "Elizabeth", Set.of("old", "ugly", "experienced")),
                new Employee(7, "Foma", Set.of("men", "ugly", "experienced"))

        );

        List<Employee> emptyList = Collections.emptyList();
        List<Project> shapitoProjects = List.of(
                new Project(0, "Clown Squad", Set.of("dumb", "smart", "ugly", "active"), emptyList),
                new Project(1, "Administration", Set.of("stress resistant", "cunning", "calm"), emptyList),
                new Project(2, "Feeding Vultures", Set.of("experienced", "smart", "strong"), emptyList),
                new Project(3, "Acrobats", Set.of("strong", "smart", "experienced", "active"), emptyList)
        );

        ProjectManager manager = new ProjectManager(
                shapitoProjects,
                allEmployees,
//                new StandardTeamAssignmentStrategy());
                new BalancedTeamAssignmentStrategy(shapitoProjects));

        manager.assignTeamToProject(1);
        consoleOutput(shapitoProjects, manager, 1);
        manager.assignTeamToProject(2);
        consoleOutput(shapitoProjects, manager, 2);
        manager.assignTeamToProject(0);
        consoleOutput(shapitoProjects, manager, 0);
        manager.assignTeamToProject(3);
        consoleOutput(shapitoProjects, manager, 3);

    }

    private static void consoleOutput(List<Project> shapitoProjects, ProjectManager manager, int i) {
        System.out.println("\n" + shapitoProjects.get(i).getName() + ":");
        manager.getTeamForProject(i).forEach(System.out::println);
    }
}
