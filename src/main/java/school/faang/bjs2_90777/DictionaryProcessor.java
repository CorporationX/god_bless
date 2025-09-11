package school.faang.bjs2_90777;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translationWord, BiConsumer<String, String> consumer) {
        consumer.accept(word, translationWord);
    }
}
