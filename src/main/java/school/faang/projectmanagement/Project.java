package school.faang.projectmanagement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Project {
    private final int projectId;
    @NonNull
    private final String name;
    private final Set<String> requiredSkills;
    private final List<Employee> teamMembers;

    public void addTeamMember(Employee employee) {
        this.teamMembers.add(employee);
    }
}
