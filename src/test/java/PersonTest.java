import org.example.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    @DisplayName("collect person by activity(positive)")
    void positiveTestCollectPersonByActivity() {
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Zhubanysh", 19, Set.of("Football", "Programming")),
                new Person("Artur", 18, Set.of("Design", "Football")),
                new Person("Nurzhan", 19, Set.of("Training", "Mobile Games")),
                new Person("Nurbek", 17, Set.of("Cisco", "Travel")),
                new Person("Bekassyl", 20, Set.of("Sing", "Travel", "Shopping")),
                new Person("Madiyar", 19, Set.of("Football", "Design", "Sing"))
        ));
        Set<String> activities1 = new HashSet<>(Set.of(
                "Football", "Design"
        ));
        Set<String> activities2 = new HashSet<>(Set.of(
                "Sing", "Travel"
        ));
        Set<String> activities3 = new HashSet<>(Set.of(
                "Watch cinema"
        ));

        Map<Person, String> firstCollection = Person.findHobbyLovers(personList, activities1);
        Map<Person, String> secondCollection = Person.findHobbyLovers(personList, activities2);
        Map<Person, String> thirdCollection = Person.findHobbyLovers(personList, activities3);

        assertEquals(3, firstCollection.size());
        assertEquals(3, secondCollection.size());
        assertEquals(0, thirdCollection.size());
    }
}