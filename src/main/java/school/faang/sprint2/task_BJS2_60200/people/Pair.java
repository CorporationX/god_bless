package school.faang.sprint2.task_BJS2_60200.people;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class Pair {
    private final Set<Person> pair = new HashSet<>();

    public Pair(Person person1, Person person2) {
        pair.add(person1);
        pair.add(person2);
    }
}
