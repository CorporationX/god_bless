package google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionary) {
        dictionary.accept(word, translation);
    }
}
