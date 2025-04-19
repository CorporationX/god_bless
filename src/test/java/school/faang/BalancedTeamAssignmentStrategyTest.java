package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.BJS2_68773.BalancedTeamAssignmentStrategy;
import school.faang.BJS2_68773.Employee;
import school.faang.BJS2_68773.Project;
import school.faang.BJS2_68773.Skill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BalancedTeamAssignmentStrategyTest {
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Project project;

    @BeforeEach
    void setUp() {
        employee1 = new Employee(1L, "Anna", Set.of(Skill.JAVA, Skill.KUBERNETES));
        employee2 = new Employee(2L, "Alex", Set.of(Skill.DOCKER, Skill.SPRING));
        employee3 = new Employee(3L, "Masha", Set.of(Skill.SPRING, Skill.JAVA));
        project = new Project(1L, "Project", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER));
    }

    @Test
    void testBalancedStrategyAssignTeam() {
        Project project1 = new Project(2L, "Project1", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER));
        Project project2 = new Project(3L, "Project1", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER));
        Project project3 = new Project(4L, "Project1", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER));
        Project project4 = new Project(5L, "Project1", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER));
        Project project5 = new Project(6L, "Project1", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER));
        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);
        employee1.getProjects().add(project3);
        employee2.getProjects().add(project1);
        employee2.getProjects().add(project5);
        employee3.getProjects().add(project4);

        BalancedTeamAssignmentStrategy strategy = new BalancedTeamAssignmentStrategy();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        List<Employee> team = strategy.assignTeam(project, employees);
        team.forEach(employee -> employee.getProjects().add(project));
        project.getTeamMembers().addAll(team);

        assertNotNull(team);
        Set<Skill> combined = new HashSet<>();
        team.forEach(emp -> combined.addAll(emp.getSkills()));

        assertTrue(combined.containsAll(project.getRequiredSkills()));
        assertEquals(2, employee3.getProjects().size());
    }
}