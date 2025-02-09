package school.faang.doublecache;

import java.util.Objects;

public record Subject(String name) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

