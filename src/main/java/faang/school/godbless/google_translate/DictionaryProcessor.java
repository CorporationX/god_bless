package faang.school.godbless.google_translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        validateWord(word);
        validateWord(translation);
        validateConsumer(consumer);

        consumer.accept(word, translation);
    }

    private void validateWord(String word) {
        if (word.isBlank()) {
            throw new IllegalArgumentException("Word can't be empty");
        }
    }

    private void validateConsumer(BiConsumer<String, String> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("Consumer can't be null");
        }
    }
}
