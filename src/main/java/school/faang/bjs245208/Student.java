package school.faang.bjs245208;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@AllArgsConstructor
@ToString
public class Student {

    private final UUID id;
    private final String name;

    public Student(String name){
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
