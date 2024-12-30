package school.faang.task_45005.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_45005.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Project {
    private static int idCounter = 1;

    @EqualsAndHashCode.Include
    private final int id;
    private final String name;
    private final Set<String> requiredSkills;

    @Setter
    private List<Employee> teamMembers;

    public Project(
            String name,
            Set<String> requiredSkills
    ) {
        ProjectValidator.validateName(name);
        ProjectValidator.validateRequiredSkills(requiredSkills);

        this.id = idCounter++;
        this.name = name;
        this.requiredSkills = Set.copyOf(requiredSkills);
        this.teamMembers = new ArrayList<>();

        log.debug("Created project `{}` with ID `{}`", name, id);
    }
}