package school.faang.projectteammanagement;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class Project {
    private final int projectId;
    private final String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;
}
