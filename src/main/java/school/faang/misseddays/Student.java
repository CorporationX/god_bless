package school.faang.misseddays;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private String faculty;
    private int year;
}

@Data
@AllArgsConstructor
class FacultyAndYear{
    private String faculty;
    private int year;
}