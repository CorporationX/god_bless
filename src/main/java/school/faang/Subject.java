package school.faang;

import java.util.Objects;

public class Subject {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public Subject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject " + name;
    }
}
