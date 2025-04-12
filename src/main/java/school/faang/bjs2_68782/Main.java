package school.faang.bjs2_68782;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        Student student = new Student("Student 1");
        Subject mathematics = new Subject("Математика");
        Subject sport = new Subject("Физра");
        Subject music = new Subject("Музыка");
        Subject law = new Subject("Право");
        Map<Subject, Integer> allSubjectsWithGrades =
                Map.of(mathematics, 4,
                        sport, 4,
                        music, 5,
                        law, 5);
        studentDatabase.addStudentWithSubjectsAndGrade(student, allSubjectsWithGrades);
        studentDatabase.printStudentInfo();
    }
}
