package school.faang.cachecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> studentNotes = new HashMap<>();
    private static final Map<Subject, List<Student>> studentsOfSubject = new HashMap<>();
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "John");

        students.add(student1);
        students.add(student2);

        studentService.addStudent(student1, studentNotes, getNotes());
        studentService.addStudent(student2, studentNotes, getNotes());

        studentService.addSubjectNoteToStudent(new Student(2, "Mike"), getNotes(), studentNotes);

        studentService.removeStudent(student2, studentNotes);

        studentService.printAllStudentsWithGrades(studentNotes);

        studentService.addSubjectWithStudents(new Subject(1, "Math"), students, studentsOfSubject);

        studentService.addStudentToSubject(new Student(13, "Jake"), new Subject(85,"Math"), studentsOfSubject);

        studentService.removeStudentFromSubject(new Student(13, "Jake"), new Subject(85,"Math"), studentsOfSubject);

        studentService.printAllSubjectsWithStudents(studentsOfSubject);

        System.out.println(studentNotes);

    }

    public static Map<Subject, Integer> getNotes(){
        Map<Subject, Integer> notes = new HashMap<>();
        notes.put(new Subject(85,"Math"), 5);
        notes.put(new Subject(90,"Physics"), 4);
        notes.put(new Subject(75,"Chemistry"), 3);

        return notes;
    }
}
