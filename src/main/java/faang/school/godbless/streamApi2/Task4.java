package faang.school.godbless.streamApi2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
 * Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья
 */
public class Task4 {
    public static void main(String[] args) {
        Map<String, List<String>> users = Map.of(
                "Ivan", List.of("Egor"),
                "Egor", List.of("Sveta"),
                "Igor", List.of("Masha"),
                "Semen", List.of("Gleb", "Egor"),
                "Petr", List.of("Ivan", "Sveta")
        );

        List<List<String>> userList = users.entrySet().stream()
                .flatMap(entry -> users.entrySet().stream()
                        .filter(e -> !entry.getKey().equals(e.getKey()) &&
                                !entry.getValue().contains(e.getKey()) &&
                                commonFriends(entry.getValue(), e.getValue())
                        )
                        .map(e -> {
                            List<String> pair = new ArrayList<>(List.of(entry.getKey(), e.getKey()));
                            pair.sort(String::compareTo);
                            return pair;
                        })
                )
                .distinct()
                .toList();

        System.out.println(userList);
    }

    private static boolean commonFriends(List<String> friends1, List<String> friends2) {
        return friends1.stream().anyMatch(friends2::contains);
    }
}
