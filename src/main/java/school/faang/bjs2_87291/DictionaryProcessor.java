package school.faang.bjs2_87291;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        if (word != null && translation != null && consumer != null) {
            consumer.accept(word, translation);
        }
    }
}
