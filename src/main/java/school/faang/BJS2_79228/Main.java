package school.faang.BJS2_79228;

import school.faang.BJS2_79228.model.User;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello BJS2-79228!");
        var activities = Set.of("football", "dota", "standup");
        var john = new User(1, "John", 29, Set.of("dota", "football", "basketball"));
        var sherlock = new User(2, "Sherlock", 31, Set.of("reading", "tea party", "dota"));
        var lestrade = new User(3, "Lestrade", 41, Set.of("dancing", "cricket", "hockey"));
        var hobbyLovers = User.findHobbyLovers(List.of(john, sherlock, lestrade), activities);
        System.out.println(hobbyLovers);
    }
}
