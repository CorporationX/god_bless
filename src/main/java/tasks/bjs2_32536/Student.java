package tasks.bjs2_32536;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;

    public static Student createValidated(String name, String faculty, int year) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (faculty == null || faculty.isBlank()) {
            throw new IllegalArgumentException("Факультет не может быть пустым");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Год обучения должен быть в пределах от 1 до 4");
        }

        return new Student(name, faculty, year);
    }
}
