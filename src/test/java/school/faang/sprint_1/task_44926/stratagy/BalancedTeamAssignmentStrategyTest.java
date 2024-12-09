package school.faang.sprint_1.task_44926.stratagy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_44926.entity.Employee;
import school.faang.sprint_1.task_44926.entity.Project;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BalancedTeamAssignmentStrategyTest {
    private BalancedTeamAssignmentStrategy strategy;
    private Set<Employee> employees;
    private Project project;

    Employee employee1;
    Employee employee2;
    Employee employee3;
    Employee employee4;

    @BeforeEach
    void setUp() {
        strategy = new BalancedTeamAssignmentStrategy();

        project = new Project("Test Project", Set.of("Java", "Spring"), Set.of());

        employee1 = new Employee("Alice", Set.of("Java", "Spring"));
        employee2 = new Employee("Bob", Set.of("Python", "Django"));
        employee3 = new Employee("Charlie", Set.of("Java", "Hibernate"));
        employee4 = new Employee("Diana", Set.of("Spring", "React"));

        employees = new HashSet<>(Set.of(employee1, employee2, employee3, employee4));
    }

    @Test
    void assignTeam_shouldReturnOnlyEmployeesWithRequiredSkills() {
        Set<Employee> expectedEmployees = new HashSet<>();
        expectedEmployees.add(employee1);
        expectedEmployees.add(employee3);
        expectedEmployees.add(employee4);

        Set<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertTrue(expectedEmployees.containsAll(assignedTeam));
    }

    @Test
    void assignTeam_shouldExcludeEmployeesWithExcessiveProjects() {
        Set<Employee> expectedEmployees = new HashSet<>();
        expectedEmployees.add(employee1);
        expectedEmployees.add(employee3);

        employee4.addProject(new Project("Test Project", Set.of("Java", "Spring"), Set.of()));
        employee4.addProject(new Project("Test Project", Set.of("Java", "Spring"), Set.of()));
        employee4.addProject(new Project("Test Project", Set.of("Java", "Spring"), Set.of()));

        Set<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertTrue(expectedEmployees.containsAll(assignedTeam));
    }

    @Test
    void assignTeam_shouldReturnEmptySetIfNoEmployeesMeetCriteria() {
        project = new Project("Test Project", Set.of("Go", "Kotlin"), Set.of());

        Set<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertTrue(assignedTeam.isEmpty());
    }

    @Test
    void assignTeam_shouldHandleEmptyEmployeesSet() {
        Set<Employee> assignedTeam = strategy.assignTeam(project, new HashSet<>());

        assertTrue(assignedTeam.isEmpty());
    }
}