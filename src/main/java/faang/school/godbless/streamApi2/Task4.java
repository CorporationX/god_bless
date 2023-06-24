package faang.school.godbless.streamApi2;

import java.util.List;
import java.util.Map;

/**
 * Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
 * Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья
 */
public class Task4 {
    public static void main(String[] args) {
        Map<String, List<String>> countries = Map.of(
                "Ivan", List.of("Egor"),
                "Egor", List.of("Sveta"),
                "Igor", List.of("Masha"),
                "Semen", List.of("Gleb", "Egor"),
                "Petr", List.of("Ivan")
        );

    }
}
