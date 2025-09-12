package school.faang.bjs2_88722;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    private static final Map<String, String> dictionary = new HashMap<>();

    public static void processWord(String word, String translation) {
        BiConsumer<String, String> consumer = (p1, p2) -> {
            dictionary.put(p1, p2);
        };
        consumer.accept(word, translation);
    }

    public static void printDictionary() {
        dictionary.forEach((word, translation) -> System.out.printf("%s - %s%n", word, translation));
    }
}
