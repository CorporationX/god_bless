package school.faang.m1s2.bjs2_33510_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> processor) {
        processor.accept(word, translation);
    }
}
