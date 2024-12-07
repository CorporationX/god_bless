package school.faang.task45240.model;

import lombok.Getter;
import lombok.ToString;
import java.util.Objects;

@Getter
@ToString
public class Subject {

    private static int counter = 1;
    private final int id;
    private final SubjectName name;

    public Subject(SubjectName name) {
        this.id = counter++;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return name == subject.name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
