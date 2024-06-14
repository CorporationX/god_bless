package faang.school.godbless.BJS2_8197;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        if (name.isBlank()) {
            System.out.println("Некорректное имя");
            return;
        }
        if (faculty.isBlank()) {
            System.out.println("Некорректный факультет");
            return;
        }
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }
}
