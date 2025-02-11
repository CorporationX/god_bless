package school.faang.task_59513;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation,
                            BiConsumer<String, String> addWordToDictionary) {

        if ((word == null || word.isBlank() || wordTranslation == null || wordTranslation.isBlank())) {
            log.info("Error: Word and translation cannot be blank");
            return;
        }
        addWordToDictionary.accept(word, wordTranslation);
    }
}
