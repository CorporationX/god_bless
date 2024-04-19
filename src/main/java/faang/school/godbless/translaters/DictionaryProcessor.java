package faang.school.godbless.translaters;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(word, translate);
    }
}