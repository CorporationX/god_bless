package school.faang.team_project_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class Project {
    private int projectId;
    private String name;
    @NonNull private Set<String> requiredSkills = new HashSet<>();
    private List<Employee> teamMembers = new ArrayList<>();
}
