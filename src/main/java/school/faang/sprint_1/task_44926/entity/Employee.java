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
public class Employee {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(1);

    private final int id;
    private final String name;
    private final Set<String> skills = new HashSet<>();
    private final Set<Project> projects = new HashSet<>();

    public Employee(String name, Set<String> skills) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Employee name cannot be blank.");
        }
        this.id = ID_COUNTER.getAndIncrement();
        this.name = name;
        this.skills.addAll(skills);
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public void removeSkill(String skill) {
        skills.remove(skill);
    }

    public Set<String> getSkills() {
        return Set.copyOf(skills);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public Set<Project> getProjects() {
        return Set.copyOf(projects);
    }
}
