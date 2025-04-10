package school.faang.double_cache_cache;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        // === Студент №1 ===
        String name1 = "Harry Potter";
        List<String> subjects1 = List.of("Potions", "Defense", "Transfiguration");
        List<Integer> marks1 = List.of(90, 85, 78);
        database.addNewStudentWithSubjectAndMarks(name1, subjects1, marks1);

        // === Студент №2 ===
        String name2 = "Hermione Granger";
        List<String> subjects2 = List.of("Potions", "Charms", "Ancient Runes");
        List<Integer> marks2 = List.of(100, 98, 97);
        database.addNewStudentWithSubjectAndMarks(name2, subjects2, marks2);

        // === Студент №3 ===
        String name3 = "Ron Weasley";
        List<String> subjects3 = List.of("Defense", "Herbology", "Flying");
        List<Integer> marks3 = List.of(75, 80, 65);
        database.addNewStudentWithSubjectAndMarks(name3, subjects3, marks3);

        // === Студент №4 ===
        String name4 = "Draco Malfoy";
        List<String> subjects4 = List.of("Potions", "Defense", "Dark Arts");
        List<Integer> marks4 = List.of(88, 85, 89);
        database.addNewStudentWithSubjectAndMarks(name4, subjects4, marks4);

        // === Студент №5 ===
        String name5 = "Luna Lovegood";
        List<String> subjects5 = List.of("Astronomy", "Creatures", "Charms");
        List<Integer> marks5 = List.of(91, 93, 87);
        database.addNewStudentWithSubjectAndMarks(name5, subjects5, marks5);


        database.showAllStudentsInfo();

        // === Пробуем добавить новый предмет только тем, у кого есть оценка 85 ===
        database.addNewSubjectToStudentWithMark("Quidditch", new Student(name1), 85); // Harry
        database.addNewSubjectToStudentWithMark("Divination", new Student(name3), 85); // Ron (не добавится)
        database.addNewSubjectToStudentWithMark("Alchemy", new Student(name4), 85);    // Draco
        // === Печатаем результат ===
        database.showAllStudentsInfo();
    }
}
