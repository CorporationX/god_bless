package school.faang.bjs2_68908;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class Project {
    private int projectId;
    private String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;
}
