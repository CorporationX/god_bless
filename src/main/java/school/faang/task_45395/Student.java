package school.faang.task_45395;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
