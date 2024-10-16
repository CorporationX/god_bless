package googleTranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    private final Map<String, String> dictionary = new HashMap<>();

    public void processWord(String word, String translation, BiConsumer<String, String> wordProcessor) {
        wordProcessor.accept(word, translation);
    }

    public void addWord(String word, String translation) {
        dictionary.put(word, translation);
    }

    public void removeWord(String word) {
        dictionary.remove(word);
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
