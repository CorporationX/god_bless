package faang.school.godbless.absenteeismCounting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();

        studentsList.add(new Student("Vasya", "Chemistry", 1));
        studentsList.add(new Student("Vova", "Engineering", 2));
        studentsList.add(new Student("Masha", "Physics", 2));
        studentsList.add(new Student("Misha", "Computer science", 1));
        Map<String, List<Student>> studentsMap = groupStudents(studentsList);
        printAllGroupedStudents(studentsMap);
        addNewStudent(studentsMap, new Student("Vasilisa", "Chemistry", 1));
        removeStudent(studentsMap, "Masha");
        printAllGroupedStudents(studentsMap);
        System.out.println();
        System.out.println(findByFacultyAndYear(studentsMap, "Chemistry", 1));
    }

    public static Map<String, List<Student>> groupStudents(List<Student> studentsList) {
        return studentsList.stream()
                .collect(Collectors.groupingBy(student -> student.getFaculty() + ", Year " + student.getYear()));
    }


    public static void addNewStudent(Map<String, List<Student>> studentsMap, Student student) {
        studentsMap.computeIfAbsent(student.getFaculty() + ", Year " + student.getYear(), key -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Map<String, List<Student>> studentsMap, String name) {
        studentsMap.forEach((key, value) -> value.removeIf(student -> student.getName().equals(name)));
        studentsMap.values().removeIf(List::isEmpty);
    }

    public static List<Student> findByFacultyAndYear(Map<String, List<Student>> studentsMap, String faculty, int year) {
        return studentsMap.get(faculty + ", Year " + year);
    }

    public static void printAllGroupedStudents(Map<String, List<Student>> studentsMap) {
        System.out.println("---------Printing All Grouped Students---------");
        studentsMap.forEach((key, value) -> {
            System.out.println(key + " : ");
            value.forEach(System.out::println);
        });
    }

    //Without lambda for reminder
//    public static Map<String, List<Student>> groupStudents(List<Student> studentsList) {
//        Map<String, List<Student>> groupedStudents = new HashMap<>();
//        for (Student student : studentsList) {
//            String key = student.getFaculty() + ", Year " + student.getYear();
//            if (!groupedStudents.containsKey(key)) {
//                groupedStudents.put(key, new ArrayList<>());
//            }
//            groupedStudents.get(key).add(student);
//        }
//        return groupedStudents;
//    };

}

