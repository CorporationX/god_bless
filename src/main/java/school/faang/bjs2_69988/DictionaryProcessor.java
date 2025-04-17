package school.faang.bjs2_69988;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> translator) {
        translator.accept(word, translation);
    }
}