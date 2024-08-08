package faang.school.godbless.double_cache_cache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Subject {
    private UUID id;
    private String name;

    public Subject(UUID id, String name) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (name.length() > 100) {
            throw new IllegalArgumentException("Name cannot be more than 100 characters");
        }
        this.id = id;
        this.name = name;
    }
}
