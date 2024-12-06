package school.faang.task_44919;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
public class Project {
    private int projectId;
    private String name;
    private Set<String> requiredSkills;
    @Setter
    private List<Employee> teamMembers;

    public Project(int projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = requiredSkills;
    }
}
