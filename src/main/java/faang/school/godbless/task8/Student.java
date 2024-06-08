package faang.school.godbless.task8;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private Integer year;
}
