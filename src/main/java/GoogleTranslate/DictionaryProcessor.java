package GoogleTranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionaryHandler) {
        dictionaryHandler.accept(word, translation);
    }
}