package ru.kraiush.BJS2_18616;

import lombok.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private String name;
    private int age;
    private String profession;
    private String address;

    public static Map<Integer, List<Person>> groupPersonByAge(List<Person> persons) {

        if (persons == null || persons.isEmpty()) {
            return null;
        }

        Map<Integer, List<Person>> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public static List<Person> getPersons() {
        Person john = new Person("John Lennon", 41, "rock-n-roll", "Leverpool");
        Person mask = new Person("Ilon Mask", 53, "engineer", "California");
        Person charlie = new Person("Charlie Chaplin", 124, "actor", "London");
        Person potter = new Person("Harry Potter", 17, "fairy hero", "Hogwarts");
        Person lulu = new Person("Lulu Kringe", 17, "harlot", "Africa");
        Person napoleon = new Person("Napoleon", 124, "warrier", "Paris");
        Person burbon = new Person("Buba Ankor", 17, "dreamer", "Kalimantan");

        return Arrays.asList(john, mask, charlie, potter, lulu, napoleon, burbon);
    }
}
