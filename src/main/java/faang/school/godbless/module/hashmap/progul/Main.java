package faang.school.godbless.module.hashmap.progul;

import java.util.ArrayList;
import java.util.Collections;
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
    private static final Map<FacultyYear, List<Student>> FACULTY_YEAR_TO_STUDENTS = new HashMap<>();
    private static final Map<Student, Integer> STUDENT_TO_INDEX = new HashMap<>();
    private static final List<Student> students = new ArrayList<>();
    
    public static void main(String[] args) {
        Student stark = new Student("Stark", "EE", 1);
        Student mark = new Student("Mark", "EE", 4);
        Student kark = new Student("Kark", "EE", 4);
        Student bark = new Student("Bark", "TT", 2);
        Student lark = new Student("Lark", "QQ", 2);
        Student sark = new Student("Sark", "QQ", 2);
        addStudent(stark);
        addStudent(bark);
        addStudent(mark);
        addStudent(lark);
        addStudent(sark);
        addStudent(kark);
        Map<FacultyYear, List<Student>> facultyYearStudentsMap = listToMap(students);
        
        printStudents(facultyYearStudentsMap);
        System.out.println("Удалили студента");
        deleteStudent(mark.getName(), mark.getFaculty(), mark.getYear());
        printStudents(facultyYearStudentsMap);
        System.out.println("Нашли студентов");
        System.out.println(findStudents(stark.getFaculty(), stark.getYear()));
    }
    
    public static Map<FacultyYear, List<Student>> listToMap(List<Student> students) {
        Map<FacultyYear, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            result.merge(
                new FacultyYear(student.getFaculty(), student.getYear()),
                Collections.singletonList(student),
                (existingValue, newValue) -> {
                    List<Student> mergedList = new ArrayList<>(existingValue);
                    mergedList.addAll(newValue);
                    return mergedList;
                }
            );
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
        ArrayList<Student> value = new ArrayList<>();
        value.add(student);
        FACULTY_YEAR_TO_STUDENTS.merge(
            new FacultyYear(student.getFaculty(), student.getYear()),
            value,
            (existingValue, newValue) -> {
                List<Student> mergedList = new ArrayList<>(existingValue);
                mergedList.addAll(newValue);
                return mergedList;
            }
        );
    }
    
    public static void deleteStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(STUDENT_TO_INDEX.get(student));
        STUDENT_TO_INDEX.remove(student);
        List<Student> mapStudents = FACULTY_YEAR_TO_STUDENTS.get(new FacultyYear(faculty, year));
        mapStudents.remove(student);
    }
    
    public static List<Student> findStudents(String faculty, int year) {
        return FACULTY_YEAR_TO_STUDENTS.get(new FacultyYear(faculty, year));
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