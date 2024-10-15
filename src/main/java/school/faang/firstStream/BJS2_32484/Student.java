package school.faang.firstStream.BJS2_32484;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    private Faculty faculty;
    private int year;
}
