package school.faang.teammanagement;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Project {
    private int projectId;
    private String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Project project = (Project) o;
        return projectId == project.projectId;
    }

    @Override
    public int hashCode() {
        return projectId;
    }
}
