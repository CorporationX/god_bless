package school.faang.counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student firstStudent = new Student("Gadzhi", "informatic", 2);
        Student secondStudent = new Student("Matvey", "informatic", 2);
        Student thirdStudent = new Student("Andrey", "ecolog", 3);


        addStudent(firstStudent);
        addStudent(secondStudent);
        addStudent(thirdStudent);

        System.out.println(groupedStudent(students));

        Map<UniversityFlow, List<Student>> studentGroup = groupedStudent(students);

        findStudent("ecolog", 3, studentGroup);

        removeStudent("Gadzhi", "informatic", 2);

        printAll();
    }


    public static Map<UniversityFlow, List<Student>> groupedStudent(List<Student> students) {
        Map<UniversityFlow, List<Student>> studentsGroup = new HashMap<>();

        for (Student student : students) {
            UniversityFlow universityFlow = new UniversityFlow(student.getFaculty(), student.getYear());

            studentsGroup.computeIfAbsent(universityFlow, k -> new ArrayList<>()).add(student);
        }
        return studentsGroup;
    }

    public static void findStudent(String faculty, int year,
                                   Map<UniversityFlow, List<Student>> studentsGroup) {
        List<Student> students = studentsGroup.get(new UniversityFlow(faculty, year));

        if (students == null) {
            System.out.println("students not found");
        }

        students.forEach(student -> System.out.println(student.getName()));
    }

    public static void printAll() {
        Map<UniversityFlow, List<Student>> studentsGroup = groupedStudent(students);

        for (Map.Entry<UniversityFlow, List<Student>> entry : studentsGroup.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }


}
