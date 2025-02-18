package school.faang.sprint2.task_BJS2_60200.people;

import lombok.Getter;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Getter
public class PairGenerator {
    private final Map<Person, Set<Person>> peopleWithFriends;
    private final Set<Pair> pairOfPeople = new HashSet<>();
    private final Set<Person> found = new HashSet<>();
    private Person friend;

    public PairGenerator(Map<Person, Set<Person>> peopleWithFriends) {
        this.peopleWithFriends = peopleWithFriends;
    }

    public void generateAllPairs(Set<Person> people) {
        if (people == null) {
            return;
        }
        people.stream()
                .filter(Objects::nonNull)
                .filter(friend -> !found.contains(friend))
                .forEach(this::generatePairsForOfFriend);
    }

    private void generatePairsForOfFriend(Person friend) {
        this.friend = friend;
        peopleWithFriends.forEach(this::generatePairs);
        found.add(friend);
    }

    private void generatePairs(Person person1, Set<Person> people1) {
        if (isInvalidEntry(person1, people1, friend) || Objects.equals(person1, friend)) {
            return;
        }
        peopleWithFriends.forEach((person2, people2) -> createPair(person1, people1, person2, people2));
    }

    private void createPair(Person person1, Set<Person> people1, Person person2, Set<Person> people2) {
        if (isInvalidEntry(person2, people2, friend) || Objects.equals(person1, person2)
                || people2.contains(person1) || people1.contains(person2)) {
            return;
        }
        pairOfPeople.add(new Pair(person1, person2));
    }

    private boolean isInvalidEntry(Person person, Set<Person> friends, Person friend) {
        return person == null || friends == null
                || !friends.contains(friend);
    }
}
