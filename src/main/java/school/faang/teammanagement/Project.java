package school.faang.teammanagement;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class Project {

    private final int projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private List<Employee> teamMembers = new ArrayList<>();
}
