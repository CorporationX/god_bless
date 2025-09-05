package school.faang.employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class Project {
    private final Integer projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private List<Employee> teamMembers = new ArrayList<>();
}
