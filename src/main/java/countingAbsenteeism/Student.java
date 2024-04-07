package countingAbsenteeism;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student {
    private String name;
    private String faculty;
    private int year;
}
