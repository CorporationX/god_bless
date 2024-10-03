import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    @DisplayName("collect person by activity(positive)")
    void positiveTestCollectPersonByActivity() {
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Zhubanysh", 19, Arrays.asList("Football", "Programming")),
                new Person("Artur", 18, Arrays.asList("Design", "Football")),
                new Person("Nurzhan", 19, Arrays.asList("Training", "Mobile Games")),
                new Person("Nurbek", 17, Arrays.asList("Cisco", "Travel")),
                new Person("Bekassyl", 20, Arrays.asList("Sing", "Travel", "Shopping")),
                new Person("Madiyar", 19, Arrays.asList("Football", "Design", "Sing"))
        ));
        List<String> activities1 = new ArrayList<>(Arrays.asList(
                "Football", "Design"
        ));
        List<String> activities2 = new ArrayList<>(Arrays.asList(
                "Sing", "Travel"
        ));
        List<String> activities3 = new ArrayList<>(Arrays.asList(
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