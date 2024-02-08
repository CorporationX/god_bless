package faang.school.godbless.truancy_students;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Student {
    private String name;
    private String faculty;
    private int year;
}
