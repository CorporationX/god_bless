package school.faang.task57079.student;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Student {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
