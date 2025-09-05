package school.faang.bjs2_85817;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class Employee {
    public static final int DEFAULT_PROJECTS_COUNT = 0;

    private final int id;
    private final String name;
    private final Set<String> skills;
    private Integer projectsCount = DEFAULT_PROJECTS_COUNT;

    public void incrementProjectsCount() {
        this.projectsCount++;
    }
}
