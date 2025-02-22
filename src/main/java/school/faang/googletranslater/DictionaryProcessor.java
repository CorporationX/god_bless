package school.faang.googletranslater;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
public class DictionaryProcessor {

    public void processWord(@NonNull String word, @NonNull String translateWord,
                            BiConsumer<String, String> dictionaryConsumer) {
        checkWord(word);
        checkWord(translateWord);
        dictionaryConsumer.accept(word, translateWord);
        log.info("Word {} with translation {} added to dictionary", word, translateWord);

    }

    private void checkWord(@NonNull String word) {
        if (word.isBlank()) {
            log.warn("Word is empty");
            throw new IllegalArgumentException("Word is empty");
        }
    }
}
