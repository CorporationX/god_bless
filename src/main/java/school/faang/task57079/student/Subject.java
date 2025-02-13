package school.faang.task57079.student;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Subject {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
