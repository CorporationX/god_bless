package school.faang.double_cache_bjs2_79726;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        Subject math = new Subject("Математика");
        Subject physics = new Subject("Физика");
        Subject chemistry = new Subject("Химия");

        Student alice = new Student("Алиса");
        Student bob = new Student("Боб");
        Student charlie = new Student("Чарли");

        Map<Subject, Integer> aliceSubjects = new HashMap<>();
        aliceSubjects.put(math, 5);
        aliceSubjects.put(physics, 4);
        db.addStudent(alice.getName(), aliceSubjects);

        Map<Subject, Integer> bobSubjects = new HashMap<>();
        bobSubjects.put(chemistry, 3);
        db.addStudent(bob.getName(), bobSubjects);

        List<Student> newSubjectStudents = new ArrayList<>();
        newSubjectStudents.add(charlie);
        newSubjectStudents.add(alice);
        db.addNewSubjectWithStudents(physics, newSubjectStudents, 0);

        db.printStudentsWithSubjects();

        db.printSubjectsWithStudents();

        db.removeStudentFromSubject(alice.getName(), physics);
        db.printStudentsWithSubjects();
        db.printSubjectsWithStudents();

        db.removeStudent(bob.getName());
        db.printStudentsWithSubjects();
        db.printSubjectsWithStudents();
    }
}
