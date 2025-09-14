package school.faang.bjs2_87078;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        database.addStudentWithSubjects("Петя Петров", "Математика", 4);
        database.addStudentWithSubjects("Петя Петров", "Физика", 5);
        database.addStudentWithSubjects("Петя Петров", "История", 3);

        database.addStudentWithSubjects("Иван Иванов", "Математика", 3);
        database.addStudentWithSubjects("Иван Иванов", "Химия", 4);

        database.addStudentWithSubjects("Мария Сидорова", "История", 5);
        database.addStudentWithSubjects("Мария Сидорова", "Литература", 4);

        System.out.println("\n1. Текущее состояние:");
        database.printAllStudentsWithGrades();

        System.out.println("2. Изменяем оценку Пети по математике с 4 на 5:");
        database.assignGradeToStudentSubject("Петя Петров", "Математика", 5);

        System.out.println("\n3. Добавляем Ивану новый предмет - Биология:");
        database.assignGradeToStudentSubject("Иван Иванов", "Биология", 4);

        System.out.println("\n4. Пробуем добавить предмет несуществующему студенту:");
        database.assignGradeToStudentSubject("Анна Петрова", "География", 5);

        System.out.println("\n5. Состояние после изменений:");
        database.printAllStudentsWithGrades();

        System.out.println("6. Показываем все предметы и студентов:");
        database.printAllSubjectsWithStudents();

        System.out.println("7. Добавляем новый предмет 'География' с несколькими студентами:");
        database.addSubjectWithStudents("География",
                Arrays.asList("Петя Петров", "Мария Сидорова", "Новый Студент"));

        System.out.println("\n8. Состояние после добавления предмета:");
        database.printAllSubjectsWithStudents();

        System.out.println("9. Добавляем Ивана к предмету География:");
        database.addStudentToSubject("Иван Иванов", "География");

        System.out.println("\n10. Пробуем добавить студента к несуществующему предмету:");
        database.addStudentToSubject("Петя Петров", "Астрономия");

        System.out.println("\n11. Удаляем Петю из предмета История:");
        database.removeStudentFromSubject("Петя Петров", "История");

        System.out.println("\n12. Состояние после удаления из предмета:");
        database.printAllSubjectsWithStudents();

        System.out.println("13. Удаляем студента 'Иван Иванов':");
        database.deleteStudentWithSubjects("Иван Иванов");

        System.out.println("\n14. Пробуем удалить несуществующего студента:");
        database.deleteStudentWithSubjects("Несуществующий Студент");
    }
}