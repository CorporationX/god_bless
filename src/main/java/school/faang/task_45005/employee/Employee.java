package school.faang.task_45005.employee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Employee {
    private static int idCounter = 1;

    @EqualsAndHashCode.Include
    private final int id;
    private final String name;
    private final Set<String> skills;

    public Employee(
            String name,
            Set<String> skills
    ) {
        EmployeeValidator.validateName(name);
        EmployeeValidator.validateSkills(skills);

        this.id = idCounter++;
        this.name = name;
        this.skills = Set.copyOf(skills);

        log.debug("Created employee `{}` with ID `{}`", name, id);
    }
}
