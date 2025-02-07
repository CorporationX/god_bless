package school.faang;

import java.util.List;
import java.util.Set;

public class Project {
    private final int projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private final List<Employee> teamMembers;

    public Project(int projectId, String name, Set<String> requiredSkills, List<Employee> teamMembers) {
        validateName(name);
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = requiredSkills;
        this.teamMembers = teamMembers;
    }
    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The project name can't be null or blank");
        }
    }
}
