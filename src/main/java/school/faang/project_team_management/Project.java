package school.faang.project_team_management;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Project {
    private static int count = 0;
    private int projectId;
    private String name;
    private Set<String> requiredSkills = new HashSet<>();
    private List<Employee> teamMembers = new ArrayList<>();

    public Project(String name) {
        this.projectId = ++count;
        this.name = name;
    }
}