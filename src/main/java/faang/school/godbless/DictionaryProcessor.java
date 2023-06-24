package faang.school.godbless;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> addWordToDictionaryBiConsumer) {
        addWordToDictionaryBiConsumer.accept(word, translation);
    }
}
