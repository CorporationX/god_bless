package school.faang.project.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
@Data
@EqualsAndHashCode(of = {"id", "name"})
public class Employee {

    private final int id;
    private final String name;
    private final Set<String> skills = new HashSet<>();
    private final Set<Project> projects = new HashSet<>();
}
