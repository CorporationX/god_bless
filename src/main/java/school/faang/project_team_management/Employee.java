package school.faang.project_team_management;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Employee {
    private static int countId = 0;
    private int id;
    private String name;
    private Set<String> skills;
    private int projectEmployCount;

    public Employee(String name) {
        this(name, new HashSet<>());
    }

    public Employee(String name, Set<String> skills) {
        this.id = ++countId;
        this.projectEmployCount = 0;
        this.name = name;
        this.skills = skills;
    }
}
