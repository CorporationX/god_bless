package school.faang.project_team_management;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Employee {
    private static int count = 0;
    private final int id;
    private final String name;
    private final Set<String> skills = new HashSet<>();

    public Employee(String name) {
        this.id = ++count;
        this.name = name;
    }


}
