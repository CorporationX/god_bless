package school.faang.task_45255.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Subject {
    @ToString.Exclude
    private final UUID id = UUID.randomUUID();
    private String title;

    public Subject(String title) throws IllegalArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }
}
