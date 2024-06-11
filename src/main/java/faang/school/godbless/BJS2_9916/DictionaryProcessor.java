package faang.school.godbless.BJS2_9916;

import java.util.function.BiConsumer;


public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        if (word != null || word.trim().isEmpty() ||
                translation != null || translation.trim().isEmpty() ||
                consumer != null)
            consumer.accept(word, translation);
    }
}
