package school.faang.sprint_1.task_44926.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@EqualsAndHashCode
@ToString
public class Project {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(1);

    private final int id;
    private final String name;
    private final Set<String> requiredSkills = new HashSet<>();
    private final Set<Employee> teamMembers = new HashSet<>();

    public Project(String name, Set<String> requiredSkills, Set<Employee> teamMembers) {
        this.id = ID_COUNTER.getAndIncrement();
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("String cannot be null or blank");
        }
        this.name = name;
        this.requiredSkills.addAll(requiredSkills);
        this.teamMembers.addAll(teamMembers);
    }

    public void addSkill(String skill) {
        if (StringUtils.isBlank(skill)) {
            throw new IllegalArgumentException("String cannot be null or blank");
        }
        requiredSkills.add(skill);
    }

    public void removeSkill(String skill) {
        requiredSkills.remove(skill);
    }

    public void addTeamMember(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        teamMembers.add(employee);
        employee.addProject(this);
    }

    public void removeTeamMember(Employee employee) {
        teamMembers.remove(employee);
        employee.removeProject(this);
    }

    public Set<String> getRequiredSkills() {
        return Set.copyOf(requiredSkills);
    }

    public Set<Employee> getTeamMembers() {
        return Set.copyOf(teamMembers);
    }

    public void addTeamMembers(Set<Employee> teamMembers) {
        this.teamMembers.addAll(teamMembers);
    }
}
