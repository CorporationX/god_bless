package school.faang.management.team_project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
public class Project {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    private final String name;
    private final Set<String> requiredSkills;
    private final List<Employee> teamMembers = new ArrayList<>();

    public Project(String name, Set<String> requiredSkills) {
        this.id = idCounter.getAndIncrement();
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
