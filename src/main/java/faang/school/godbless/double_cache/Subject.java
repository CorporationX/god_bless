package faang.school.godbless.double_cache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private static int startId = 0;
    private int id;
    private String name;

    public Subject(String name) {
        this.id = startId++;
        this.name = name;
    }
}
