package derschrank.task10.bjstwo_45209;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class Student {
    private static int maxIdOfStudent = 0;
    private final int id;
    @Setter
    private String name;

    public Student(String name) {
        this.id = ++maxIdOfStudent;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
