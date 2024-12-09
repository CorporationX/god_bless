package school.faang.task_44923;

import java.util.List;
import java.util.Set;

public record Project(int projectId, String name, Set<String> requiredSkills, List<Employee> teamMembers) {
}
