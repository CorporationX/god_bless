package school.faang.task_45416;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@ToString
public class DictionaryProcessor {
    Map<String, String> dictionary = new HashMap<>();

    public void processWord(String word, String translation, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(word, translation);
    }
}
