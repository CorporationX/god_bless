package school.faang.BJS2_33496_GoogleTranslatorIsUnderControl;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer<String, String> action) {
        action.accept(word, wordTranslation);
    }
}
