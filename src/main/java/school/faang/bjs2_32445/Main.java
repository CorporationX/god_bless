package school.faang.bjs2_32445;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS_AND_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS_STUDYING_SUBJECT = new HashMap<>();

    public static void main(String[] args) {
        Student steve = new Student(1, "Steve");
        Map<Subject, Integer> steveSubjects = new HashMap<>();

        steveSubjects.put(new Subject(1, "Astronomy"), 4);
        steveSubjects.put(new Subject(2, "Physics"), 3);
        steveSubjects.put(new Subject(3, "Geography"), 5);

        Student bob = new Student(2, "Bob");
        Map<Subject, Integer> bobSubjects = new HashMap<>();

        bobSubjects.put(new Subject(1, "Astronomy"), 4);
        bobSubjects.put(new Subject(2, "Physics"), 3);
        bobSubjects.put(new Subject(3, "Geography"), 5);

        addNewStudent(steve, steveSubjects);

        addNewStudent(bob, bobSubjects);

        addNewSubjectForStudent(steve, new Subject(4, "Mathematics"), 4);

        addNewSubjectForStudent(bob, new Subject(4, "Mathematics"), 4);

        deleteStudent(steve);

        printStudents();

        List<Student> students = new ArrayList<>();

        students.add(steve);
        students.add(bob);

        addStudentsStudyingSubject(new Subject(4, "Mathematics"), students);

        Student eve = new Student(3, "Eve");

        addNewStudentStudyingSubject(eve, new Subject(4, "Mathematics"));

        deleteStudentFromSubject(steve);

        printSubjectsAndStudents();
    }

    public static void addNewStudent(Student student, Map<Subject, Integer> subjectsAndGrades) {
        STUDENT_SUBJECTS_AND_GRADES.putIfAbsent(student, subjectsAndGrades);
    }

    public static void addNewSubjectForStudent(Student student, Subject subject, int grade) {
       STUDENT_SUBJECTS_AND_GRADES.get(student).put(subject, grade);
    }

    public static void deleteStudent(Student student) {
        STUDENT_SUBJECTS_AND_GRADES.remove(student);
    }

    public static void printStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> student : STUDENT_SUBJECTS_AND_GRADES.entrySet()) {
            log.info("\nStudent: " + student.getKey().getName() + "\n" + "Subjects and grades: " + student.getValue().entrySet());
        }
    }

    public static void addStudentsStudyingSubject(Subject subject, List<Student> students) {
        STUDENTS_STUDYING_SUBJECT.putIfAbsent(subject, new ArrayList<>());
        STUDENTS_STUDYING_SUBJECT.put(subject, students);
    }

    public static void addNewStudentStudyingSubject(Student student, Subject subject) {
        STUDENTS_STUDYING_SUBJECT.get(subject).add(student);
    }

    public static void deleteStudentFromSubject(Student student) {
        for (Map.Entry<Subject, List<Student>> subjectListEntry : STUDENTS_STUDYING_SUBJECT.entrySet()) {
            subjectListEntry.getValue().remove(student);
        }
    }

    public static void printSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> subjectListEntry : STUDENTS_STUDYING_SUBJECT.entrySet()) {
          log.info("\nSubject: " + subjectListEntry.getKey() + "\nStudents studying this subject: " + subjectListEntry.getValue());
        }
    }
}
