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
    public static final Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    public static final Map<Subject, List<Student>> groupedSubAndStud = new HashMap<>();
    public static final Set<Subject> subjects = new HashSet<>(Set.of(new Subject("Math"),
            new Subject("Foreign language"),
            new Subject("Computer science"),
            new Subject("Chemistry"),
            new Subject("History")));

    public static void main(String[] args) {
        addStudentAndSubject(new Student("John"), "Math", 5, students, subjects, groupedSubAndStud);
        addStudentAndSubject(new Student("Richard"), "Math", 3, students, subjects, groupedSubAndStud);
        addStudentAndSubject(new Student("Sam"), "History", 4, students, subjects, groupedSubAndStud);
        addStudentAndSubject(new Student("Leonardo"), "Chemistry", 3, students, subjects, groupedSubAndStud);
        addStudentAndSubject(new Student("Scott"), "Computer science", 4, students, subjects, groupedSubAndStud);

        addSubjectForExistingStudent("John", "Chemistry", 4, students, subjects, groupedSubAndStud);
        addSubjectForExistingStudent("John", "History", 3, students, subjects, groupedSubAndStud);
        addSubjectForExistingStudent("Leonardo", "Computer science", 4, students, subjects, groupedSubAndStud);
        addSubjectForExistingStudent("Leonardo", "Math", 5, students, subjects, groupedSubAndStud);
        addSubjectForExistingStudent("Scott", "Math", 3, students, subjects, groupedSubAndStud);
        addSubjectForExistingStudent("Sam", "History", 4, students, subjects, groupedSubAndStud);
        addSubjectForExistingStudent("Sam", "Computer science", 4, students, subjects, groupedSubAndStud);

        printInfoAcademicPerformance(students);
        System.out.println();
        printInfoAboutSubjectsAndStudents(groupedSubAndStud);

        removeStudent("John", students, groupedSubAndStud);
        removeStudent("Leonardo", students, groupedSubAndStud);

        printInfoAcademicPerformance(students);
        System.out.println();
        printInfoAboutSubjectsAndStudents(groupedSubAndStud);
    }
}
