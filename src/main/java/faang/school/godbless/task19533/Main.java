package faang.school.godbless.task19533;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static List<Student> studentList;

    public static void main(String[] args) {
        studentList = new ArrayList<>();
        studentList.add(new Student("Inna", "economic", 2017));
        studentList.add(new Student("Igor", "history", 2017));
        studentList.add(new Student("Nina", "economic", 2020));
        studentList.add(new Student("Alla", "history", 2020));
        studentList.add(new Student("Liza", "history", 2020));
        System.out.println(getStudentsByYearFaculty(studentList));

        addStudent("Ira", "history", 2020);
        System.out.println(findStudent("history", 2020, studentList));
        removeStudent("Ira", "history", 2020);

        System.out.println(studentList);
    }
    public static Map<String, List<Student>> getStudentsByYearFaculty(List<Student> studentList){
        Map<String, List<Student>> map = new HashMap<>();
        map = studentList.stream().collect(Collectors.groupingBy(Student::getYearFaculty));
        return map;
    }

    public static void addStudent(String name, String faculty, Integer year){
        studentList.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, Integer year){
        studentList.removeIf(student -> student.getName().equals(name) && student.getYear().equals(year) &&
                student.getFaculty().equals(faculty));
    }

    public static List<Student> findStudent(String faculty, Integer year, List<Student> list){
        List<Student> result = list.stream().filter(student -> student.getYearFaculty().equals(faculty + year))
                .collect(Collectors.toList());
        return result;
    }
}
