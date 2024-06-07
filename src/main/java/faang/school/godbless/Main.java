package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students= new ArrayList();

    public static void main(String[] args) {
        Student Ivan = new Student("Ivan", "Physics", 2);
        Student Kate = new Student("Kate", "Math", 1);
        Student Fedor = new Student("Fedor", "Programming", 4);

        addStudent(Ivan);
        addStudent(Kate);
        addStudent(Fedor);

        removeStudent("Fedor", "Prograing", 4);
        removeStudent("Fedor", "Programming", 4);
        System.out.println(searchByUniversity("Math", 1));
        printAll();
    }

    public static Map<University, List<Student>> findAll() {
        Map<University, List<Student>> allInfo = new HashMap<>();

        for (Student student : students){
            University university = new University(student.getFaculty(), student.getYear());

            if (allInfo.containsKey(university) && !allInfo.get(university).contains(student)) allInfo.get(student).add(student);
            else if (!allInfo.containsKey(university)) {
                List<Student> studentsOnFlow = new ArrayList();

                studentsOnFlow.add(student);
                allInfo.put(university, studentsOnFlow);
            }
        }
        return allInfo;
    }

    public static void addStudent(Student student) {
        if (!students.contains(student)) students.add(student);
        else System.out.println("Student " + student + " already exists");
    }

    public static void removeStudent(String name, String faculty, int course) {
        Student student = new Student(name, faculty, course);
        if (students.contains(student)) students.remove(student);
        else System.out.println("There is no student: " + student);
    }

    public static List<Student> searchByUniversity(String faculty, int course) {
        List<Student> studentsByUniversity = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == course) studentsByUniversity.add(student);
        }
        return studentsByUniversity;
    }

    public static void printAll() {
        Map<University, List<Student>> allInfo = findAll();

        for (University university : allInfo.keySet()) {
            System.out.println(university + " -> " + allInfo.get(university));
        }
    }
}
