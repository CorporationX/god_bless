package school.faang.countabsences;

import school.faang.countabsences.students.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final List<Student> students = new ArrayList<>(
            List.of(
                    new Student("name_1", "faculty_1", 1),
                    new Student("name_2", "faculty_2", 3),
                    new Student("name_3", "faculty_1", 3),
                    new Student("name_4", "faculty_3", 2)
            )
    );
}