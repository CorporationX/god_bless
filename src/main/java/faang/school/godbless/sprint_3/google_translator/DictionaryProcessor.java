package faang.school.godbless.sprint_3.google_translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class DictionaryProcessor {
    public Map<String, String> dictionary = new HashMap<>();

    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        if (isNullOrEmpty(word) || isNullOrEmpty(translate) || consumer == null) {
            throw new IllegalArgumentException("Consumer is null, or word/it translation is null or empty");
        }
        consumer.accept(word, translate);
    }

    public boolean isNullOrEmpty(String word) {
        return word == null || word.isBlank();
    }
}