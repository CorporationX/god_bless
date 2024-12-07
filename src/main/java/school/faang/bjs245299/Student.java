package school.faang.bjs245299;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Student {
    private final UUID id;
    private final String name;

    public Student(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
