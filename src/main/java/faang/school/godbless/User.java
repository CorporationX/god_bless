package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

@Data
@EqualsAndHashCode
public class User {
    private UUID id;
    private String name;

    User(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
