package school.faang.HashMap3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private String faculty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, faculty);
    }

    public static HashMap<Student, List<Student>> groupedStudents(List<Student> list){
        HashMap<Student, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : list) {
            groupedStudents.computeIfAbsent(student, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    //Добавление студента
    public static void addStudent(Student student, List<Student> list){
        list.add(student);
    }

    // Удаление студента
    public static void deleteStudent(String name, int year, String faculty, List<Student> list){
        list.remove(new Student(name, year, faculty));
    }

    // поиск студентов по курсу и факультету
    public static void searchStudents(int year, String faculty, List<Student> list){
        boolean flag = false;
        for (Student student : list){
            if(student.equals(new Student("", year, faculty))){
                System.out.println(student.getName());
                flag = true;
            }
        }
        if (flag == false){
            System.out.println("None.");
        }
    }

    public static void printGroupedStudents(List<Student> list){
        HashMap<Student, List<Student>> result = groupedStudents(list);

        for (var entry : result.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().getFaculty() +
                    "\nYear: " + entry.getKey().getYear());
            for (Student student : entry.getValue()){
                System.out.println(student.getName());
            }
            System.out.println();
        }
    }

}
