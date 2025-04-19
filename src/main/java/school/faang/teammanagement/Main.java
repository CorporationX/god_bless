package school.faang.teammanagement;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        int passed = 0;
        int failed = 0;

        List<Runnable> tests = List.of(
                Main::testEmployeeCreation,
                Main::testProjectCreation,
                Main::testStandardStrategy,
                Main::testStandardStrategyWithMultiSkillEmployee,
                Main::testBalancedStrategy,
                Main::testBalancedStrategySingleOption,
                Main::testAssignEmployeeToProject,
                Main::testRemoveIneligibleEmployees
        );

        for (Runnable test : tests) {
            try {
                test.run();
                passed++;
            } catch (AssertionError e) {
                failed++;
                System.err.println("Test failed: " + e.getMessage());
            }
        }

        System.out.printf("Total tests: %d, Passed: %d, Failed: %d%n", passed + failed, passed, failed);
    }

    private static void testEmployeeCreation() {
        Employee emp = new Employee(1, "John Doe", Set.of("Java", "Python"));
        assert emp.getId() == 1 : "Employee ID should be 1";
        assert emp.getName().equals("John Doe") : "Employee name should be John Doe";
        assert emp.getSkills().containsAll(Set.of("Java", "Python")) : "Employee skills should include Java and Python";
        assert emp.getSkills().size() == 2 : "Employee should have 2 skills";
    }

    private static void testProjectCreation() {
        Project project = new Project(1, "Project 1", Set.of("Java"));
        assert project.getProjectId() == 1 : "Project ID should be 1";
        assert project.getName().equals("Project 1") : "Project name should be Project 1";
        assert project.getRequiredSkills().contains("Java") : "Project should require Java";
        assert project.getTeamMembers().isEmpty() : "Project team should be initially empty";
    }

    private static void testStandardStrategy() {
        Employee emp1 = new Employee(1, "Alice", Set.of("Java"));
        Employee emp2 = new Employee(2, "Bob", Set.of("Python"));
        Employee emp3 = new Employee(3, "Charlie", Set.of("Java", "Database"));

        Project project = new Project(1, "Project 1", Set.of("Java", "Python"));

        ProjectManager manager = new ProjectManager();
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);
        manager.addProject(project);

        manager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        manager.assignTeamToProject(1);

        List<Employee> team = manager.getTeamForProject(1);
        Set<String> coveredSkills = team.stream()
                .flatMap(e -> e.getSkills().stream())
                .collect(Collectors.toSet());

        assert coveredSkills.containsAll(Set.of("Java", "Python")) : "Team should cover Java and Python";
        assert team.size() == 2 : "Team should have 2 members";
        assert team.contains(emp1) && team.contains(emp2) : "Team should include Alice and Bob";
    }

    private static void testStandardStrategyWithMultiSkillEmployee() {
        Employee emp3 = new Employee(3, "Charlie", Set.of("Java", "Python"));
        Employee emp1 = new Employee(1, "Alice", Set.of("Java"));
        Employee emp2 = new Employee(2, "Bob", Set.of("Python"));

        Project project = new Project(1, "Project 1", Set.of("Java", "Python"));

        ProjectManager manager = new ProjectManager();
        manager.addEmployee(emp3);
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addProject(project);

        manager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        manager.assignTeamToProject(1);

        List<Employee> team = manager.getTeamForProject(1);
        assert team.size() == 1 : "Team should have 1 member";
        assert team.contains(emp3) : "Team should include Charlie";
    }

    private static void testBalancedStrategy() {
        Employee emp1 = new Employee(1, "Alice", Set.of("Java"));
        Employee emp2 = new Employee(2, "Bob", Set.of("Python"));
        Employee emp3 = new Employee(3, "Charlie", Set.of("Java", "Python"));

        Project project1 = new Project(1, "Project 1", Set.of("Java", "Python"));
        Project project2 = new Project(2, "Project 2", Set.of("Java"));

        ProjectManager manager = new ProjectManager();
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);
        manager.addProject(project1);
        manager.addProject(project2);

        manager.assignEmployeeToProject(2, emp3);

        manager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy(manager.getCompanyProjects()));
        manager.assignTeamToProject(1);

        List<Employee> team = manager.getTeamForProject(1);
        assert team.size() == 2 : "Team should have 2 members";
        assert team.contains(emp1) && team.contains(emp2) : "Team should include Alice and Bob";
    }

    private static void testBalancedStrategySingleOption() {
        Employee emp1 = new Employee(1, "Alice", Set.of("Java"));
        Project project = new Project(1, "Project", Set.of("Java"));

        ProjectManager manager = new ProjectManager();
        manager.addEmployee(emp1);
        manager.addProject(project);

        Project project2 = new Project(2, "Project2", Set.of("Java"));
        manager.addProject(project2);
        manager.assignEmployeeToProject(2, emp1);

        manager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy(manager.getCompanyProjects()));
        manager.assignTeamToProject(1);

        List<Employee> team = manager.getTeamForProject(1);
        assert team.size() == 1 : "Team should have 1 member";
        assert team.contains(emp1) : "Team should include Alice";
    }

    private static void testAssignEmployeeToProject() {
        Employee emp = new Employee(1, "Alice", Set.of("Java", "Python"));
        Project project = new Project(1, "Project", Set.of("Java"));

        ProjectManager manager = new ProjectManager();
        manager.addEmployee(emp);
        manager.addProject(project);

        boolean result = manager.assignEmployeeToProject(1, emp);
        assert result : "Alice should be assigned to project";

        List<Employee> team = manager.getTeamForProject(1);
        assert team.size() == 1 && team.contains(emp) : "Team should include Alice";

        Employee emp2 = new Employee(2, "Bob", Set.of("C++"));
        manager.addEmployee(emp2);
        result = manager.assignEmployeeToProject(1, emp2);
        assert !result : "Bob should not be assigned to project";
    }

    private static void testRemoveIneligibleEmployees() {
        Employee emp = new Employee(1, "Alice", Set.of("Java"));
        Project project = new Project(1, "Project", Set.of("Java", "Python"));

        ProjectManager manager = new ProjectManager();
        manager.addEmployee(emp);
        manager.addProject(project);

        manager.assignEmployeeToProject(1, emp);
        manager.removeIneligibleEmployees(project);

        List<Employee> team = manager.getTeamForProject(1);
        assert team.isEmpty() : "Team should be empty after skill change";
    }
}
