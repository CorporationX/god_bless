package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

@Data
@EqualsAndHashCode
public class Subject {
    private UUID id;
    private String name;

    Subject(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Subject " + name;
    }
}
