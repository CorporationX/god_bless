package translator;

import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        if (word == null || translation == null || consumer == null) {
            throw new IllegalArgumentException("Arguments word, translation and consumer must not be null");
        }
        try {
            consumer.accept(word, translation);
        } catch (Exception e) {
            log.error("Error processing word: {} with translation: {}", word, translation, e);
            throw new DictionaryProcessingException("Error processing word: " + word, e);
        }
    }
}
