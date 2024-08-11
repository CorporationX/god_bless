package faang.school.godbless.task.hashmap.count.student.absences;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {
    private final String name;
    private final String faculty;
    private final int year;

    public Student(String name, String faculty, int year) {
        if (isStringNotNullOrEmpty(name) && isStringNotNullOrEmpty(faculty)) {
            this.name = name;
            this.faculty = faculty;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Не верные данные пользователя!");
        }
    }

    public boolean isStringNotNullOrEmpty(String str) {
        return str != null && !str.isBlank();
    }
}
