package faang.school.godbless.BJS2_19787;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Student {
    private static int studentIndex = 0;
    private int id;
    @Getter
    private String name;

    public Student(String name) {
        this.name = name;
        this.id = ++studentIndex;
    }
}
