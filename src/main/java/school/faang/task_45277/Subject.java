package school.faang.task_45277;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Subject {
    private final UUID id;
    private final String name;

    public Subject(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}