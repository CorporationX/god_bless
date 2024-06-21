package faang.school.godbless;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> addWord) {
        addWord.accept(word, translate);
    }
}
