package school.faang.doublecache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Student {
    private static int currentId = 1;
    private final int id;
    private final String name;

    public Student(String name) {
        this.id = currentId++;
        this.name = name;
    }

    @Override
    public String toString() {
        return (name + "(" + id + ")");
    }
}
