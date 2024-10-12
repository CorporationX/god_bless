package school.faang.googletranslitor.maincode;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translite, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translite);
    }
}
