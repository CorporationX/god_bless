package school.faang.bjs245208;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@AllArgsConstructor
@ToString
public class Subject {
    private final UUID id;
    @NotEmpty(message = "Subject name cannot be empty or null")
    private final String name;

    public Subject(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
