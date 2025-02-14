import java.util.Collections;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectManager {
    private static final Logger logger = Logger.getLogger(ProjectManager.class.getName());
    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();
    private TeamAssignmentStrategy strategy;

    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
        this.strategy = strategy;
        logger.info("Set assignment strategy: " + strategy.getClass().getSimpleName());
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        logger.info("Added Employee: " + employee);
    }

    public void addProject(Project project) {
        projects.add(project);
        logger.info("Added Project: " + project);
    }

    public void assignTeamToProject(int projectId) {
        Project project = findProjectById(projectId).orElseThrow(()
                -> new IllegalArgumentException("Project not found"));

        if (strategy == null) {
            throw new IllegalStateException("Assignment strategy is not set");
        }
        List<Employee> team = strategy.assignTeam(project, employees);
        team.forEach(project::addEmployee);
        logger.info("Assigned team to Project " + project.getName());
    }

    public List<Employee> getTeamForProject(int projectId) {
        return findProjectById(projectId).map(Project::getTeamMembers).orElse(Collections.emptyList());
    }

    private Optional<Project> findProjectById(int projectId) {
        return projects.stream().filter(p -> p.getProjectId() == projectId).findFirst();
    }
}
