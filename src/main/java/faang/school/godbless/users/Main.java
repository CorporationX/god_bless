package faang.school.godbless.users;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(
                1,
                "Tom",
                19,
                new HashSet<>(Arrays.asList("yoga", "run")),
                "London",
                "Google"
        );
        // Кинет исключение из-за адреса
        User user2 = new User(
                2,
                "Jon",
                22,
                new HashSet<>(Arrays.asList("velo", "kite surfing")),
                "Oslo",
                "Uber"
        );
        // Кинет исключение из-за возраста
        User user3 = new User(
                3,
                "Ann",
                17,
                new HashSet<>(Arrays.asList("travel", "moto")),
                "Amsterdam",
                "Amazon"
        );
        // Кинет исключение из-за места работы
        User user4 = new User(
                4,
                "Liza",
                25,
                new HashSet<>(Arrays.asList("eat", "PC games")),
                "New York",
                "Epic Games"
        );
    }
}
