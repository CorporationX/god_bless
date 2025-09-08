package school.faang.javacollection.projectmanagement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Project {
    private final int projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private final List<Employee> teamMembers;
}
