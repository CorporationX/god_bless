package school.faang.task45219;

import java.util.*;

public class Main {
    private static Map<Student, Map<Subject, Integer>> everyStudentScore;
    private static Map<Subject, List<Student>> studentLearnAll;
    private static List<Subject> allSubjects;
    private static List<Student> allStudents;

    private static void generateData() {
        allSubjects = List.of(
                new Subject(1, "Физика"),
                new Subject(2, "Математика"),
                new Subject(3, "Астрономия")
        );
        allStudents = List.of(
                new Student(1, "Алексей"),
                new Student(2, "Сергей"),
                new Student(3, "Олег")
        );

        everyStudentScore = new HashMap<>(Map.of(
                allStudents.get(0),
                new HashMap<>(Map.of(
                        allSubjects.get(0), 5,
                        allSubjects.get(1), 4)),
                allStudents.get(1),
                new HashMap<>(Map.of(
                        allSubjects.get(1), 4,
                        allSubjects.get(2), 5)),
                allStudents.get(2),
                new HashMap<>(Map.of(
                        allSubjects.get(0), 2,
                        allSubjects.get(2), 3))
        ));

        studentLearnAll = new HashMap<>(Map.of(
                allSubjects.get(0), new ArrayList<>(List.of(allStudents.get(0), allStudents.get(2))),
                allSubjects.get(1), new ArrayList<>(List.of(allStudents.get(0), allStudents.get(1))),
                allSubjects.get(2), new ArrayList<>(List.of(allStudents.get(1), allStudents.get(2)))
        ));
    }


    public static void main(String[] args) {
        generateData();
        StudentDatabase database = new StudentDatabase(everyStudentScore, studentLearnAll);
        database.printAllStudents();
        System.out.println("------------------------------------");
        database.printAllSubjects();
        System.out.println("------------------------------------");
        try {
            database.addStudent(
                    new Student(3, "Кирилл"),
                    new HashMap<>(Map.of(
                            new Subject(1, "Физика"), 4,
                            new Subject(4, "Алгебра"), 5
                    )));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        database.addStudent(
                new Student(4, "Кирилл"),
                new HashMap<>(Map.of(
                        new Subject(1, "Физика"), 4,
                        new Subject(4, "Алгебра"), 5
                )));

        System.out.println("------------------------------------");
        database.printAllStudents();
        System.out.println("------------------------------------");
        database.printAllSubjects();
        System.out.println("------------------------------------");

        database.deleteStudentFromSubject(new Student(1, "Алексей"));
        System.out.println("------------------------------------");
        database.printAllStudents();
        System.out.println("------------------------------------");
        database.printAllSubjects();
        System.out.println("------------------------------------");

        database.addSubject(new Subject(5, "Биология"), new HashMap<>(Map.of(
                allStudents.get(0), 5)
        ));
        System.out.println("------------------------------------");
        database.printAllStudents();
        System.out.println("------------------------------------");
        database.printAllSubjects();
        System.out.println("------------------------------------");
        database.addSubject(new Subject(5, "Биология"), new HashMap<>(Map.of(
                allStudents.get(2), 5)
        ));
        System.out.println("------------------------------------");
        database.printAllStudents();
        System.out.println("------------------------------------");
        database.printAllSubjects();
        System.out.println("------------------------------------");
        database.addSubject(new Subject(5, "Биология"), new HashMap<>(Map.of(
                allStudents.get(1), 5)
        ));
    }
}
