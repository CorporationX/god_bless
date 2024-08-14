package google.translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String wordTranslate, BiConsumer<String, String> consumer) {
        consumer.accept(word, wordTranslate);
    }
}
