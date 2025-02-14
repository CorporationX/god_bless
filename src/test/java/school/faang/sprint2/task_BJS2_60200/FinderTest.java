package school.faang.sprint2.task_BJS2_60200;

import org.junit.jupiter.api.Test;
import school.faang.sprint2.task_BJS2_60200.people.Pair;
import school.faang.sprint2.task_BJS2_60200.people.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    private final Finder finder = new Finder();

    @Test
    public void findPeopleWithMutualFriends() {
        Map<Person, Set<Person>> peopleWithFriends = new HashMap<>();
        Set<Pair> excepted = new HashSet<>();
        fillPeopleData(peopleWithFriends, excepted);

        assertEquals(excepted, finder.findPeopleWithMutualFriends(peopleWithFriends));
    }

    private void fillPeopleData(Map<Person, Set<Person>> peopleWithFriends, Set<Pair> excepted) {
        Person alice =  new Person("Alice");
        Person bob = new Person("Bob");
        Person charlie = new Person("Charlie");
        Person david = new Person("David");

        peopleWithFriends.put(alice, Set.of(bob, charlie));
        peopleWithFriends.put(bob, Set.of(alice, david));
        peopleWithFriends.put(charlie, Set.of(alice, david));
        peopleWithFriends.put(david, Set.of(bob, charlie));

        excepted.add(new Pair(alice, david));
        excepted.add(new Pair(bob, charlie));
    }
}