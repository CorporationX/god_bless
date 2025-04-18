package school.faang.bjs2_69940;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String [] args) {
        var inf = new Subject("Информатика");
        var math = new Subject("Математика");
        var phys = new Subject("Физика");

        Map<Subject, Integer> studentSubjects = new HashMap<>();
        studentSubjects.put(inf, 30);
        studentSubjects.put(math, 10);
        studentSubjects.put(phys, 20);

        var studentDatabase = new StudentDatabase();
        var student1 = new Student("Студент1");
        var student2 = new Student("Студент2");
        studentDatabase.addStudentWithSubjects(student1, studentSubjects);
        studentDatabase.addSubjectToStudent(student2, math, 100);

        studentDatabase.removeStudentFromSubject(student2, math);
        studentDatabase.printAllStudents();
        studentDatabase.printAllSubjects();
    }
}