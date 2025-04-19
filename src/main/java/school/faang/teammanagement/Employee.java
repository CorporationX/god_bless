package school.faang.teammanagement;

import lombok.Data;

import java.util.Set;

@Data
public class Employee {

    private final int id;
    private final String name;
    private final Set<String> skills;
}
