package school.faang.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class Project {
    private Integer projectId;
    private String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;

    public Project(Integer projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = requiredSkills;
        teamMembers = new ArrayList<>();
    }
}
