package BJS2_20736_GoogleTranslator;

import java.util.List;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String word, List<String> helloList, BiConsumer<String, List<String>> translation) {
        translation.accept(word, helloList);
    }
}
