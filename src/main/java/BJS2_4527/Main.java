package BJS2_4527;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Гарри", "Гриффиндор", 2002),
                new Student("Малфой", "Слизерен", 2005),
                new Student("Ханна", "Пуффндуй", 2000),
                new Student("Майкл", "Когтевран", 2002),
                new Student("Рон", "Гриффиндор", 2002)
        ));
        addNewStudent(students, new Student("тест", "тест", 2020));
        System.out.println(groupByFacultyAndYear(students));
        deleteStudent(students, new Student("тест", "тест", 2020));
        System.out.println(groupByFacultyAndYear(students));
        System.out.println(findStudents(students, "Гриффиндор", 2002));
    }

    public static Map<String, List<Student>> groupByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            result.computeIfAbsent(student.getFaculty() + "_" + student.getYear(), k -> new ArrayList<>())
                    .add(student);
        }
        return result;
    }

    public static void addNewStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void deleteStudent(List<Student> students, Student student) {
        students.remove(student);
    }

    public static Map<String, List<Student>> findStudents(List<Student> students, String faculty, Integer year) {
        Map<String, List<Student>> result = new HashMap<>();
        for(Student student : students) {
            if(student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.computeIfAbsent(faculty + "_" + year, k -> new ArrayList<>()).add(student);
            }
        }
        return result;
    }
}
