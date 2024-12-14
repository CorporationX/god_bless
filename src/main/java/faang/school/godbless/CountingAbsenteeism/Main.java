package faang.school.godbless.CountingAbsenteeism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student Ivan = new Student("Ivan", "Physics", 2);
        Student Kate = new Student("Kate", "Math", 1);
        Student Fedor = new Student("Fedor", "Programming", 4);

        addStudent(Ivan);
        addStudent(Kate);
        addStudent(Fedor);

        System.out.println(findAll(Arrays.asList(Ivan, Kate, Fedor)));
        removeStudent("Fedor", "Prograing", 4);
        removeStudent("Fedor", "Programming", 4);
        System.out.println(searchByStage("Math", 1));
        printAll();
    }

    public static Map<Stage, List<Student>> findAll(List<Student> someStudents) {
        Map<Stage, List<Student>> allInfo = new HashMap<>();

        for (Student student : someStudents) {
            Stage stage = new Stage(student.getFaculty(), student.getYear());
            if (students.contains(student) && !allInfo.keySet().contains(stage)) {
                List<Student> studentsOnStage = new ArrayList<>();
                studentsOnStage.add(student);
                allInfo.put(stage, studentsOnStage);
            } else if (students.contains(student) && allInfo.keySet().contains(stage)) {
                allInfo.get(stage).add(student);
            } else {
                System.out.println(student + " is not our student");
            }
        }
        return allInfo;
    }

    public static void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        } else {
            System.out.println(student + " is already exists");
        }
    }

    public static void removeStudent(String name, String faculty, int year) {
        boolean isRemoved = false;

        for (Student student : students) {
            if (Objects.equals(student.getName(), name) && Objects.equals(student.getFaculty(), faculty) && student.getYear() == year) {
                students.remove(student);
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
            System.out.println("There is already no " + "|" + name + "| |" + faculty + "| course |" + year + "|");
        }
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

        for (Student student : students) {
            Stage stage = new Stage(student.getFaculty(), student.getYear());

            if (allInfo.containsKey(stage) && !allInfo.get(stage).contains(student)) {
                allInfo.get(stage).add(student);
            } else if (!allInfo.containsKey(stage)) {
                List<Student> studentsOnStage = new ArrayList<>();

                studentsOnStage.add(student);
                allInfo.put(stage, studentsOnStage);
            }
        }
        for (Stage stage : allInfo.keySet()) System.out.println(stage + " -> " + allInfo.get(stage));
    }
}
