package school.faang.task_59513;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(word, wordTranslation);
    }
}
