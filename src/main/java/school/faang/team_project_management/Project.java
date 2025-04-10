package school.faang.team_project_management;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Set;

@Getter
public class Project {
    private int projectId;
    private String name;

    @NonNull
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;
}
