package school.faang.sprint_2.task_45683;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(word, wordTranslation);
    }
}
