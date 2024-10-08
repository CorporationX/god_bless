package school.faang.hashhash;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Subject {

    private final int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return id == subject.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
