package faang.school.godbless.BJS2_19787;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Subject {
    private static int subjectIndex = 0;
    private int id;
    @Getter
    private String name;

    public Subject(String name) {
        this.name = name;
        this.id = ++subjectIndex;
    }
}
