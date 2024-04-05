package faang.school.godbless.doublecachecache;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Student {
    private final int id;
    private final String name;
    private static int idFromDB;

    public Student(String name) {
        this.name = name;
        this.id = ++idFromDB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
