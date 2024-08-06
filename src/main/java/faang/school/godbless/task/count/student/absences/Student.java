package faang.school.godbless.task.count.student.absences;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {
    private final String name;
    private final String faculty;
    private final int year;

    public Student(String name, String faculty, int year) {
        if (name != null && !name.isBlank() && faculty != null && !faculty.isBlank()) {
            this.name = name;
            this.faculty = faculty;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Не верные данные пользователя!");
        }
    }
}
