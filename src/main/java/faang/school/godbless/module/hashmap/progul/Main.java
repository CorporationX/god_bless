package faang.school.godbless.module.hashmap.progul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Попытался реализовать так, как хотел Влад в видео по разбору задачек hashmap
 */
public class Main {
    /**
     * Попытался реализовать ту штуку, про которую Влад говорил в видосе, но возникли проблемы с удалением Eсли
     * использовать дополнительные кеши, это даёт головную мороку при удалении студентов
     */
    private static Map<FacultyYear, List<Student>> FACULTY_YEAR_TO_STUDENTS = new HashMap<>();
    private static final Map<Student, Integer> STUDENT_TO_INDEX = new HashMap<>();
    private static final List<Student> students = new ArrayList<>();
    
    public static void main(String[] args) {
        Student mark = new Student("Mark", "EE", 4);
        Student kark = new Student("Kark", "EE", 4);
        Student lark = new Student("Lark", "QQ", 2);
        Student sark = new Student("Sark", "QQ", 2);
        addStudent(mark);
        addStudent(lark);
        addStudent(sark);
        addStudent(kark);
        
        printStudents(listToMap(students));
        System.out.println("Удалили студента");
        deleteStudent(mark.getName(), mark.getFaculty(), mark.getYear());
        printStudents(listToMap(students));
        System.out.println("Нашли студентов");
        System.out.println(findStudents(lark.getFaculty(), lark.getYear()));
    }
    
    public static Map<FacultyYear, List<Student>> listToMap(List<Student> students) {
        Map<FacultyYear, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            result.computeIfAbsent(
                new FacultyYear(student.getFaculty(), student.getYear()),
                value -> new ArrayList<>()).add(student);
        }
        return result;
    }
    
    public static void addStudent(Student student) {
        students.add(student);
        int index = students.size();
        if (students.isEmpty()) {
            index = 1;
        }
        STUDENT_TO_INDEX.put(student, index - 1);
    }
    
    public static void deleteStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove((int) STUDENT_TO_INDEX.remove(student));
    }
    
    public static List<Student> findStudents(String faculty, int year) {
        FACULTY_YEAR_TO_STUDENTS = listToMap(students);
        return FACULTY_YEAR_TO_STUDENTS.getOrDefault(new FacultyYear(faculty, year),new ArrayList<>());
    }
    
    public static void printStudents(Map<FacultyYear, List<Student>> facultyToStudents) {
        System.out.println("All students:");
        for (var entry : facultyToStudents.entrySet()) {
            FacultyYear key = entry.getKey();
            System.out.printf(
                "Faculty: %s. Year: %d. Students: %s \n",
                key.getFaculty(),
                key.getYear(),
                String.join(",", entry.getValue().toString())
            );
        }
    }
}