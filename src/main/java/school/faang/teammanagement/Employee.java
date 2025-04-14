package school.faang.teammanagement;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private Set<String> skills;
}
