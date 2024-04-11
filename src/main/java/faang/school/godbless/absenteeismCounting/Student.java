package faang.school.godbless.absenteeismCounting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Student {
    private String name;
    private String faculty;
    private int year;
}
