package faang.school.godbless.googletranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> dictionaryAction) {
        dictionaryAction.accept(word, translation);
    }
}