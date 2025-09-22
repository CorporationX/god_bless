package school.faang.doublecash;

import java.util.Map;

public class StudentValidator {
    //Проверка на null или пустую строку
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    //Проверка на null для объектов
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    //Проверка студента и его предметов на корректность
    public static boolean validateStudentAndSubjects(Student student, Map<Subject, Integer> subjects) {
        if (isNull(student) || isNull(subjects) || subjects.isEmpty()) {
            System.out.println("Ошибка: Студент или его предметы не могут быть null или пустыми.");
            return false;
        }
        return true;
    }

    //Проверка предмета на корректность
    public static boolean validateSubject(Subject subject) {
        if (isNull(subject) || isNullOrEmpty(subject.getName())) {
            System.out.println("Ошибка: Недопустимое имя предмета.");
            return false;
        }
        return true;
    }
}