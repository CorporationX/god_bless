package school.faang.bjs2_92858;

import java.util.List;

public class DataValidator {
    private DataValidator() {}

    public static String requireNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым");
        }
        return value;
    }

    public static List<Student> requireNotNullOrEmpty(List<Student> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Команда должна содержать студентов и не может быть пустой!");
        }
        return list;
    }

    public static int requirePositiveAndRange(int value, int max) {
        if (value < 0 || value > max) {
            throw new IllegalArgumentException("Год обучения не может быть 0 или больше 7");
        }
        return value;
    }
}
