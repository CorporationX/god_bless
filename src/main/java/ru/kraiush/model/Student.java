package ru.kraiush.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
                .filter(p -> p.getFaculty().equals(faculty))
                .filter(p -> p.getCourse().equals(course))
                .collect(Collectors.toSet());
    }

    public static void removeStudent(List<Student> students, String name, String faculty, Integer course)  {

        ListIterator<Student> iter = students.listIterator();
        while(iter.hasNext()){
            Student student = iter.next();
            if(student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getCourse().equals(course)){
                System.out.println(" remove student. name: \"" + name + "\" faculty: \"" + faculty + "\" course: " + course);
                 iter.remove();
            }
        }
        students.removeIf(n -> n.getName().equals(name));

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
