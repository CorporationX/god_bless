package faang.school.godbless.bjs2_19477;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    private Faculty faculty;
    private int year;
}
