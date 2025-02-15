import TeamManagement.Employee;
import TeamManagement.Project;
import TeamManagement.ProjectManager;
import TeamManagement.StandardTeamAssignmentStrategy;
import TeamManagement.BalancedTeamAssignmentStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

class ProjectManagerTest {
    private static final Logger logger = Logger.getLogger(ProjectManagerTest.class.getName());
    private ProjectManager manager;

    @SuppressWarnings("checkstyle:MultipleVariableDeclarations")
    protected Employee e1, e2, e3;

    @BeforeEach
    void setUp() {
        manager = new ProjectManager();
        e1 = new Employee(1, "Alice", Set.of("Java", "Hibernate"));
        e2 = new Employee(2, "Bob", Set.of("Kotlin", "SQL"));
        e3 = new Employee(3, "Charlie", Set.of("Golang", "Spring"));

        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3);

        Project p1 = new Project(101, "AI Project", Set.of("Kotlin", "SQL"));
        manager.addProject(p1);
    }

    @Test
    void testAddEmployee() {
        logger.info("Employees in manager: " + manager.getEmployees().size());
        assertEquals(3, manager.getEmployees().size());
    }

    @Test
    void testAddProject() {
        assertNotNull(manager.getTeamForProject(101));
    }

    @Test
    void testAssignTeamToProjectWithStandardStrategy() {
        manager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        manager.assignTeamToProject(101);
        List<Employee> team = manager.getTeamForProject(101);
        assertEquals(1, team.size());
        assertTrue(team.contains(e2));
    }

    @Test
    void testAssignTeamToProjectWithBalancedStrategy() {
        manager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        manager.assignTeamToProject(101);
        List<Employee> team = manager.getTeamForProject(101);
        assertEquals(1, team.size());
        assertTrue(team.contains(e2));
    }

    @Test
    void testRemoveEmployeeFromProject() {
        manager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        manager.assignTeamToProject(101);
        Project project = manager.getProjects().get(0);
        assertEquals(1, project.getTeamMembers().size());
        project.removeEmployee(e2);
        assertEquals(0, project.getTeamMembers().size());
    }
}