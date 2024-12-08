package school.faang.bjs245299;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Getter
@ToString
public class Subject {
    private final UUID id;
    private final String name;

    public Subject(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject student = (Subject) o;
        return Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
