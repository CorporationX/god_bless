package faang.school.godbless.BJS2_20688;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public static void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        consumer.accept(word, translation);
    }
}
