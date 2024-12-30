package school.faang.task_45005;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.project.Project;
import school.faang.task_45005.project.ProjectManager;
import school.faang.task_45005.strategies.BalancedTeamAssignmentStrategy;
import school.faang.task_45005.strategies.StandardTeamAssignmentStrategy;

import java.util.List;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();

        log.info("\n\n=== Project Addition ===");
        manager.addProject(new Project("A", Set.of("A", "B", "C", "D")));
        manager.addProject(new Project("B", Set.of("B", "C", "D")));
        manager.addProject(new Project("C", Set.of("C", "D")));
        manager.addProject(new Project("D", Set.of("D")));
        manager.addProject(new Project("F", Set.of("F")));

        log.info("\n\n=== Project Count ===");
        manager.getProjects().forEach((id, project) -> log.debug("{}={}", id, project));

        log.info("\n\n=== Employee Addition ===");
        manager.addEmployee(new Employee("Michael", Set.of("A")));
        manager.addEmployee(new Employee("Sophia", Set.of("A", "B")));
        manager.addEmployee(new Employee("Daniel", Set.of("A", "B", "C")));
        manager.addEmployee(new Employee("Rebecca", Set.of("A", "B", "C", "D")));
        manager.addEmployee(new Employee("James", Set.of("B", "C", "D")));
        manager.addEmployee(new Employee("Olivia", Set.of("C", "D")));
        manager.addEmployee(new Employee("Ethan", Set.of("D")));

        log.info("\n\n=== Employee Count ===");
        manager.getEmployees().forEach((id, employee) -> log.debug("{}={}", id, employee));

        log.info("\n\n=== Project Assignments ===");
        manager.setAssignmentStrategy(new StandardTeamAssignmentStrategy());
        manager.assignTeamToProject(1);

        log.info("\n\n=== Project Team ===");
        List<Employee> teamMembers = manager.getTeamForProject(1);
        teamMembers.forEach(member -> log.debug("{}={}", member.getName(), member.getSkills()));

        log.info("\n\n=== Employee Projects ===");
        manager.findProjectsForEmployee(2);

        log.info("\n\n=== Employee Project Assignments ===");
        Employee hero = new Employee("Hero", Set.of("A", "B", "C", "D", "F"));
        manager.addEmployee(hero);
        manager.assignEmployeeToProject(5, hero);

        log.info("\n\n=== Removing Employee From Project ===");
        log.debug(manager.getProjects().get(5).toString());
        manager.removeEmployeeFromProject(5, 8);
        log.debug(manager.getProjects().get(5).toString());

        log.info("\n\n=== Project Team ===");
        manager.getTeamMembers(1);

        log.info("\n\n=== Ineligible Employees ===");
        Project project = manager.getProjects().get(1);
        manager.removeIneligibleEmployees(project);

        log.info("\n\n=== Project Team ===");
        manager.setAssignmentStrategy(new BalancedTeamAssignmentStrategy());
        manager.assignTeamToProject(1);
        manager.getTeamMembers(1);
    }
}
