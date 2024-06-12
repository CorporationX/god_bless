package faang.school.godbless.GoogleTransleterUnderOurControl;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(word, translation);
    }
}