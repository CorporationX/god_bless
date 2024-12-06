package school.faang.task44925;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@ToString
public class Project {

    @EqualsAndHashCode.Include
    private final int id;
    private final String name;
    private final Set<String> requiredSkills;
    private final List<Employee> teamMembers;
}
