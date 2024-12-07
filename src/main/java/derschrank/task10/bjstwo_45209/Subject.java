package derschrank.task10.bjstwo_45209;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class Subject {
    private static int maxIdOfSubject = 0;
    private final int id;
    @Setter
    private String name;

    public Subject(String name) {
        this.id = ++maxIdOfSubject;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
