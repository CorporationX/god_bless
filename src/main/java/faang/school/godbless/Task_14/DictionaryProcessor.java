package faang.school.godbless.Task_14;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String originalWord, String wordTranslated, BiConsumer<String, String> saveWordInTranslator) {
        saveWordInTranslator.accept(originalWord, wordTranslated);
    }
}
