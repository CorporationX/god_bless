package school.faang.googletranslater;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
public class DictionaryProcessor {

    public void processWord(@NonNull String word, @NonNull String translateWord,
                            BiConsumer<String, String> addToDictionary) {
        checkWord(word);
        checkWord(translateWord);
        addToDictionary.accept(word, translateWord);
        log.info("Word added at dictionary: {}", word);

    }

    private void checkWord(@NonNull String word) {
        if (word == null) {
            log.warn("Word is null");
            throw new IllegalArgumentException("Word is null");
        }
        if (word.isEmpty()) {
            log.warn("Word is empty");
            throw new IllegalArgumentException("Word is empty");
        }
    }
}
