package school.faang.bjs2_85827;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Project {
    private final int projectId;
    private final String name;
    private Set<String> requiredSkills;
    private final List<Employee> teamMembers;

    public Set<String> getRequiredSkills() {
        return Collections.unmodifiableSet(requiredSkills);
    }

    public void setRequiredSkills(Set<String> newSkills) {
        this.requiredSkills = new HashSet<>(newSkills);
    }

    public List<Employee> getTeamMembers() {
        return Collections.unmodifiableList(teamMembers);
    }

    public void addTeamMember(Employee e) {
        if (!teamMembers.contains(e)) {
            teamMembers.add(e);
        }
    }

    public void removeTeamMemberById(int employeeId) {
        teamMembers.removeIf(e -> e.getId() == employeeId);
    }

    public void clearTeam() {
        teamMembers.clear();
    }

    @Override
    public String toString() {
        return String.format("Project{id=%d, name='%s', requiredSkills=%s, teamMembers=%s}",
                projectId, teamMembers, name, requiredSkills);
    }
}
