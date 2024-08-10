package faang.school.godbless.task19533;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static List<Student> listOfStudents;
    public static void main(String[] args) {
        listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Inna", "economic", 2017));
        listOfStudents.add(new Student("Igor", "math", 2017));
        listOfStudents.add(new Student("Nina", "economic", 2020));
        listOfStudents.add(new Student("Alla", "history", 2021));
        listOfStudents.add(new Student("Liza", "history", 2020));

        System.out.println(getStudentsByYearFaculty(listOfStudents));
        proverka();



    }
    public static Map<String, List<Student>> getStudentsByYearFaculty(List<Student> list){
        Map<String, List<Student>> map = new HashMap<>();
        Set<Integer> yearSet = new HashSet<>();
        Set<String> facultySet = new HashSet<>();

        for (Student student:list) {
            yearSet.add(student.getYear());
        }
        System.out.println(yearSet);
        for (Student student:list) {
            facultySet.add(student.getFaculty());
        }
        System.out.println(facultySet);
        for (Student student:list) {
            facultySet.add(student.getFaculty());
            for (Integer year:yearSet) {
                for (String faculty:facultySet) {
                    String key = year + faculty;
                    map.put(key, new ArrayList<>());
                    if(map.get(key).equals(student.getYear()+student.getFaculty()))
                        map.get(key).add(student);
                }
            }
        }
        return map;
    }

    public static void proverka(){
        Map<String, List<Student>> map = getStudentsByYearFaculty(listOfStudents);
        map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()) // Сплющиваем список студентов
                .forEach(student -> System.out.println("Студент: " + student.getName() +  ", Year: " + student.getYear()));
    }


    public static void addStudent(String name, String faculty, Integer year){
        listOfStudents.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, Integer year){
        listOfStudents.removeIf(student -> student.getName().equals(name) && student.getYear().equals(year) &&
                student.getFaculty().equals(faculty));
    }
}
