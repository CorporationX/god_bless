package faang.school.godbless.doublecachecache;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Subject {
    private final int id;
    private final String name;
    private static int idFromDB;

    public Subject(String name) {
        this.name = name;
        this.id = ++idFromDB;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
