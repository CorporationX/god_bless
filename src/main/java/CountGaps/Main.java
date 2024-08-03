package CountGaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        addStudent("John", "Geo", 1);
        addStudent("Doe", "IT", 2);
        addStudent("Peter", "Geo", 2);
        addStudent("Criss", "IT", 1);
        addStudent("Criss", "IT", 2);
        addStudent("Daniel", "IT", 3);
        printGroupingMap(groupStudentsByFacultyAndYear(students));
        deleteStudent("Criss", "IT", 1);
        System.out.println(getStudentsByFacultyAndYear("IT", 1));

    }

    public static Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public static Student addStudent(String name, String faculty, int year){
        Student student = new Student(name, faculty, year);
        students.add(student);
        return student;
    }

    public static void deleteStudent(String name, String faculty, int year){
        Student target = new Student(name, faculty, year);
        students.remove(target);
    }

    public static List<Student> getStudentsByFacultyAndYear(String faculty, int year){
        return students
                .stream()
                .filter(el ->
                        Objects.equals(el.getFaculty(), faculty) &&
                        el.getYear() == year)
                .toList();
    }

    public static HashMap<Map.Entry<String,Integer>, List<Student>> groupStudentsByFacultyAndYear(List<Student> students){
        HashMap<Map.Entry<String,Integer>, List<Student>> groupingMap = new HashMap<>();
        for(Student student : students){
            String faculty = student.getFaculty();
            int year = student.getYear();
            Map.Entry<String,Integer> key = Map.entry(faculty, year);
            if(!groupingMap.containsKey(key)){
                groupingMap.put(key, new ArrayList<>());
            }
            groupingMap.get(key).add(student);
        }
        return groupingMap;
    }

    public static void printGroupingMap(HashMap<Map.Entry<String,Integer>, List<Student>> groupingMap){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> key : groupingMap.keySet()){
            sb.append("(Факультет:")
                    .append(key.getKey())
                    .append(", ")
                    .append("Курс:")
                    .append(key.getValue())
                    .append("): ")
                    .append(groupingMap.get(key))
                    .append("\n");
        }
        System.out.println(sb);
    }


}
