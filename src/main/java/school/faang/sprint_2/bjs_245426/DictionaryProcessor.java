package school.faang.sprint_2.bjs_245426;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        consumer.accept(word, translation);
    }
}
