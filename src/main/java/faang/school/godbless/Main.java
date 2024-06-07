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
        System.out.println(searchByFlow("Math", 1));
        printAll();
    }

    public static Map<Flow, List<Student>> findAll() {
        Map<Flow, List<Student>> allInfo = new HashMap<>();

        for (Student student : students){
            Flow flow = new Flow(student.getFaculty(), student.getYear());

            if (allInfo.containsKey(flow) && !allInfo.get(flow).contains(student)) allInfo.get(student).add(student);
            else if (!allInfo.containsKey(flow)) {
                List<Student> studentsOnFlow = new ArrayList();

                studentsOnFlow.add(student);
                allInfo.put(flow, studentsOnFlow);
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

    public static List<Student> searchByFlow(String faculty, int course) {
        List<Student> studentsByFlow = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == course) studentsByFlow.add(student);
        }
        return studentsByFlow;
    }

    public static void printAll() {
        Map<Flow, List<Student>> allInfo = findAll();

        for (Flow flow : allInfo.keySet()) {
            System.out.println(flow + " -> " + allInfo.get(flow));
        }
    }
}
