package school.faang.bjs2_69940;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String [] args) {
        var studentDatabase = new StudentDatabase();

        var student1 = new Student("Студент1");
        var student2 = new Student("Студент2");

        var inf = new Subject("Информатика");
        var math = new Subject("Математика");
        var phys = new Subject("Физика");

        Map<Subject, Integer> student1Subjects = new HashMap<>();
        student1Subjects.put(inf, 30);
        student1Subjects.put(math, 10);
        student1Subjects.put(phys, 20);

        studentDatabase.addStudentWithSubjects(student1, student1Subjects);
        studentDatabase.addSubjectToStudent(student2, math, 100);

        studentDatabase.removeStudentFromSubject(student2, math);
        studentDatabase.printAllStudents();
        studentDatabase.printAllSubjects();
    }
}