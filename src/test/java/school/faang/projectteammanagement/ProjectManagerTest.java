package school.faang.projectteammanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerTest {
    private ProjectManager projectManager;
    List<Employee> allEmployees;
    List<Project> shapitoProjects;

    @BeforeEach
    void setUp() {
        allEmployees = new ArrayList<>(List.of(
                new Employee(0, "Mr.X", Set.of("calm", "smart", "cunning")),
                new Employee(1, "Ivan", Set.of("stress resistant", "active", "dumb")),
                new Employee(2, "Alexey", Set.of("strong", "lazy", "alcoholic")),
                new Employee(3, "Peter", Set.of("old", "calm", "cunning")),
                new Employee(4, "Marya", Set.of("stress resistant", "woman", "smart")),
                new Employee(5, "Alyona", Set.of("calm", "woman", "cunning")),
                new Employee(6, "Elizabeth", Set.of("old", "ugly", "experienced")),
                new Employee(7, "Foma", Set.of("men", "ugly", "experienced"))
        ));

        List<Employee> emptyList = Collections.emptyList();
        shapitoProjects = new ArrayList<>(List.of(
                new Project(0, "Clown Squad", Set.of("dumb", "smart", "ugly", "active"), emptyList),
                new Project(1, "Administration", Set.of("stress resistant", "cunning", "calm"), emptyList),
                new Project(2, "Feeding Vultures", Set.of("experienced", "smart", "strong"), emptyList),
                new Project(3, "Acrobats", Set.of("strong", "smart", "experienced", "active"), emptyList)
        ));

        projectManager = new ProjectManager(
                shapitoProjects,
                allEmployees,
                new StandardTeamAssignmentStrategy());
        projectManager.assignTeamToProject(1);
        projectManager.assignTeamToProject(0);
        projectManager.assignTeamToProject(2);
        projectManager.assignTeamToProject(3);
    }

    @Test
    void assignTeamToProjectStandard() {

        for (Project project : shapitoProjects) {
            assertTrue(//проверка, что хотя бы одни навык сотрудников на проекте соответствует требуемым
                    project.getTeamMembers().stream()
                            .allMatch(emp -> emp.getSkills().stream()
                                    .anyMatch(skill -> project.getRequiredSkills().contains(skill))));
            assertTrue(//проверка что все требуемые навыки на проекте покрыты навыками сотрудников
                    project.getRequiredSkills().stream()
                            .allMatch(skill ->
                                    project.getTeamMembers().stream()
                                            .anyMatch(emp -> emp.getSkills().contains(skill))));
        }
    }

    @Test
    void assignTeamToProjectBalanced() {
        projectManager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy(shapitoProjects));
        assignTeamToProjectStandard();
    }

    @Test
    void getTeamForProject() {
        for (Project project : projectManager.getCompanyProjects()) {
            List<Employee> project0Team = project.getTeamMembers();
            List<Employee> teamForProject = projectManager.getTeamForProject(project.getProjectId());
            assertEquals(project0Team, teamForProject);
        }
    }

    @Test
    void addEmployee() {
        Employee add = new Employee(8, "Josef", Set.of("smart", "experienced", "calm"));
        assertFalse(allEmployees.contains(add));
        projectManager.addEmployee(add);
        assertTrue(projectManager.getAllEmployees().contains(add));
    }

    @Test
    void findProjectsForEmployee() {
        List<Project> projectsForEmployee = projectManager.findProjectsForEmployee(allEmployees.get(5));
        assertFalse(projectsForEmployee.contains(shapitoProjects.get(0)));
        assertTrue(projectsForEmployee.contains(shapitoProjects.get(1)));
        assertFalse(projectsForEmployee.contains(shapitoProjects.get(2)));
        assertFalse(projectsForEmployee.contains(shapitoProjects.get(3)));

    }

    @Test
    void assignEmployeeToProject() {
        List<Employee> teamMembers = projectManager.getTeamMembers(1);
        Employee add = allEmployees.get(5);
        assertFalse(teamMembers.contains(add));
        projectManager.assignEmployeeToProject(1, add);
        assertFalse(teamMembers.contains(add));
    }

    @Test
    void removeEmployeeFromProject() {
        assertTrue(shapitoProjects.get(1).getTeamMembers().contains(allEmployees.get(0)));
        projectManager.removeEmployeeFromProject(1, 0);
        assertFalse(shapitoProjects.get(1).getTeamMembers().contains(allEmployees.get(0)));
    }

    @Test
    void removeIneligibleEmployees() {
        Project administration = shapitoProjects.get(1);
        Employee oldLizz = allEmployees.get(6);
        projectManager.assignEmployeeToProject(1, oldLizz);
        assertFalse(oldLizz.getSkills().stream().anyMatch(administration.getRequiredSkills()::contains));
        projectManager.removeIneligibleEmployees(administration);
        assertFalse(administration.getTeamMembers().contains(oldLizz));
    }
}