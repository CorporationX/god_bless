package school.faang.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translation);
    }
}
