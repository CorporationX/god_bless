package school.faang.task44925;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Getter
@ToString
public class Employee {
    @EqualsAndHashCode.Include
    private final int id;
    private final String name;
    private final Set<String> skills;

}
