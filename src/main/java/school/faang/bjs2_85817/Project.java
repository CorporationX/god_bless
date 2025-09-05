package school.faang.bjs2_85817;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private int projectId;
    private String name;
    private Set<String> requiredSkills;
    private List<Employee> teamMembers;
}
