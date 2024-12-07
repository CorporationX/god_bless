package school.faang.bjs245299;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Subject {
    private final UUID id;
    private final String name;

    public Subject(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
