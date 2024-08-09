package ru.kraiush.model;

import lombok.*;

import java.util.Arrays;
import java.util.List;

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

    public static List<Student> getStudens() {
        Student john = new Student("John", "music", 2019);
        Student mask = new Student("Ilon Mask", "automatic & electronic", 2017 );
        Student charlie = new Student("Charlie",   "cinema", 2021);
        Student potter = new Student("Harry Potter",  "cinema", 2011);
        Student lulu = new Student("Lulu",  "automatic & electronic", 2017);
        Student napoleon = new Student("Napoleon",  "warrier", 1812);
        Student kraiu = new Student("Kraiu",  "automatic & electronic", 1986);
        Student kutuzov = new Student("Kutuzov",  "warrier", 1812);
        Student gorge = new Student("Gorge",  "automatic & electronic", 2017);

        return Arrays.asList(john, mask, charlie, potter, lulu, napoleon, kraiu, kutuzov, gorge);
    }
}
