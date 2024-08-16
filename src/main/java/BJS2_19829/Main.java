package BJS2_19829;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Subject physics = new Subject(2, "Physics");

        Map<Subject, Integer> mishaSubjectMark = new HashMap<>();
        Map<Subject, Integer> georgiySubjectMark = new HashMap<>();

        mishaSubjectMark.put(physics, 4);
        georgiySubjectMark.put(physics, 5);

        Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
        studentSubjects.put(new Student(6, "Misha"), mishaSubjectMark);
        studentSubjects.put(new Student(7, "Georgiy"), georgiySubjectMark);

        List<Student> biologyStudents = new ArrayList<>();
        biologyStudents.add(new Student(1, "Andrew"));
        biologyStudents.add(new Student(2, "Maria"));
        biologyStudents.add(new Student(5, "Sergey"));

        List<Student> geographyStudents = new ArrayList<>();
        geographyStudents.add(new Student(3, "Pasha"));
        geographyStudents.add(new Student(4, "Dennis"));

        Map<Subject, List<Student>> subjects = new HashMap<>();
        subjects.put(new Subject(3, "Biology"), biologyStudents);
        subjects.put(new Subject(4, "Geography"), geographyStudents);

        Student studentTest = new Student(15, "Masha");
        Subject subjectTest = new Subject(25, "English");

        //Add new student with Subject and mark
        addNewStudentWithSubjectMarks(studentSubjects, studentTest, subjectTest, 4);

        //Add new Subject for existing student
        addSubjectForExistingStudent(studentSubjects, studentTest, subjectTest, 3);

        //Remove student
        removeStudent(studentSubjects, studentTest);

        //Get all students with their Subject & mark hash Maps
        getAllStudentsWithSubjectsAndMarks(studentSubjects);

        //Add new subject and student list
        addNewSubjectAndStudentList(subjects, biologyStudents, subjectTest);

        //add new Student to existing subject
        addNewStudentToExistingSubject(subjects, studentTest, subjectTest);

        //remove student from student list from subject
        removeStudentFromSubject(subjects, studentTest, subjectTest);

        //Print all Subjects and students following them
        getAllStudentsAndSubjects(subjects);
    }

    public static void addNewStudentWithSubjectMarks(Map<Student, Map<Subject, Integer>> studentSubjectMap,
                                                     Student student,
                                                     Subject subject, int mark) {
        studentSubjectMap.computeIfAbsent(student, key -> new HashMap<>()).put(subject, mark);
        System.out.println("New student " + student.getStudentName() + " was added successfully!");
        System.out.println("Has following subject - " + subject.getSubjectName() + " and mark - " + mark);
        System.out.println();
    }

    public static void addSubjectForExistingStudent(Map<Student, Map<Subject, Integer>> studentSubjectMap,
                                                    Student student,
                                                    Subject subject, int mark) {
        studentSubjectMap.get(student).put(subject, mark);
        System.out.println(subject.getSubjectName() +
                " subject has been successfully added for student - " +
                student.getStudentName());
        System.out.println();
    }

    public static void removeStudent(Map<Student, Map<Subject, Integer>> studentSubjectMap, Student student) {
        studentSubjectMap.remove(student);
        System.out.println(student.getStudentName() + " has been successfully removed.");
        System.out.println();
    }

    public static void getAllStudentsWithSubjectsAndMarks(Map<Student, Map<Subject, Integer>> studentSubjectMap) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjectMap.entrySet()) {
            Map<Subject, Integer> subjectMap = entry.getValue();
            System.out.println(entry.getKey().getStudentName() + " has such subjects and marks :");
            for (Map.Entry<Subject, Integer> entry1 : subjectMap.entrySet()) {
                System.out.println(entry1.getKey().getSubjectName() + " and mark is - " + entry1.getValue());
            }
        }
        System.out.println();
    }

    public static void addNewSubjectAndStudentList(Map<Subject, List<Student>> subjectsMap,
                                                   List<Student> students,
                                                   Subject subject) {
        subjectsMap.computeIfAbsent(subject, key -> students);
        System.out.println("New subject " + subject.getSubjectName() + " with students it's following was added!");
        System.out.println();
    }

    public static void addNewStudentToExistingSubject(Map<Subject, List<Student>> subjectsMap,
                                                      Student student,
                                                      Subject subject) {
        subjectsMap.get(subject).add(student);
        System.out.println(student.getStudentName() +
                " was added to the list of students following subject - " + subject.getSubjectName());
        System.out.println();
    }

    public static void removeStudentFromSubject(Map<Subject, List<Student>> subjectsMap,
                                                Student student,
                                                Subject subject) {
        subjectsMap.get(subject).remove(student);
        System.out.println(student.getStudentName() +
                " has been removed from the list of subject - " +
                subject.getSubjectName());
        System.out.println();
    }

    public static void getAllStudentsAndSubjects(Map<Subject, List<Student>> subjectsMap) {
        for (Map.Entry<Subject, List<Student>> entry : subjectsMap.entrySet()) {
            System.out.println(entry.getKey().getSubjectName() + " studied by next students: ");
            for (Student student : entry.getValue()) {
                System.out.println(student.getStudentName());
            }
        }
        System.out.println();
    }

}
