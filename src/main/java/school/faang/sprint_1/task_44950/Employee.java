package school.faang.sprint_1.task_44950;

import java.util.Set;

public class Employee {
    public int id;
    public String name;
    public Set<String> skills;

    public Employee(int id, String name, Set<String> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "id=" + id
                + ", name='" + name
                + '\'' + '}';
    }
}
