package faang.school.godbless.googleTranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer<String, String> translation) {
        translation.accept(word, wordTranslation);
    }
}