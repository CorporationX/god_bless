package school.faang.task_43523;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translatedWord, BiConsumer<String, String> consumer) {
        consumer.accept(word, translatedWord);
    }
}
