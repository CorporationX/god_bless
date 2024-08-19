package ru.kraiush.BJS2_18616;

import org.junit.jupiter.api.Test;
import ru.kraiush.model.Person;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest extends Person {
    @Test
    void testGroupPersonByAge() {
        List<Person> persons = Person.getPersons();
        Map<Integer, List<Person>> res = Person.groupPersonByAge(persons);
        res.forEach((K,V) -> System.out.println("age: "+ K + " person: " + V));
        assertEquals(4, res.size());
        assertEquals(3, res.get(17).size());
        assertEquals(1, res.get(41).size());
        assertEquals(1, res.get(53).size());
        assertEquals(2, res.get(124).size());
    }
}