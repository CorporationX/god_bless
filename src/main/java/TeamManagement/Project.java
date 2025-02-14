package TeamManagement;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

@Getter
public class Project {
    private static final Logger logger = Logger.getLogger(Project.class.getName());
    private final int projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private final List<Employee> teamMembers;

    public Project(int projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = new HashSet<>(Objects.requireNonNull(requiredSkills, "Required skills cannot be null"));
        this.teamMembers = new ArrayList<>();
        logger.info("Created TeamManagement.Project: " + this);
    }

    public void addEmployee(Employee employee) {
        teamMembers.add(Objects.requireNonNull(employee, "Employee cannot be null"));
        employee.incrementProjects();
        logger.info("Added TeamManagement.Employee " + employee.getName() + " to TeamManagement.Project " + name);
    }

    public void removeEmployee(Employee employee) {
        teamMembers.remove(Objects.requireNonNull(employee, "Employee cannot be null"));
        employee.decrementProjects();
        logger.info("Removed TeamManagement.Employee " + employee.getName() + " from TeamManagement.Project " + name);
    }

    @Override
    public String toString() {
        return String.format("TeamManagement.Project {id = %d, name = '%s', requiredSkills = %s, team = %s}",
                projectId, name, requiredSkills, teamMembers);
    }
}
