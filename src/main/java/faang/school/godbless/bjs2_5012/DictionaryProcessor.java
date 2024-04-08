package faang.school.godbless.bjs2_5012;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        consumer.accept(word, translate);
    }
}
