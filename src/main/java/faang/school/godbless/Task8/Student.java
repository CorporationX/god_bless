package faang.school.godbless.Task8;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class Student {

    private String name;
    private String faculty;
    private int year;

    public void addToList(List<Student> students) {
        students.add(this);
    }

}
