package dble.cache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@Getter
@EqualsAndHashCode
@ToString
public class Student {
    private static int idCount = 1;

    private final int id;
    private final String name;

    public Student(String name) {
        this.id = idCount++;
        this.name = Optional.ofNullable(name).orElseThrow();
    }
}
