package school.faang.task57079.student;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subject {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
