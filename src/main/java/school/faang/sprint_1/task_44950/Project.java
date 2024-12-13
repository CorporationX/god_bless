package school.faang.sprint_1.task_44950;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Project {
    public int projectId;
    public String name;
    public Set<String> requiredSkills;
    public List<Employee> teamMembers;

    public Project(int projectId, String name, Set<String> requiredSkills) {
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = requiredSkills;
        this.teamMembers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Project{"
                + "projectId=" + projectId
                + ", name='" + name
                + '\''
                + ", teamMembers=" + teamMembers + '}';
    }
}
