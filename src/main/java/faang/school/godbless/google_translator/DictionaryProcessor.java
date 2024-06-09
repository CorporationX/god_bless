package faang.school.godbless.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> wordAndTranslation) {
        wordAndTranslation.accept(word, translation);
    }
}
