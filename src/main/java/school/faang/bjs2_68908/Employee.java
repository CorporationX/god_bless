package school.faang.bjs2_68908;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private Set<String> skills;
    public Set<Project> projects;
}
