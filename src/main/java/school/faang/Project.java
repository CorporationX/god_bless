package school.faang;

import java.util.List;
import java.util.Set;

public record Project(long projectId, String name, Set<String> requiredSkills, List<Employee> teamMembers) {
}
