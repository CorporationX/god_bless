package faang.school.godbless.googletranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> addToDictionary) {
        addToDictionary.accept(word, translation);
    }
}
