package school.faang.task_45390;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final Map<Student, Map<Subject, Integer>> gradesByStudent = new HashMap<>();
        final Map<Subject, List<Student>> studentsBySubject = new HashMap<>();
        final StudentDatabase studentDatabase = new StudentDatabase(gradesByStudent, studentsBySubject);

        logger.info("# Creating students");
        final Student mark = new Student("Mark");
        final Student john = new Student("John");
        final Student bob = new Student("Bob");

        logger.info("# Creating subjects");
        final Subject math = new Subject("Math");
        final Subject physics = new Subject("Physics");
        final Subject chemistry = new Subject("Chemistry");

        logger.info("# Adding students with grades");
        studentDatabase.addStudentWithGrades(john, Map.of(math, 90, physics, 85));
        studentDatabase.addStudentWithGrades(bob, Map.of(math, 50));

        logger.info("# Adding subject and grade for student Bob");
        studentDatabase.addSubjectForStudent(bob, chemistry, 95);

        logger.info("# Printing all students with their grades");
        studentDatabase.printAllStudentsWithGrades();

        logger.info("# Printing all subjects and students");
        studentDatabase.printAllSubjectsAndStudents();

        logger.info("# Removing student John from the database");
        studentDatabase.removeStudent(john);

        logger.info("# First implementation without using StudentDatabase");
        myFirstTryWithoutStudentDatabase(
                gradesByStudent,
                studentsBySubject,
                john,
                mark,
                bob,
                math,
                physics,
                chemistry
        );
    }

    private static void myFirstTryWithoutStudentDatabase(
            Map<Student, Map<Subject, Integer>> gradesByStudentAndSubject,
            Map<Subject, List<Student>> studentsBySubject,
            Student john,
            Student mark,
            Student bob,
            Subject math,
            Subject physics,
            Subject chemistry
    ) {
        logger.info("# Assigning grades to students");
        addGrade(gradesByStudentAndSubject, mark, math, 5);
        addGrade(gradesByStudentAndSubject, mark, physics, 4);
        addGrade(gradesByStudentAndSubject, john, chemistry, 3);
        addGrade(gradesByStudentAndSubject, bob, math, 4);
        addGrade(gradesByStudentAndSubject, bob, chemistry, 5);

        logger.info("# Assigning students to subjects");
        addStudentToSubject(studentsBySubject, math, mark, bob);
        addStudentToSubject(studentsBySubject, chemistry, bob, john);
        addStudentToSubject(studentsBySubject, physics, mark);

        logger.info("# Validating consistency between students and their assigned subjects");
        validateStudentsBySubjectConsistency(studentsBySubject, gradesByStudentAndSubject);

        logger.info("# Print all data");
        logger.info("Grades by student and subject: {}", gradesByStudentAndSubject);
        logger.info("Students by subject: {}", studentsBySubject);
    }

    protected static void addGrade(
            Map<Student, Map<Subject, Integer>> grades,
            Student student,
            Subject subject,
            int grade
    ) {
        grades.putIfAbsent(student, new HashMap<>());
        grades.get(student).put(subject, grade);
        logger.info("Assigned grade {} to student {}", grade, student.getName());
    }

    protected static void addStudentToSubject(
            Map<Subject, List<Student>> studentsMap,
            Subject subject,
            Student... students
    ) {
        studentsMap.putIfAbsent(subject, new ArrayList<>());
        studentsMap.get(subject).addAll(Arrays.asList(students));
        logger.info("Assigned students {} to subject {}", students, subject.getName());
    }

    protected static void validateStudentsBySubjectConsistency(
            Map<Subject, List<Student>> studentsBySubject,
            Map<Student, Map<Subject, Integer>> gradesByStudentAndSubject
    ) {
        if (studentsBySubject.isEmpty() || gradesByStudentAndSubject.isEmpty()) {
            throw new IllegalArgumentException("One or both maps are empty, skipping validation");
        }

        studentsBySubject.forEach((subject, students) -> {
            for (Student student : students) {
                if (!gradesByStudentAndSubject.getOrDefault(student, new HashMap<>()).containsKey(subject)) {
                    throw new IllegalStateException(
                            "Student " + student.getName() + " is assigned to subject " + subject.getName()
                                    + " but has no grade for it."
                    );
                }
            }
        });

        logger.info("Student-subject consistency validation passed.");
    }
}