package school.faang.teammanagement;

import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class Employee {
    public static final int MAX_PROJECTS_COUNT = 3;

    private int id;
    private String name;
    private Set<String> skills;
    private List<Project> projects;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
