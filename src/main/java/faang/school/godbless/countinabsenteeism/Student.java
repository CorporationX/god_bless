package faang.school.godbless.countinabsenteeism;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Student {

    private final String NAME;
    private final String FACULTY;
    private final int YEAR;

    @Override
    public String toString() {
        return NAME + ", " + FACULTY + ", " + YEAR;
    }
}
