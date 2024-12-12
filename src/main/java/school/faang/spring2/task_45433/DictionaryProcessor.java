package school.faang.spring2.task_45433;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translation);
    }
}
