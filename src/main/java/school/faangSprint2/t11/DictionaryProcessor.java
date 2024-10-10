package school.faangSprint2.t11;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    static Map<String, String> dictionary;

    public DictionaryProcessor() {
        this.dictionary = new HashMap<>();
    }

    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        consumer.accept(word, translation);
    }
}