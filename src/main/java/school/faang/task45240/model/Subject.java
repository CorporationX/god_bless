package school.faang.task45240.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Subject {

    private static int counter = 1;

    @EqualsAndHashCode.Exclude
    private final int id;
    private final SubjectName name;

    public Subject(SubjectName name) {

        this.id = counter++;
        this.name = name;
    }


}
