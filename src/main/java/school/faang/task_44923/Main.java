package school.faang.task_44923;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final TeamAssignmentStrategy standardStrategy = new StandardTeamAssignmentStrategy();
    private static final TeamAssignmentStrategy balancedStrategy = new BalancedTeamAssignmentStrategy();

    private static final ProjectManager projectManager = new ProjectManager();

    public static void main(String[] args) {
        initData();

        Employee user = new Employee(11, "User", new HashSet<>(Set.of("Java", "Spring", "Hibernate")));
        projectManager.addEmployee(user);

        System.out.println(projectManager.assignEmployeeToProject(1, user));

        projectManager.setAssignmentStrategy(standardStrategy);
        projectManager.assignTeamToProject(1);
        System.out.println();

        projectManager.setAssignmentStrategy(balancedStrategy);
        projectManager.assignTeamToProject(1);
        System.out.println();

        System.out.println(user);
        projectManager.findProjectsForEmployee(user).forEach(System.out::println);
        System.out.println();

        System.out.println("Before removeEmployeeFromProject:");
        projectManager.getProjectTeam(1).forEach(System.out::println);
        System.out.println();

        projectManager.removeEmployeeFromProject(1, user.id());
        System.out.println("After removeEmployeeFromProject:");
        projectManager.getProjectTeam(1).forEach(System.out::println);
        System.out.println();

        projectManager.addEmployee(user);

        System.out.println("Before removeIneligibleEmployees:");
        projectManager.getProjectTeam(1).forEach(System.out::println);

        user.skills().clear();
        user.skills().add("Java");
        Project project1 = projectManager.getProjectById(1);
        projectManager.removeIneligibleEmployees(project1);
        System.out.println("After removeIneligibleEmployees:");
        projectManager.getProjectTeam(1).forEach(System.out::println);
    }

    private static void initData() {
        projectManager.addProject(new Project(1, "Java Development",
                new HashSet<>(Set.of("Java", "Spring", "Hibernate")), new ArrayList<>()));
        projectManager.addProject(new Project(2, "Web Development",
                new HashSet<>(Set.of("JavaScript", "React", "Node.js")), new ArrayList<>()));
        projectManager.addProject(new Project(3, "Data Science",
                new HashSet<>(Set.of("Python", "Machine Learning", "Deep Learning")), new ArrayList<>()));
        projectManager.addProject(new Project(4, "Mobile App Development",
                new HashSet<>(Set.of("Kotlin", "Android", "iOS")), new ArrayList<>()));
        projectManager.addProject(new Project(5, "Cybersecurity",
                new HashSet<>(Set.of("Network Security", "Cryptography", "Penetration Testing")), new ArrayList<>()));

        projectManager.addEmployee(new Employee(1, "John Smith",
                new HashSet<>(Set.of("Java", "Spring", "Hibernate"))));
        projectManager.addEmployee(new Employee(2, "Emily Johnson",
                new HashSet<>(Set.of("JavaScript", "React", "Node.js"))));
        projectManager.addEmployee(new Employee(3, "David Lee",
                new HashSet<>(Set.of("Python", "Machine Learning", "Deep Learning"))));
        projectManager.addEmployee(new Employee(4, "Sophia Davis",
                new HashSet<>(Set.of("Kotlin", "Android", "iOS"))));
        projectManager.addEmployee(new Employee(5, "Michael Brown",
                new HashSet<>(Set.of("Network Security", "Cryptography", "Penetration Testing"))));
        projectManager.addEmployee(new Employee(6, "Olivia Martin",
                new HashSet<>(Set.of("Java", "Spring", "Hibernate"))));
        projectManager.addEmployee(new Employee(7, "William Taylor",
                new HashSet<>(Set.of("JavaScript", "React", "Node.js"))));
        projectManager.addEmployee(new Employee(8, "Ava Thompson",
                new HashSet<>(Set.of("Python", "Machine Learning", "Deep Learning"))));
        projectManager.addEmployee(new Employee(9, "Joseph White",
                new HashSet<>(Set.of("Kotlin", "Android", "iOS"))));
        projectManager.addEmployee(new Employee(10, "Isabella Harris",
                new HashSet<>(Set.of("Network Security", "Cryptography", "Penetration Testing"))));
    }

}
