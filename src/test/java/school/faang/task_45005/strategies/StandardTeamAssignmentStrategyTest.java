package school.faang.task_45005.strategies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.project.Project;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StandardTeamAssignmentStrategyTest: Tests for team assignment logic")
class StandardTeamAssignmentStrategyTest {

    @Test
    @DisplayName("assignTeam: should assign team correctly when all skills are covered")
    void assignTeam_shouldAssignTeamCorrectlyWhenAllSkillsAreCovered() {
        StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();
        Project project = new Project("ProjectA", Set.of("Java", "Python"));
        List<Employee> employees = List.of(
                new Employee("Alice", Set.of("Java")),
                new Employee("Bob", Set.of("Python")),
                new Employee("Charlie", Set.of("JavaScript"))
        );

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertAll("Team assignment",
                () -> assertEquals(2, assignedTeam.size()),
                () -> assertTrue(assignedTeam.stream().anyMatch(e -> e.getName().equals("Alice"))),
                () -> assertTrue(assignedTeam.stream().anyMatch(e -> e.getName().equals("Bob")))
        );
    }

    @Test
    @DisplayName("assignTeam: should return an empty team when some required skills are not covered")
    void assignTeam_shouldReturnEmptyTeamWhenRequiredSkillsAreNotCovered() {
        StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();
        Project project = new Project("ProjectB", Set.of("Java", "Kotlin"));
        List<Employee> employees = List.of(
                new Employee("Alice", Set.of("Java")),
                new Employee("Bob", Set.of("Python"))
        );

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertTrue(assignedTeam.isEmpty());
    }

    @Test
    @DisplayName("assignTeam: should not assign the same employee multiple times")
    void assignTeam_shouldNotAssignSameEmployeeMultipleTimes() {
        StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();
        Project project = new Project("ProjectC", Set.of("Java", "Python"));
        List<Employee> employees = List.of(
                new Employee("Alice", Set.of("Java", "Python"))
        );

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertEquals(1, assignedTeam.size());
        assertTrue(assignedTeam.stream().anyMatch(e -> e.getName().equals("Alice")));
    }

    @Test
    @DisplayName("assignTeam: should handle empty employee list gracefully")
    void assignTeam_shouldHandleEmptyEmployeeListGracefully() {
        StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();
        Project project = new Project("ProjectD", Set.of("Java", "Python"));
        List<Employee> employees = List.of();

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertTrue(assignedTeam.isEmpty());
    }

    @Test
    @DisplayName("assignTeam: should handle projects even when skills are minimal")
    void assignTeam_shouldHandleProjectsWithMinimalSkills() {
        StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();
        Project project = new Project("ProjectE", Set.of("AnySkill"));
        List<Employee> employees = List.of(
                new Employee("Alice", Set.of("Java")),
                new Employee("Bob", Set.of("Python"))
        );

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertTrue(assignedTeam.isEmpty());
    }
}