package faang.school.godbless.BJS2_4622;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionOnStudents {
    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students){
        Map<String, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students){
            String key = student.getFaculty() + "-" + student.getYear();
            if(!groupedStudents.containsKey(key)){
                groupedStudents.put(key, new ArrayList<>());
            }
            groupedStudents.get(key).add(student);
        }

        return groupedStudents;
    }

    public static void addNewStudent(String name, String faculty, int year, List<Student> studentsList){
        studentsList.add((new Student(name, faculty, year)));
    }

    public static void deleteStudent(String name, String faculty, int year, List<Student> studentsList){
        Student studentToDelete = new Student(name, faculty, year);

        studentsList.remove(studentToDelete);
    }

    public static void searchAllStudentsOfFacultyAndYear(String faculty, int year, List<Student> studentsList){
        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(studentsList);
        String key = faculty + "-" + year;
        List<Student> studentsFromFaculty = groupedStudents.get(key);

        System.out.println("Студенты: " + faculty + " - " + year);
        for (Student student : studentsFromFaculty){
            System.out.println(student.getName());
        }
    }

    public static void printAllStudents(List<Student> studentsList){
        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(studentsList);

        for (Map.Entry<String,List<Student>> entry : groupedStudents.entrySet()){
            System.out.println("Факультет: " + entry.getKey());

            for (Student student: entry.getValue()){
                System.out.println(student.getName());
            }
            System.out.print("\n");
        }
    }
}
