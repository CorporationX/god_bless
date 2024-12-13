package school.faang.task_45298;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.task_45298.StudentDatabase.addGradeToSubjectGradesByStudent;
import static school.faang.task_45298.StudentDatabase.addStudentToStudentsBySubject;
import static school.faang.task_45298.StudentDatabase.addStudentToSubjectGradesByStudent;
import static school.faang.task_45298.StudentDatabase.addSubjectToStudentsBySubject;
import static school.faang.task_45298.StudentDatabase.deleteStudentFromStudentsBySubject;
import static school.faang.task_45298.StudentDatabase.deleteStudentFromSubjectGradesByStudent;
import static school.faang.task_45298.StudentDatabase.printAllFromSubjectGradesByStudent;
import static school.faang.task_45298.StudentDatabase.printAllStudentsBySubject;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> subjectGradesByStudent = new HashMap<>();
    private static final Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public static void main(String[] args) {

        Student john = new Student(1, "John");
        Student anny = new Student(2, "Anny");

        Subject physics = new Subject(1, "Physics");
        Subject mathematics = new Subject(2, "Mathematics");

        addStudentToSubjectGradesByStudent(subjectGradesByStudent, studentsBySubject, john,
                new HashMap<>(Map.of(physics, 6, mathematics, 5)));
        addStudentToSubjectGradesByStudent(subjectGradesByStudent, studentsBySubject, anny,
                new HashMap<>(Map.of(physics, 5)));

        addGradeToSubjectGradesByStudent(subjectGradesByStudent, studentsBySubject, anny, mathematics, 7);
        printAllFromSubjectGradesByStudent(subjectGradesByStudent);
        printAllStudentsBySubject(studentsBySubject);

        System.out.println();
        deleteStudentFromSubjectGradesByStudent(subjectGradesByStudent, studentsBySubject, john);
        printAllFromSubjectGradesByStudent(subjectGradesByStudent);
        printAllStudentsBySubject(studentsBySubject);

        subjectGradesByStudent.clear();
        studentsBySubject.clear();

        System.out.println();
        addSubjectToStudentsBySubject(studentsBySubject, subjectGradesByStudent, physics,
                new ArrayList<>(List.of(john, anny)));
        addSubjectToStudentsBySubject(studentsBySubject, subjectGradesByStudent, mathematics,
                new ArrayList<>(List.of(john)));

        addStudentToStudentsBySubject(studentsBySubject, subjectGradesByStudent, mathematics, anny);
        printAllStudentsBySubject(studentsBySubject);
        printAllFromSubjectGradesByStudent(subjectGradesByStudent);

        System.out.println();
        deleteStudentFromStudentsBySubject(studentsBySubject, subjectGradesByStudent, physics, john);
        printAllStudentsBySubject(studentsBySubject);
        printAllFromSubjectGradesByStudent(subjectGradesByStudent);
    }
}
