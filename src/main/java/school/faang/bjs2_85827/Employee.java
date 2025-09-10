package school.faang.bjs2_85827;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Employee {
    private final int id;
    private final String name;
    private final Set<String> skills;
    private int assignedProjectsCount;

    public Set<String> getSkills() {
        return Collections.unmodifiableSet(skills);
    }

    public void incrementProjectsCount() {
        assignedProjectsCount++;
    }

    public void decrementProjectCount() {
        if (assignedProjectsCount > 0) {
            assignedProjectsCount--;
        }
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', skills=%s}", id, name, skills);
    }
}
