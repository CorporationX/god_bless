package school.faang.task_57107;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        consumer.accept(word, translate);
    }
}
