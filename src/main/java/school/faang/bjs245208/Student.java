package school.faang.bjs245208;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotEmpty;

import java.util.UUID;

@Getter
@AllArgsConstructor
@ToString
public class Student {

    @NotEmpty(message = "Student id cannot be empty or null")
    private final UUID id;
    @NotEmpty(message = "Student name cannot be empty or null")
    private final String name;

    public Student(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
