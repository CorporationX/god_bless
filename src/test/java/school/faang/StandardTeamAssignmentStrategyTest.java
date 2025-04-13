package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StandardTeamAssignmentStrategyTest {
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Project project;

    @BeforeEach
    void setUp() {
        employee1 = new Employee(1L, "Anna", Set.of("Java", "Docker"));
        employee2 = new Employee(2L, "Alex", Set.of("Kubernetes", "Spring"));
        employee3 = new Employee(3L, "Masha", Set.of("Spring", "JavaScript"));
        List<Employee> team = new ArrayList<>();
        team.add(employee2);
        project = new Project(1L, "Project", Set.of("Java", "Spring", "Docker"), team);
    }

    @Test
    void testAssignTeam() {
        StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();
        List<Employee> team = strategy.assignTeam(project, List.of(employee1, employee3));

        assertNotNull(team);
        Set<String> combined = new HashSet<>();
        team.forEach(emp -> combined.addAll(emp.skills()));

        assertTrue(combined.containsAll(project.requiredSkills()));
    }
}