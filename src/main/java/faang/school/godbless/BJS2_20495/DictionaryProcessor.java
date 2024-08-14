package faang.school.godbless.BJS2_20495;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionary) {
        dictionary.accept(word, translation);
    }
}
