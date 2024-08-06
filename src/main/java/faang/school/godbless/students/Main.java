package faang.school.godbless.students;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Joshua", "Programming", 2));
        students.add(new Student("Linux", "Programming", 2));
        students.add(new Student("Knoot", "Programming and DB", 3));
        students.add(new Student("Brus Ekkel", "Programming and DB", 3));
        students.add(new Student("Ketty Sierra", "Programming", 1));
        students.add(new Student("Robert Martin", "Programming and DB", 4));
    }


    public static void main(String[] args) {
        printAll();
    }

    private static Map<Pair, List<Student>> group() {
        return students.stream()
                .collect(Collectors.groupingBy(student -> new Pair(student.getFaculty(), student.getYear())));
    }

    public static void add(Student student) {
        students.add(student);
    }

    public static void remove(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static List<Student> findByFacultyAndYear(String faculty, int year) {
        return group().get(new Pair(faculty, year));
    }

    private static void printAll() {
        group().forEach(((pair, list) -> {
            System.out.printf("%s:\n", pair);
            list.forEach(student -> System.out.printf("\t%s\n", student));
        }));
    }
}

@AllArgsConstructor
@EqualsAndHashCode
@ToString
class Pair {
    private String faculty;
    private int year;
}
