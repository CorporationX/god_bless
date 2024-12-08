package school.faang.sprint1.task_45267.entityes;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Student {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    public Student(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
