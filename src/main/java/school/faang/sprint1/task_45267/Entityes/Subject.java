package school.faang.sprint1.task_45267.Entityes;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Subject {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    public Subject(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}