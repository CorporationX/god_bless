package faang.school.godbless.BJS2_9566;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String word, String translation, BiConsumer<String, String> addWord) {
        addWord.accept(word, translation);
    }
}
