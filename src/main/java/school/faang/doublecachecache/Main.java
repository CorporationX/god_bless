package school.faang.doublecachecache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.doublecachecache.StudentService.printInfoAcademicPerformance;
import static school.faang.doublecachecache.SubjectService.printInfoAboutSubjectsAndStudents;
import static school.faang.doublecachecache.UniversityManagerService.addStudentAndSubject;
import static school.faang.doublecachecache.UniversityManagerService.addSubjectForExistingStudent;
import static school.faang.doublecachecache.UniversityManagerService.removeStudent;

public class Main {
    public static final Map<Student, Map<Subject, Integer>> STUDENTS = new HashMap<>();
    public static final Map<Subject, List<Student>> GROUPED_SUB_AND_STUD = new HashMap<>();
    public static final Set<Subject> SUBJECTS = new HashSet<>(Set.of(new Subject("Math"),
            new Subject("Foreign language"),
            new Subject("Computer science"),
            new Subject("Chemistry"),
            new Subject("History")));

    public static void main(String[] args) {
        addStudentAndSubject(new Student("John"), "Math", 5);
        addStudentAndSubject(new Student("Richard"), "Math", 3);
        addStudentAndSubject(new Student("Sam"), "History", 4);
        addStudentAndSubject(new Student("Leonardo"), "Chemistry", 3);
        addStudentAndSubject(new Student("Scott"), "Computer science", 4);

        addSubjectForExistingStudent("John", "Chemistry", 4);
        addSubjectForExistingStudent("John", "History", 3);
        addSubjectForExistingStudent("Leonardo", "Computer science", 4);
        addSubjectForExistingStudent("Leonardo", "Math", 5);
        addSubjectForExistingStudent("Scott", "Math", 3);
        addSubjectForExistingStudent("Sam", "History", 4);
        addSubjectForExistingStudent("Sam", "Computer science", 4);

        printInfoAcademicPerformance();
        System.out.println();
        printInfoAboutSubjectsAndStudents();

        removeStudent("John");
        removeStudent("Leonardo");

        printInfoAcademicPerformance();
        System.out.println();
        printInfoAboutSubjectsAndStudents();
    }
}
