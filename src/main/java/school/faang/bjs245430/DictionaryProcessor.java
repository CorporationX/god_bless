package school.faang.bjs245430;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> addFunction) {
        addFunction.accept(word, translation);
    }
}