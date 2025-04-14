package school.faang.teammanagement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class Project {
    private final int projectId;
    private final String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;

    public void addSkillToRequiredSkills(String skill) {
        requiredSkills.add(skill);
    }

    public void addTeamMember(Employee employee) {
        teamMembers.add(employee);
    }
}
