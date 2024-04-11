package faang.school.godbless.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer dictionaryHandler) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Параметр word не может быть null или пустым");
        }
        if (translation == null || translation.isEmpty()) {
            throw new IllegalArgumentException("Параметр translation не может быть null или пустым");
        }
        dictionaryHandler.accept(word, translation);
    }
}
