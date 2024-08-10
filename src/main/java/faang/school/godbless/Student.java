package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

@Data
@EqualsAndHashCode
public class Student {
    private UUID id;
    private String name;

    Student(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
