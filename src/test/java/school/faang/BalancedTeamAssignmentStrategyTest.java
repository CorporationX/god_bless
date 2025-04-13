package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BalancedTeamAssignmentStrategyTest {
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Project project;

    @BeforeEach
    void setUp() {
        employee1 = new Employee(1L, "Anna", Set.of("Java", "Kubernetes"));
        employee2 = new Employee(2L, "Alex", Set.of("Docker", "Spring"));
        employee3 = new Employee(3L, "Masha", Set.of("Spring", "Java"));
        project = new Project(1L, "Project", Set.of("Java", "Spring", "Docker"), new ArrayList<>());
    }

    @Test
    void testBalancedStrategyAssignTeam() {
        ProjectManager.PROJECTS_COUNT_BY_EMPLOYEE.put(employee1, 2);
        ProjectManager.PROJECTS_COUNT_BY_EMPLOYEE.put(employee2, 1);
        ProjectManager.PROJECTS_COUNT_BY_EMPLOYEE.put(employee3, 0);

        BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        List<Employee> team = strategy.assignTeam(project, employees);

        assertNotNull(team);
        Set<String> combined = new HashSet<>();
        team.forEach(emp -> combined.addAll(emp.skills()));

        assertTrue(combined.containsAll(project.requiredSkills()));
        assertEquals(1, ProjectManager.PROJECTS_COUNT_BY_EMPLOYEE.get(employee3));
    }
}