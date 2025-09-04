package school.faang.ProjectTeamManagement.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private int projectId;
    private String name;
    private Set<String> requiredSkills = new HashSet<>();
    private List<Employee> teamMembers = new ArrayList<>();

    public Project(int projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = new HashSet<>(requiredSkills);
        this.teamMembers = new ArrayList<>();
    }


}
