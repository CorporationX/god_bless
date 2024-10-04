package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Person.getPersons();

        Map<Integer, List<Person>> groupedPersons = Person.groupPersonByAge(persons);

        groupedPersons.forEach(((age, personList) -> {
            System.out.println("Age: " + age);
            personList.forEach(System.out::println);
        }));

        System.out.println("\nКоличества доступных групп: ");
        System.out.println("\nКоличество уникальных возрастов: " + groupedPersons.size());

        System.out.println("\nКоличество людей в каждой группе: ");
        groupedPersons.forEach((age, personsList) -> System.out.println("Возраст: " + age + " Количество людей: " + personsList.size()));
    }
}
