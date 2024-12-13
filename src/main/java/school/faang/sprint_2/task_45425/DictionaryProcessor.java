package school.faang.sprint_2.task_45425;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void translateWord(String words, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(words, translation);
    }
}
