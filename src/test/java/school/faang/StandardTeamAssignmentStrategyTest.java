package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.BJS2_68773.Employee;
import school.faang.BJS2_68773.Project;
import school.faang.BJS2_68773.Skill;
import school.faang.BJS2_68773.StandardTeamAssignmentStrategy;

import java.util.ArrayList;
import java.util.Arrays;
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
        employee1 = new Employee(1L, "Anna", Set.of(Skill.JAVA, Skill.DOCKER));
        employee2 = new Employee(2L, "Alex", Set.of(Skill.KUBERNETES, Skill.SPRING));
        employee3 = new Employee(3L, "Masha", Set.of(Skill.SPRING, Skill.JAVA_SCRIPT));
        List<Employee> team = new ArrayList<>();
        team.add(employee2);
        project = new Project(1L, "Project", Set.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER), team);
    }

    @Test
    void testAssignTeam() {
        StandardTeamAssignmentStrategy strategy = new StandardTeamAssignmentStrategy();
        List<Employee> team = strategy.assignTeam(project, Arrays.asList(employee1, employee3));
        team.forEach(employee -> employee.getProjects().add(project));
        project.getTeamMembers().addAll(team);

        assertNotNull(team);
        Set<Skill> combined = new HashSet<>();
        team.forEach(emp -> combined.addAll(emp.getSkills()));

        assertTrue(combined.containsAll(project.getRequiredSkills()));
    }
}