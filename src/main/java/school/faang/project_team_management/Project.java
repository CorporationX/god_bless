package school.faang.project_team_management;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Project {
    private static int countId = 0;
    private int projectId;
    private String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;

    public Project(String name) {
        this(name, new HashSet<>());
    }

    public Project(String name, Set<String> requiredSkills) {
        this.projectId = ++countId;
        this.name = name;
        this.requiredSkills = requiredSkills;
        this.teamMembers = new ArrayList<>();
    }
}
