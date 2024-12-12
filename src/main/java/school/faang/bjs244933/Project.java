package school.faang.bjs244933;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class Project {
    private int projectId;
    private String name;
    @NonNull
    private Set<String> requiredSkills;
    @NonNull
    private List<Employee> teamMembers;
}
