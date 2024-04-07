package faang.school.godbless.skip_count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tom", "Chemistry", 3));
        students.add(new Student("Bob", "Alchemy", 1));
        students.add(new Student("Ann", "Biology", 3));
        students.add(new Student("Mark", "Biology", 3));


        Map<String, List<Student>> groupedStudents = groupStudents(students);
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("===================>>>>>>>>>>>>>>>>>>");
        searchStudents(students, "Biology", 3);
        searchStudents(students, "Astronomy", 2);

        System.out.println("==================>>>>>>>>>>>>>>>>>>>");
        addStudent(students, new Student("Tom", "Chemistry", 3));
        addStudent(students, new Student("Mick", "Astronomy", 1));

        System.out.println("==================>>>>>>>>>>>>>>>>>>>");
        removeStudent(students, new Student("Brad", "Astronomy", 4));
        removeStudent(students, new Student("Bob", "Alchemy", 1));

        System.out.println("==================>>>>>>>>>>>>>>>>>>>");
        allStudents(students);
    }

    public static Map<String, List<Student>> groupStudents(List<Student> students) {
        Map<String, List<Student>> grouped = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " / " + student.getYear();
            if (!grouped.containsKey(key)) {
                grouped.put(key, new ArrayList<>());
            }
            grouped.get(key).add(student);
        }
        return grouped;
    }

    public static void addStudent(List<Student> students, Student student){
        if (!students.contains(student)){
            students.add(student);
            System.out.println("Студент " + student + " добавлен");
        }
        else {
            System.out.println("Студент " + student + " уже есть в списке");
        }
    }
    public static void removeStudent(List<Student> students, Student student){
        if (students.contains(student)){
            students.remove(student);
            System.out.println("Студент " + student + " удалён");
        }
        else {
            System.out.println("Студента " + student + " нет в списке");
        }
    }
    public static void searchStudents(List<Student> students,String faculty, int year){
        if (students.isEmpty()){
            System.out.println("Список студентов пуст");
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                sb.append(student);
                if (i < students.size() - 1) {
                    sb.append("; ");
                }
                found = true;
            }
        }
        if (found) {
            System.out.println("На факультете " + faculty + " " + year + " курса учатся: " + sb);
        } else {
            System.out.println("На факультете " + faculty + " " + year + " курса нет студентов");
        }
    }
    public static void allStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст");
        }
        Map<String, List<Student>> groupedStudents = groupStudents(students);

        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("На факультете " + entry.getKey() + " учится:");
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }
}
