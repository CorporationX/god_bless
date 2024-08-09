import org.junit.jupiter.api.Test;
import ru.kraiush.model.model.Person;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest extends Person {

    @Test
    void testGroupPersonByAge() {
        List<Person> persons = Person.getPersons();
        Map<Integer, List<Person>> res = Person.groupPersonByAge(persons);
        res.forEach((K,V) -> System.out.println("age: "+ K + " person: " + V));
        assertEquals(4, res.size());
    }
}