package google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {


    public static void processWord(String word, String translate, BiConsumer<String, String> wordAndTranslateToDictionary) {
        if (word != null || translate != null) {
            wordAndTranslateToDictionary.accept(word, translate);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
