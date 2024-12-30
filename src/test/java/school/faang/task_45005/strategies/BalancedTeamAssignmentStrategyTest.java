package school.faang.task_45005.strategies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.project.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("BalancedTeamAssignmentStrategyTest: Testing assignTeam method of BalancedTeamAssignmentStrategy")
class BalancedTeamAssignmentStrategyTest {

    @Test
    @DisplayName("assignTeam: should return correctly balanced team when skills match exactly")
    void assignTeam_shouldReturnCorrectlyBalancedTeamWhenSkillsMatchExactly() {
        BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();
        Project project = new Project("Backend Project", Set.of("Java", "Spring"));
        List<Employee> employees = List.of(
                new Employee("Alice", Set.of("Java", "Spring")),
                new Employee("Bob", Set.of("Spring", "Hibernate")),
                new Employee("Charlie", Set.of("Python"))
        );

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertAll("Verify assigned team",
                () -> assertNotNull(assignedTeam, "Assigned team should not be null"),
                () -> assertEquals(1, assignedTeam.size(), "Expected a single employee in the assigned team"),
                () -> assertTrue(assignedTeam.contains(employees.get(0)), "Expected Alice to be part of the team")
        );
    }

    @Test
    @DisplayName("assignTeam: should return team with minimum assignment count precedence")
    void assignTeam_shouldReturnTeamWithMinimumAssignmentCountPrecedence() {
        BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();

        Project project = new Project("Frontend Project", Set.of("JavaScript", "React"));
        Employee employee1 = new Employee("Alice", Set.of("JavaScript", "React"));
        Employee employee2 = new Employee("Bob", Set.of("React", "CSS"));

        project.setTeamMembers(List.of(employee1));

        List<Employee> employees = List.of(employee1, employee2);

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertAll("Verify team assignment based on minimum project count",
                () -> assertNotNull(assignedTeam, "Assigned team should not be null"),
                () -> assertEquals(1, assignedTeam.size(), "Expected a single employee in the assigned team"),
                () -> assertTrue(assignedTeam.contains(employee2), "Expected Bob to be part of the assigned team")
        );
    }

    @Test
    @DisplayName("assignTeam: should return empty team when no employee matches required skills")
    void assignTeam_shouldReturnEmptyTeamWhenNoEmployeeMatchesRequiredSkills() {
        BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();
        Project project = new Project("Database Project", Set.of("SQL", "MongoDB"));
        List<Employee> employees = List.of(
                new Employee("Alice", Set.of("JavaScript", "React")),
                new Employee("Bob", Set.of("Python", "AWS")),
                new Employee("Charlie", Set.of("Java", "Spring"))
        );

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertAll("Verify assigning no employees due to skill mismatch",
                () -> assertNotNull(assignedTeam, "Assigned team should not be null"),
                () -> assertEquals(0, assignedTeam.size(), "Expected no employees in the assigned team")
        );
    }

    @Test
    @DisplayName("assignTeam: should return complete team when multiple employees required to cover all skills")
    void assignTeam_shouldReturnCompleteTeamWhenMultipleEmployeesRequiredToCoverAllSkills() {
        BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();
        Project project = new Project("Complex Project", Set.of("Java", "Spring", "AWS"));
        List<Employee> employees = List.of(
                new Employee("Alice", Set.of("Java", "Spring")),
                new Employee("Bob", Set.of("AWS")),
                new Employee("Charlie", Set.of("Python"))
        );

        List<Employee> assignedTeam = strategy.assignTeam(project, employees);

        assertAll("Verify assigned team with multiple employees",
                () -> assertNotNull(assignedTeam, "Assigned team should not be null"),
                () -> assertEquals(2, assignedTeam.size(), "Expected exactly two employees in the assigned team"),
                () -> assertTrue(assignedTeam.contains(employees.get(0)),
                        "Expected Alice to be part of the assigned team"),
                () -> assertTrue(assignedTeam.contains(employees.get(1)),
                        "Expected Bob to be part of the assigned team")
        );
    }

    @Test
    @DisplayName("assignTeam: should handle empty employee list gracefully")
    void assignTeam_shouldHandleEmptyEmployeeListGracefully() {
        BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();
        Project project = new Project("Simple Project", Set.of("Java"));

        List<Employee> assignedTeam = strategy.assignTeam(project, new ArrayList<>());

        assertAll("Verify behavior with empty employee list",
                () -> assertNotNull(assignedTeam, "Assigned team should not be null"),
                () -> assertEquals(0, assignedTeam.size(), "Expected no employees in the assigned team")
        );
    }
}