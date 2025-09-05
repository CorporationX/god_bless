package school.faang.employee;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectManagerTest {
    private final ProjectManager projectManager = new ProjectManager();
    private final TeamAssignmentStrategy balancedTeamAssignmentStrategy = new BalancedTeamAssignmentStrategy();

    @Test
    void testAssignTeamToProjectWithStandardStrategy() {
        Project project1 = new Project(1, "Соц сеть", Set.of("Spring", "Redis", "Kafka", "java", "Elastic"));
        Project project2 = new Project(2, "Магазин", Set.of("gRpc", "GraphQL", "Mongo"));
        Project project3 = new Project(3, "Витрина", Set.of("SQL", "Spring"));

        Employee employee1 = new Employee(1, "Миша", Set.of("Spring", "gRpc", "SQL"));
        Employee employee2 = new Employee(2, "Петя", Set.of("Elastic", "gRpc", "Spring"));
        Employee employee3 = new Employee(3, "Маша", Set.of("Mongo", "Redis"));
        Employee employee4 = new Employee(4, "Катя", Set.of("SQL"));
        Employee employee5 = new Employee(5, "Вася", Set.of("python", "Fast api"));

        projectManager.addProject(project1);
        projectManager.addProject(project2);
        projectManager.addProject(project3);

        projectManager.addEmployee(employee1);
        projectManager.addEmployee(employee2);
        projectManager.addEmployee(employee3);
        projectManager.addEmployee(employee4);
        projectManager.addEmployee(employee5);

        projectManager.assignTeamToProject(project1.getProjectId());
        projectManager.assignTeamToProject(project2.getProjectId());
        projectManager.assignTeamToProject(project3.getProjectId());

        assertAll(
                () -> assertTrue(projectManager.getAllProjects().get(0).getTeamMembers()
                        .containsAll(List.of(employee1, employee2, employee3))),
                () -> assertFalse(projectManager.getAllProjects().get(0).getTeamMembers()
                        .containsAll(List.of(employee4, employee5))),
                () -> assertTrue(projectManager.getAllProjects().get(1).getTeamMembers()
                        .containsAll(List.of(employee1, employee2, employee3))),
                () -> assertFalse(projectManager.getAllProjects().get(1).getTeamMembers()
                        .containsAll(List.of(employee4, employee5))),
                () -> assertTrue(projectManager.getAllProjects().get(2).getTeamMembers()
                        .containsAll(List.of(employee1, employee2, employee4))),
                () -> assertTrue(projectManager.getAllProjects().get(2).getTeamMembers()
                        .containsAll(List.of(employee1, employee2, employee4))),
                () -> assertTrue(projectManager.getTeamForProject(project1.getProjectId())
                        .containsAll(List.of(employee1, employee2, employee3))),
                () -> assertTrue(projectManager.getTeamForProject(project2.getProjectId())
                        .containsAll(List.of(employee1, employee2, employee3))),
                () -> assertTrue(projectManager.getTeamForProject(project3.getProjectId())
                        .containsAll(List.of(employee1, employee2, employee4))),
                () -> assertTrue(projectManager.getTeamMembers(project3.getProjectId())
                        .containsAll(List.of(employee1, employee2, employee4)))
        );
    }

    @Test
    void testAssignTeamToProjectWithBalancedStrategy() {
        Project project1 = new Project(1, "Соц сеть", Set.of("Spring", "Redis", "Kafka"));
        Project project2 = new Project(2, "Магазин", Set.of("gRpc", "GraphQL", "Mongo"));
        Project project3 = new Project(3, "Витрина", Set.of("SQL", "Spring"));
        Project project4 = new Project(4, "Игра", Set.of("Redis", "Docker"));
        Project project5 = new Project(5, "Игра", Set.of("Kafka"));

        Employee superEmployee = new Employee(1, "Миша", Set.of("Spring", "Kafka", "Redis", "gRpc"));

        projectManager.addProject(project1);
        projectManager.addProject(project2);
        projectManager.addProject(project3);
        projectManager.addProject(project4);
        projectManager.addProject(project5);

        projectManager.addEmployee(superEmployee);
        projectManager.setAssignmentStrategy(balancedTeamAssignmentStrategy);
        projectManager.assignTeamToProject(project1.getProjectId());
        projectManager.assignTeamToProject(project2.getProjectId());
        projectManager.assignTeamToProject(project3.getProjectId());
        projectManager.assignTeamToProject(project4.getProjectId());
        projectManager.assignTeamToProject(project5.getProjectId());

        assertEquals(projectManager.getAllProjects().get(0).getTeamMembers(), List.of(superEmployee));
        assertEquals(projectManager.getAllProjects().get(1).getTeamMembers(), List.of(superEmployee));
        assertTrue(projectManager.getAllProjects().get(2).getTeamMembers().isEmpty());
        assertTrue(projectManager.getAllProjects().get(3).getTeamMembers().isEmpty());
        assertTrue(projectManager.getAllProjects().get(4).getTeamMembers().isEmpty());

        assertEquals(projectManager.findProjectsForEmployee(superEmployee), List.of(project1, project2));

        projectManager.assignEmployeeToProject(project3.getProjectId(), superEmployee);
        assertEquals(projectManager.getAllProjects().get(2).getTeamMembers(), List.of(superEmployee));

        projectManager.removeEmployeeFromProject(project3.getProjectId(), superEmployee);
        assertTrue(projectManager.getAllProjects().get(2).getTeamMembers().isEmpty());
    }

    @Test
    void testExceptions() {
        Project project = new Project(1, "Соц сеть", Set.of("Spring", "Redis", "Kafka"));
        Employee employee = new Employee(1, "Миша", Set.of("Spring", "gRpc", "SQL"));

        assertThrows(NoSuchElementException.class,
                () -> projectManager.removeIneligibleEmployees(project));

        assertThrows(ProjectException.class,
                () -> projectManager.getTeamMembers(project.getProjectId()));

        assertThrows(ProjectException.class,
                () -> projectManager.assignEmployeeToProject(project.getProjectId(), employee));

        assertThrows(ProjectException.class,
                () -> projectManager.assignTeamToProject(project.getProjectId()));
    }

}