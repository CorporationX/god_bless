package BJS2_9502;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionary) {
        dictionary.accept(word, translation);
    }
}