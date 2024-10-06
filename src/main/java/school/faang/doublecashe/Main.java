package school.faang.doublecashe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Evgen");
        Map<Subject, Integer> student1Subjects = new HashMap<>();
        student1Subjects.put(new Subject("1", "Math"), 5);
        student1Subjects.put(new Subject("2", "English"), 4);
        student1Subjects.put(new Subject("3", "Java"), 5);

        Student student2 = new Student("Dima");
        Map<Subject, Integer> student2Subjects = new HashMap<>();
        student2Subjects.put(new Subject("4", "biology"), 5);
        student2Subjects.put(new Subject("5", "Russian"), 5);
        student2Subjects.put(new Subject("3", "Java"), 5);

        Student student3 = new Student("Alina");
        Student student4 = new Student("Ira");
        Student student5 = new Student("Artyom");
        Subject chemistry = new Subject("7", "chemistry");

        var studentManagerService = new StudentsManagerService();
        studentManagerService.addStudentWithSubjects(student1, student1Subjects);
        studentManagerService.addStudentWithSubjects(student2, student2Subjects);
        studentManagerService.addSubjectWithGradeToStudent(student1, new Subject("6", "history"), 3);
        studentManagerService.deleteStudent(student1);
        studentManagerService.addSubjectWithStudents(chemistry, List.of(student3, student4, student5));
        studentManagerService.deleteStudentFromSubject(student4, chemistry);
        studentManagerService.showStudents();
        studentManagerService.showSubjects();
    }
}
