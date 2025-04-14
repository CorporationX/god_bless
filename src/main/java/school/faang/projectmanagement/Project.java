package school.faang.projectmanagement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
public class Project {
    private final int projectId;
    private final String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;
}