package school.faang.management.team_project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
public class Project {
    private static int idCounter = 1;

    private final int id = idCounter++;
    private final String name;
    @Setter
    private Set<String> requiredSkills = new HashSet<>();
    private final List<Employee> teamMembers = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Set<String> requiredSkills) {
        this.name = name;
        this.requiredSkills = requiredSkills;
    }

    public boolean addTeamMember(Employee employee) {
        if (!teamMembers.contains(employee)) {
            teamMembers.add(employee);
            employee.incrementProjectCount();
            return true;
        }
        return false;
    }

    public boolean removeTeamMember(Employee employee) {
        if (teamMembers.remove(employee)) {
            employee.decrementProjectCount();
            return true;
        }
        return false;
    }

    public Set<String> getCoveredSkills() {
        return teamMembers.stream()
                .flatMap(emp -> emp.getSkills().stream())
                .collect(Collectors.toSet());
    }

    public void clearTeamMembers() {
        teamMembers.forEach(Employee::decrementProjectCount);
        teamMembers.clear();
    }
}
