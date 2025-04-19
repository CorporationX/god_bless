package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.BJS2_68773.Employee;
import school.faang.BJS2_68773.Project;
import school.faang.BJS2_68773.ProjectManager;
import school.faang.BJS2_68773.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerTest {
    private ProjectManager projectManager;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Project project;

    @BeforeEach
    void setUp() {
        projectManager = new ProjectManager();

        employee1 = new Employee(1L, "Anna", Set.of(Skill.JAVA, Skill.DOCKER));
        employee2 = new Employee(2L, "Alex", Set.of(Skill.KUBERNETES, Skill.SPRING, Skill.JAVA, Skill.DOCKER));
        employee3 = new Employee(3L, "Masha", Set.of(Skill.SPRING, Skill.JAVA_SCRIPT));
        List<Employee> team = new ArrayList<>();
        team.add(employee1);
        project = new Project(1L, "Project", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER), team);

        projectManager.addProject(project);
        projectManager.addEmployee(employee1);
        projectManager.addEmployee(employee2);
        projectManager.addEmployee(employee3);
    }

    @Test
    void testGetTeamForProject() {
        List<Employee> employees = projectManager.getTeamForProject(1L);
        assertEquals(employees.size(), project.getTeamMembers().size());
    }

    @Test
    void testFindProjectsForEmployee() {
        Set<Project> result = projectManager.findProjectsForEmployee(employee2);
        assertTrue(result.contains(project));
    }

    @Test
    void testAssignEmployeeToProject() {
        projectManager.assignEmployeeToProject(1L, employee2);

        assertTrue(project.getTeamMembers().contains(employee2));
    }

    @Test
    void testRemoveEmployeeFromProject() {
        project.getTeamMembers().add(employee2);

        projectManager.removeEmployeeFromProject(1L, 2L);

        assertFalse(project.getTeamMembers().contains(employee2));
    }

    @Test
    void testGetTeamMembers() {
        project.getTeamMembers().add(employee2);

        List<Employee> teamMembers = projectManager.getTeamMembers(1L);

        assertEquals(2, teamMembers.size());
        assertEquals(employee2, teamMembers.get(1));
    }

    @Test
    void testRemoveIneligibleEmployees() {
        Employee ineligible = new Employee(2L, "Max", Set.of(Skill.PYTHON));

        project.getTeamMembers().addAll(List.of(employee2, ineligible));

        projectManager.removeIneligibleEmployees(project);

        assertTrue(project.getTeamMembers().contains(employee2));
        assertFalse(project.getTeamMembers().contains(ineligible));
    }
}