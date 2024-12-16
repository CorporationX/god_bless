package school.faang.task_45255.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Student {
    @ToString.Exclude
    private final UUID id;
    private String name;

    public Student(String name) throws IllegalArgumentException {
        this.id = UUID.randomUUID();
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
}
