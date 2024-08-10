package faang.school.godbless.task19533;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Student> listOfStudents;
    public static void main(String[] args) {
        listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Inna", "economic", 2017));
        listOfStudents.add(new Student("Igor", "history", 2017));
        listOfStudents.add(new Student("Nina", "economic", 2020));
        listOfStudents.add(new Student("Alla", "history", 2020));
        listOfStudents.add(new Student("Liza", "history", 2020));
        System.out.println(getStudentsByYearFaculty(listOfStudents));

        addStudent("Ira", "history", 2020);
        System.out.println(findStudent("history", 2020, listOfStudents));
        removeStudent("Ira", "history", 2020);

        System.out.println(listOfStudents);
    }
    public static Map<String, List<Student>> getStudentsByYearFaculty(List<Student> list){
        Map<String, List<Student>> map = new HashMap<>();
        map = list.stream().collect(Collectors.groupingBy(Student::getYearFaculty));
        return map;
    }

    public static void addStudent(String name, String faculty, Integer year){
        listOfStudents.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, Integer year){
        listOfStudents.removeIf(student -> student.getName().equals(name) && student.getYear().equals(year) &&
                student.getFaculty().equals(faculty));
    }

    public static List<Student> findStudent(String faculty, Integer year, List<Student> list){
        List<Student> result = list.stream().filter(student -> student.getYearFaculty().equals(faculty + year))
                .collect(Collectors.toList());
        return result;
    }
}
