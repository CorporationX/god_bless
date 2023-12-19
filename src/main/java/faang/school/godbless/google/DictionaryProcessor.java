package faang.school.godbless.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String word, String translation, BiConsumer<String, String> handler) {
        handler.accept(word, translation);
    }
}
