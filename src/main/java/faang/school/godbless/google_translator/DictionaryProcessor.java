package faang.school.godbless.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer dictionaryHandler) {
        if (word == null) {
            throw new NullPointerException("The word field is null");
        }
        if (word.isEmpty()) {
            throw new NullPointerException("The word field is empty");
        }
        if (translation == null) {
            throw new NullPointerException("The translation field is null");
        }
        if (translation.isEmpty()) {
            throw new NullPointerException("The translation field is empty");
        }
        dictionaryHandler.accept(word, translation);
    }
}
