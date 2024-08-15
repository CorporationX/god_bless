
package ru.kraiush.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private String name;
    private String faculty;
    private Integer course;

    public static Set<Student> findStudentsByFacultyAndCourse(List<Student> students, String faculty, Integer course) {
          return students.stream()
                .filter(s -> s.getFaculty().equals(faculty))
                .filter(s -> s.getCourse().equals(course))
                .collect(Collectors.toSet());
    }
    public static void removeStudent(List<Student> students, String name, String faculty, Integer course)  {
        students.removeIf(s -> s.getName().equals(name) && s.getFaculty().equals(faculty) && s.getCourse().equals(course));
    }
    public static List<Student> getStudens() {

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "music", 2019));
        students.add(new Student("Ilon Mask", "automatic & electronic", 2017));
        students.add(new Student("Charlie",   "cinema", 2021));
        students.add(new Student("Harry Potter",  "cinema", 2011));
        students.add(new Student("Lulu",  "automatic & electronic", 2017));
        students.add(new Student("Napoleon",  "warrier", 1812));
        students.add(new Student("Kraiu",  "automatic & electronic", 1986));
        students.add(new Student("Kutuzov",  "warrier", 1812));
        students.add(new Student("Gorge",  "automatic & electronic", 2017));

        return students;
    }
}