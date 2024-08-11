package faang.school.godbless.the_elk_query_index;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class User {
    private UUID id;
    private String name;

    public User(UUID id, String name) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.id = id;
        this.name = name;
    }
}
