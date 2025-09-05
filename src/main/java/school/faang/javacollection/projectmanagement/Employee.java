package school.faang.javacollection.projectmanagement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class Employee {
    public static final int DEFAULT_PROJECTS_COUNT = 0;

    private final int id;
    private final String name;
    private final Set<String> skills;
    private Integer projectsCount = DEFAULT_PROJECTS_COUNT;
}
