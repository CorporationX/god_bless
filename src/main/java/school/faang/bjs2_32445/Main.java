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

        System.out.println("!!!__Добавили новых студентов__!!!");
        System.out.println(STUDENT_SUBJECTS_AND_GRADES);
        System.out.println("_______________________________");
        System.out.println(STUDENTS_STUDYING_SUBJECT);


        addNewSubjectForStudent(steve, new Subject(4, "Mathematics"), 4);
        addNewSubjectForStudent(bob, new Subject(4, "Mathematics"), 4);

        System.out.println("!!!__Добавили предметы для существующих студентов__!!!");

        System.out.println(STUDENT_SUBJECTS_AND_GRADES);
        System.out.println("_______________________________");
        System.out.println(STUDENTS_STUDYING_SUBJECT);

        deleteStudent(steve);

        System.out.println("!!!__Удалили студента__!!!");

        System.out.println(STUDENT_SUBJECTS_AND_GRADES);
        System.out.println("_______________________________");
        System.out.println(STUDENTS_STUDYING_SUBJECT);


        List<Student> students = new ArrayList<>();
        students.add(steve);
        students.add(bob);

        addNewSubjectAndListOfStudents(new Subject(5, "Geometry"), students);

        System.out.println("!!!__Добавление нового предмета и списка студентов, изучающих его__!!!");

        System.out.println(STUDENT_SUBJECTS_AND_GRADES);
        System.out.println("_______________________________");
        System.out.println(STUDENTS_STUDYING_SUBJECT);


        Student eve = new Student(3, "Eve");

        addNewStudentToExistingSubject(eve, new Subject(3, "Geography"), 2);

        System.out.println("!!!__Добавление студента к существующему предмету__!!!");

        System.out.println(STUDENT_SUBJECTS_AND_GRADES);
        System.out.println("_______________________________");
        System.out.println(STUDENTS_STUDYING_SUBJECT);


        deleteStudentFromSubject(eve, new Subject(4, "Mathematics"));

        System.out.println("!!!__Удаление студента из предмета__!!!");

        System.out.println(STUDENT_SUBJECTS_AND_GRADES);
        System.out.println("_______________________________");
        System.out.println(STUDENTS_STUDYING_SUBJECT);
    }

    public static void addNewStudent(Student student, Map<Subject, Integer> subjectsAndGrades) {
        STUDENT_SUBJECTS_AND_GRADES.putIfAbsent(student, subjectsAndGrades);

        for (Map.Entry<Subject, Integer> entry : subjectsAndGrades.entrySet()) {
            STUDENTS_STUDYING_SUBJECT.putIfAbsent(entry.getKey(), new ArrayList<>());
            STUDENTS_STUDYING_SUBJECT.get(entry.getKey()).add(student);
        }
    }

    public static void addNewSubjectForStudent(Student student, Subject subject, int grade) {
        STUDENT_SUBJECTS_AND_GRADES.get(student).put(subject, grade);

        STUDENTS_STUDYING_SUBJECT.putIfAbsent(subject, new ArrayList<>());
        STUDENTS_STUDYING_SUBJECT.get(subject).add(student);
    }

    public static void deleteStudent(Student student) {
        STUDENT_SUBJECTS_AND_GRADES.forEach((key, value) -> {
            if (key.equals(student)) {
                value.forEach((s, g) -> {
                    if (STUDENTS_STUDYING_SUBJECT.containsKey(s)) {
                        STUDENTS_STUDYING_SUBJECT.get(s).remove(student);
                    }
                });
            }
        });

        STUDENT_SUBJECTS_AND_GRADES.remove(student);

    }

    public static void printStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> student : STUDENT_SUBJECTS_AND_GRADES.entrySet()) {
            log.info("\nStudent: " + student.getKey().getName() + "\n" + "Subjects and grades: " + student.getValue().entrySet());
        }
    }

    public static void addNewSubjectAndListOfStudents(Subject subject, List<Student> students) {
        for (Student student : students) {
            STUDENT_SUBJECTS_AND_GRADES.putIfAbsent(student, new HashMap<>());
            STUDENT_SUBJECTS_AND_GRADES.get(student).putIfAbsent(subject, 0);
        }

        STUDENTS_STUDYING_SUBJECT.putIfAbsent(subject, students);
    }

    public static void addNewStudentToExistingSubject(Student student, Subject subject, int grade) {
        STUDENT_SUBJECTS_AND_GRADES.putIfAbsent(student, new HashMap<>());
        STUDENT_SUBJECTS_AND_GRADES.get(student).putIfAbsent(subject, grade);

       if (STUDENTS_STUDYING_SUBJECT.containsKey(subject)) {
           STUDENTS_STUDYING_SUBJECT.get(subject).add(student);
       }
    }

    public static void deleteStudentFromSubject(Student student, Subject subject) {
        STUDENTS_STUDYING_SUBJECT.get(subject).removeIf(s -> s.equals(student));

        if (STUDENT_SUBJECTS_AND_GRADES.get(student) != null) {
            STUDENT_SUBJECTS_AND_GRADES.get(student).forEach((key, value) -> {
                if (key.equals(subject)) {
                    STUDENT_SUBJECTS_AND_GRADES.get(student).remove(key);
                }
            });
        }
    }

    public static void printSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> subjectListEntry : STUDENTS_STUDYING_SUBJECT.entrySet()) {
          log.info("\nSubject: " + subjectListEntry.getKey() + "\nStudents studying this subject: " + subjectListEntry.getValue());
        }
    }
}
