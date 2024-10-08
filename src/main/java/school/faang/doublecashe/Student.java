package school.faang.doublecashe;

import java.util.UUID;
import lombok.Data;

@Data
public class Student {
    private String id;
    private String name;

    public Student(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }
}
