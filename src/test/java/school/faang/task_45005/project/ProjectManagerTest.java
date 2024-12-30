package school.faang.task_45005.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.strategies.TeamAssignmentStrategy;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ProjectManagerTest: Unit tests for ProjectManager")
class ProjectManagerTest {

    @Test
    @DisplayName("assignTeamToProject: assigns team to project when strategy is set and team is defined")
    void assignTeamToProject_shouldAssignTeamSuccessfully() {
        ProjectManager manager = new ProjectManager();
        Project project = new Project("Test Project", Set.of("Java", "Spring"));
        manager.addProject(project);
        Employee employee1 = new Employee("John Doe", Set.of("Java", "Spring"));
        Employee employee2 = new Employee("Jane Smith", Set.of("Java", "Spring Boot"));
        manager.addEmployee(employee1);
        manager.addEmployee(employee2);

        TeamAssignmentStrategy strategy = (proj, availableEmployees) -> availableEmployees.stream()
                .filter(emp -> emp.getSkills().stream().anyMatch(proj.getRequiredSkills()::contains))
                .toList();
        manager.setAssignmentStrategy(strategy);

        manager.assignTeamToProject(project.getId());

        List<Employee> assignedTeam = manager.getTeamForProject(project.getId());
        assertAll("Verify team assignment",
                () -> assertNotNull(assignedTeam, "Team should not be null"),
                () -> assertEquals(2, assignedTeam.size(), "Team size should match the number of eligible employees"),
                () -> assertTrue(assignedTeam.contains(employee1), "Employee1 should be part of the team"),
                () -> assertTrue(assignedTeam.contains(employee2), "Employee2 should be part of the team")
        );
    }

    @Test
    @DisplayName("assignTeamToProject: should log warning when project does not exist")
    void assignTeamToProject_shouldLogWarningIfProjectNotExist() {
        ProjectManager manager = new ProjectManager();

        manager.assignTeamToProject(999);

        List<Employee> team = manager.getTeamForProject(999);
        assertNull(team, "Team should be null for a non-existent project");
    }

    @Test
    @DisplayName("assignTeamToProject: should log warning when no strategy is set")
    void assignTeamToProject_shouldLogWarningIfStrategyNotSet() {
        ProjectManager manager = new ProjectManager();
        Project project = new Project("Test Project", Set.of("Java", "Spring"));
        manager.addProject(project);

        manager.assignTeamToProject(project.getId());

        List<Employee> team = manager.getTeamForProject(project.getId());
        assertTrue(team.isEmpty(), "Team should be empty if no strategy is set");
    }

    @Test
    @DisplayName("assignTeamToProject: should clear old team and assign new team when strategy is set")
    void assignTeamToProject_shouldClearOldTeamAndAssignNewTeam() {
        ProjectManager manager = new ProjectManager();
        Project project = new Project("Test Project", Set.of("Java", "Spring"));
        manager.addProject(project);
        Employee employee1 = new Employee("John Doe", Set.of("Java", "Spring"));
        Employee employee2 = new Employee("Jane Smith", Set.of("SQL", "Spring Boot"));
        manager.addEmployee(employee1);
        manager.addEmployee(employee2);

        TeamAssignmentStrategy strategy1 = (proj, availableEmployees) -> List.of(employee1);
        manager.setAssignmentStrategy(strategy1);
        manager.assignTeamToProject(project.getId());

        TeamAssignmentStrategy strategy2 = (proj, availableEmployees) -> List.of(employee2);
        manager.setAssignmentStrategy(strategy2);

        manager.assignTeamToProject(project.getId());

        List<Employee> assignedTeam = manager.getTeamForProject(project.getId());
        assertAll("Check that old team is removed and new team is assigned",
                () -> assertEquals(1, assignedTeam.size(), "Only one employee should be in the team"),
                () -> assertTrue(assignedTeam.contains(employee2), "The new employee should be in the assigned team"),
                () -> assertFalse(
                        assignedTeam.contains(employee1),
                        "The original employee should no longer be in the team"
                )
        );
    }

    @Test
    @DisplayName("assignTeamToProject: should not assign team if no employees meet project requirements")
    void assignTeamToProject_shouldNotAssignTeamIfNoEligibleEmployees() {
        ProjectManager manager = new ProjectManager();
        Project project = new Project("Test Project", Set.of("Kotlin", "Spring"));
        manager.addProject(project);
        Employee employee1 = new Employee("John Doe", Set.of("Java", "MySQL"));
        manager.addEmployee(employee1);

        TeamAssignmentStrategy strategy = (proj, availableEmployees) -> availableEmployees.stream()
                .filter(emp -> emp.getSkills().stream().anyMatch(proj.getRequiredSkills()::contains))
                .toList();
        manager.setAssignmentStrategy(strategy);

        manager.assignTeamToProject(project.getId());

        List<Employee> assignedTeam = manager.getTeamForProject(project.getId());
        assertAll("Verify no team is assigned",
                () -> assertNotNull(assignedTeam, "Assigned team should not be null"),
                () -> assertTrue(assignedTeam.isEmpty(), "No team should be assigned if no employees meet requirements")
        );
    }
}