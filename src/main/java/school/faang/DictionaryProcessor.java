package school.faang;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> translate) {
        translate.accept(word, translation);
    }
}
