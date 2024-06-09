package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students= new ArrayList<>();
    private static Map<Student, Integer> studentsMap = new HashMap<>();

    public static void main(String[] args) {
        Student Ivan = new Student("Ivan", "Physics", 2);
        Student Kate = new Student("Kate", "Math", 1);
        Student Fedor = new Student("Fedor", "Programming", 4);

        addStudent(Ivan);
        addStudent(Kate);
        addStudent(Fedor);

        removeStudent("Fedor", "Prograing", 4);
        removeStudent("Fedor", "Programming", 4);
        System.out.println(searchByStage("Math", 1));
        printAll();
    }

    public static Map<Stage, List<Student>> findAll(List<Student> someStudents) {
        Map<Stage, List<Student>> allInfo = new HashMap<>();

        for (Student student : someStudents){
            Stage stage = new Stage(student.getFaculty(), student.getYear());
            if (students.contains(student) && !allInfo.keySet().contains(stage)) {
                List<Student> studentsOnStage = new ArrayList();
                studentsOnStage.add(student);
                allInfo.put(stage, studentsOnStage);
            }
            else if (students.contains(student) && allInfo.keySet().contains(stage)) {
                allInfo.get(stage).add(student);
            }
            else {
                System.out.println(student + " is not our student");
            }
        }
        return allInfo;
    }

    public static void addStudent(Student student) {
        students.add(student);
        studentsMap.put(student, students.size() - 1);
    }

    public static void removeStudent(String name, String faculty, int course) {
        Student student = new Student(name, faculty, course);

        if (studentsMap.containsKey(student)) {
            students.remove(studentsMap.get(student));
            for (int i = 0; i < students.size(); i++) {
                studentsMap.put(student, i);
            }
        } else System.out.println("There is no student: " + student);
    }

    public static List<Student> searchByStage(String faculty, int course) {
        List<Student> studentsByStage = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == course) {
                studentsByStage.add(student);
            }
        }
        return studentsByStage;
    }

    public static void printAll() {
        Map<Stage, List<Student>> allInfo = new HashMap<>();

        for (Student student : students){
            Stage flow = new Stage(student.getFaculty(), student.getYear());

            if (allInfo.containsKey(flow) && !allInfo.get(flow).contains(student)) allInfo.get(student).add(student);
            else if (!allInfo.containsKey(flow)) {
                List<Student> studentsOnFlow = new ArrayList();

                studentsOnFlow.add(student);
                allInfo.put(flow, studentsOnFlow);
            }
        }
        for (Stage stage : allInfo.keySet()) System.out.println(stage + " -> " + allInfo.get(stage));
    }
}
