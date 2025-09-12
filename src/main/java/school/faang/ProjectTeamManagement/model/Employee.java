package school.faang.ProjectTeamManagement.model;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Set<String> skills;
}
