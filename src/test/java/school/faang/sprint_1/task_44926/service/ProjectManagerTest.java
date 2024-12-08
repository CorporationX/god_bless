package school.faang.sprint_1.task_44926.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_44926.entity.Employee;
import school.faang.sprint_1.task_44926.entity.Project;
import school.faang.sprint_1.task_44926.repository.EmployeeRepository;
import school.faang.sprint_1.task_44926.repository.ProjectRepository;
import school.faang.sprint_1.task_44926.stratagy.StandardTeamAssignmentStrategy;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerTest {

    private ProjectManager projectManager;
    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;

    private Project project;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    void setUp() {
        projectRepository = new ProjectRepository();
        employeeRepository = new EmployeeRepository();

        projectManager = new ProjectManager();
        projectManager.setTeamAssignmentStrategy(new StandardTeamAssignmentStrategy());

        project = new Project("Test Project", Set.of("Java", "Spring"), Set.of());
        employee1 = new Employee("Alice", Set.of("Java", "Spring"));
        employee2 = new Employee("Bob", Set.of("Python", "Django"));
        employee3 = new Employee("Charlie", Set.of("Java", "Spring"));
    }

    @Test
    void assignTeamToProject_shouldAssignTeamToProject() {
        projectRepository.addProject(project);
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);

        projectManager.assignTeamToProject(1);

        assertEquals(2, project.getTeamMembers().size());
        assertTrue(project.getTeamMembers().contains(employee1));
        assertTrue(project.getTeamMembers().contains(employee3));
    }

    @Test
    void assignTeamToProject_shouldHandleNoEmployeesMatchingSkills() {
        project = new Project("Test Project", Set.of("Go", "Rust"), Set.of());
        projectRepository.addProject(project);

        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);

        projectManager.assignTeamToProject(project.getId());

        assertTrue(project.getTeamMembers().isEmpty());
    }

    @Test
    void findProjectsForEmployee_shouldReturnCorrectProjects() {
        projectRepository.addProject(project);
        employeeRepository.addEmployee(employee1);

        Set<Project> projectsForEmployee = projectManager.findProjectsForEmployee(employee1);

        assertTrue(projectsForEmployee.contains(project));
    }

    @Test
    void findProjectsForEmployee_shouldReturnEmptyWhenNoMatchingSkills() {
        projectRepository.addProject(project);
        employeeRepository.addEmployee(employee2);

        Set<Project> projectsForEmployee = projectManager.findProjectsForEmployee(employee2);

        assertTrue(projectsForEmployee.isEmpty());
    }

    @Test
    void getTeamForProject_shouldReturnCorrectTeam() {
        Set<Employee> employees = Set.of(employee1, employee2, employee3);
        project.addTeamMembers(employees);
        projectRepository.addProject(project);

        Set<Employee> team = projectManager.getTeamForProject(project.getId());

        assertEquals(3, team.size());
        assertTrue(team.contains(employee1));
        assertTrue(team.contains(employee2));
        assertTrue(team.contains(employee3));
    }
}