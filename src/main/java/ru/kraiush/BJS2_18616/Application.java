package ru.kraiush.BJS2_18616;

import ru.kraiush.model.Person;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        List<Person> persons = Person.getPersons();

        Map<Integer, List<Person>> res = Person.groupPersonByAge(persons);

        res.forEach((K,V) -> System.out.println("age: "+ K + " person: " + V));
    }
}