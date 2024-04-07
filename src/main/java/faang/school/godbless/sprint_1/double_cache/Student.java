package faang.school.godbless.sprint_1.double_cache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private static int startId = 0;
    private int id;
    private String name;

    public Student(String name) {
        this.id = startId++;
        this.name = name;
    }
}
