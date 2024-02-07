package faang.school.godbless.hash_map.hobbyLovers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<User, String> map = new HashMap<>();
        User kirill = new User(1, "Kirill", 21, Set.of("Game", "Gym", "Video", "Bootcamp"));
        User andrey = new User(2, "Andrey", 33, Set.of("Car", "Gym"));
        User yaroslav = new User(3, "Yaroslav", 20, Set.of("Walk", "Beer"));
        map = User.findHobbyLovers(List.of(kirill, andrey, yaroslav),
                Set.of("Game", "Video", "Beer", "Walk"));
        System.out.println(map);
    }
}
