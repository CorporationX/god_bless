package school.faang.task_45419;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    private Map<String, String> dictionary = new HashMap<>();

    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translation);
    }

    public void addToDictionary(String word, String translation) {
        processWord(word, translation, (w, t) -> dictionary.put(w, t));
    }

    public void printDictionary() {
        dictionary.forEach((w, t) -> System.out.println(w + " / " + t));
    }

}
