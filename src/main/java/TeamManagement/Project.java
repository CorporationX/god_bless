import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Getter
public class Project {
    private static final Logger logger = Logger.getLogger(Project.class.getName());
    private final int projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private final List<Employee> teamMembers = new ArrayList<>();

    public Project(int projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = new HashSet<>(requiredSkills);
        logger.info("Created Project: " + this);
    }

    public void addEmployee(Employee employee) {
        teamMembers.add(employee);
        employee.incrementProjects();
        logger.info("Added Employee " + employee.getName() + " to Project " + name);
    }

    public void removeEmployee(Employee employee) {
        teamMembers.remove(employee);
        employee.decrementProjects();
        logger.info("Removed Employee " + employee.getName() + " from Project " + name);
    }

    @Override
    public String toString() {
        return String.format("Project{id=%d, name='%s', requiredSkills=%s, team=%s}",
                projectId, name, requiredSkills, teamMembers);
    }
}
