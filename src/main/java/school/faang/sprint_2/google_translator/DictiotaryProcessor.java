package school.faang.sprint_2.google_translator;

import java.util.function.BiConsumer;

public class DictiotaryProcessor {
    public static void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        consumer.accept(word, translation);
    }
}
