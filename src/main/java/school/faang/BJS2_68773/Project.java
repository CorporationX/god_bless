package school.faang.BJS2_68773;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Project {
    private final Long projectId;
    private final String name;
    private final Set<Skill> requiredSkills;
    private final List<Employee> teamMembers;

    public Project(Long projectId, String name, Set<Skill> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = requiredSkills;
        teamMembers = new ArrayList<>();
    }
}
