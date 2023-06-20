package faang.school.godbless.sprint_3.google_translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class DictionaryProcessor {
    public static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        DictionaryProcessor processor = new DictionaryProcessor();
        BiConsumer<String, String> addWord = ((word, translate) -> dictionary.put(word, translate));
        processor.processWord("home", "Дом", (word, translate) -> dictionary.put(word, translate));
        processor.processWord("table", "стол", addWord);
        System.out.println(dictionary.toString());

    }

    public void processWord(String word, String translate, BiConsumer<String, String> consumer) throws IllegalArgumentException {

        if (isNullOrEmpty(word) || isNullOrEmpty(translate)) {
            throw new IllegalArgumentException("Invalid word or translation");
        } else if (dictionary.containsKey(word)) {
            return;
        }
        consumer.accept(word, translate);
    }

    public boolean isNullOrEmpty(String word) {
        return word == null || word.isBlank();
    }
}