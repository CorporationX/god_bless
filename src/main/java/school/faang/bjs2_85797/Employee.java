package school.faang.bjs2_85797;

import lombok.Data;

import java.util.Objects;
import java.util.Set;

@Data
public class Employee {
    private Integer id; //id сотрудника
    private String name; //имя сотрудника
    private Set<String> skills; //набор скиллов сотрудника
    private Integer projectCount; //количество задач у сотрудника

    public Employee(Integer id, String name, Set<String> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.projectCount = 0;
    }

    public void incrementCountProjects() {
        this.projectCount++;
    }

    public void decrementCountProjects() {
        if (this.projectCount > 0) {
            this.projectCount--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name)
                && Objects.equals(skills, employee.skills) && Objects.equals(projectCount, employee.projectCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, skills, projectCount);
    }
}
