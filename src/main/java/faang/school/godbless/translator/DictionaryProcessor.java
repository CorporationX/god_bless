package faang.school.godbless.translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer<String, String> wordHandler) {
        wordHandler.accept(word, wordTranslation);
    }
}
