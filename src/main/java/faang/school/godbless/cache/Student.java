package faang.school.godbless.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;


@Data
@AllArgsConstructor
public class Student {
    @NonNull
    private final Long id;
    @NonNull
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}