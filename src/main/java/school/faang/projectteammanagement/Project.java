package school.faang.projectteammanagement;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
public class Project {
    private final int projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private List<Employee> teamMembers;
}
