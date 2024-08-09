package university;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;
}
