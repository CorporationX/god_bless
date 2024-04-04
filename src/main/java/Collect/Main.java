package Collect;


import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> sampleSet1 = Set.of("football", "basketball", "gaming", "");
        Set<String> sampleSet2 = Set.of("football", "computerScience");
        List<User> sampleList = List.of(new User("Vasya", sampleSet1), new User("Maxim", Set.of("computerScience")));
        System.out.println(User.findHobbyLovers(sampleList, sampleSet2));
    }
}
