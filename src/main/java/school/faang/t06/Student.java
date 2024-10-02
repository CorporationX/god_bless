package school.faang.t06;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student {

    private String name;
    private String faculty;
    private int year;
}