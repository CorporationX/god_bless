package school.faang.double_cache_cache;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        String harry = "Harry Potter";
        List<String> subjects = List.of("Potions", "Defense", "Transfiguration");
        List<Integer> marks = List.of(90, 85, 78);
        database.addNewStudentWithSubjectAndMarks(harry, subjects, marks);

        String hermione = "Hermione Granger";
        subjects = List.of("Potions", "Charms", "Ancient Runes");
        marks = List.of(100, 98, 97);
        database.addNewStudentWithSubjectAndMarks(hermione, subjects, marks);

        String ron = "Ron Weasley";
        List<String> subjects3 = List.of("Defense", "Herbology", "Flying");
        marks = List.of(75, 80, 65);
        database.addNewStudentWithSubjectAndMarks(ron, subjects, marks);

        String draco = "Draco Malfoy";
        subjects = List.of("Potions", "Defense", "Dark Arts");
        marks = List.of(88, 85, 89);
        database.addNewStudentWithSubjectAndMarks(draco, subjects, marks);

        String luna = "Luna Lovegood";
        subjects = List.of("Astronomy", "Creatures", "Charms");
        marks = List.of(91, 93, 87);
        database.addNewStudentWithSubjectAndMarks(luna, subjects, marks);

        List<Student> students = List.of(
                new Student("Cedric Diggory"),
                new Student("Neville Longbottom"),
                new Student("Cho Chang"),
                new Student("Seamus Finnigan"),
                new Student("Dean Thomas")
        );

        Subject art = new Subject("Art");
        Student daVinci = new Student("Da Vinci");

        database.showAllStudentsInfo();
        database.showAllSubjectsAndStudents();

        database.addNewSubjectToStudent("Quidditch", daVinci);
        database.addNewSubjectAndListOfStudents("Math", students);

        database.deleteAllStudentInfo("Harry Potter");
        database.addStudentToSubject(daVinci, art);

        database.showAllStudentsInfo();
        database.showAllSubjectsAndStudents();

        database.deleteStudentFromSubject(daVinci, art);

        database.showAllStudentsInfo();
        database.showAllSubjectsAndStudents();
    }
}
