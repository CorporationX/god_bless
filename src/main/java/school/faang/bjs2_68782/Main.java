package school.faang.bjs2_68782;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        Student student = new Student("Student 1");
        Student student2 = new Student("Student 2");
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

        Set<Student> students = Set.of(student, student2);
        Set<Student> students2 = Set.of(student2);
        studentDatabase.addSubjectWithStudents(mathematics, students);
        studentDatabase.addSubjectWithStudents(sport, students2);
        studentDatabase.printSubjectInfo();
    }
}
