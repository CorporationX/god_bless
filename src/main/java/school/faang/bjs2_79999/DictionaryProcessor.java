package school.faang.bjs2_79999;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processorWord(String word, String translation, BiConsumer<String, String> consumer) {
        consumer.accept(word, translation);
    }
}
