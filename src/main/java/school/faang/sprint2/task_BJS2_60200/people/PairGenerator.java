package school.faang.sprint2.task_BJS2_60200.people;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class PairGenerator {
    private final Map<Person, Set<Person>> peopleWithFriends;
    private Set<Person> hasMutualFriends = new HashSet<>();

    public void addPerson(Person person) {
        hasMutualFriends.add(person);
    }

    public List<Pair> generateAllPairs() {
        List<Pair> pairs = new ArrayList<>();
        if (hasMutualFriends.size() < 2) {
            return pairs;
        }
        Person person1;
        Person person2;

        List<Person> people = hasMutualFriends.stream().toList();
        for (int i = 0; i < people.size() - 1; i++) {
            person1 = people.get(i);
            for (int j = i + 1; j < people.size(); j++) {
                person2 = people.get(j);
                if (isNotFriends(person1, person2)) {
                    Pair pair = new Pair(person1, person2);
                    pairs.add(pair);
                }

            }
        }

        hasMutualFriends.clear();
        return pairs;
    }

    private boolean isNotFriends(Person person1, Person person2) {
        return !peopleWithFriends.get(person1).contains(person2)
                && !peopleWithFriends.get(person2).contains(person1);
    }
}
