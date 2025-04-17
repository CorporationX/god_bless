package school.faang.stream1.projectteammanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
public class Employee {
    private final int id;
    private final String name;
    private Set<String> skills;
}
