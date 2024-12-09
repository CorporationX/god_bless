package school.faang.task_45415;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> biconsumer) {
        biconsumer.accept(word, translate);
    }
}
