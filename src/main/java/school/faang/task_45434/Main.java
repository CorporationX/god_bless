package school.faang.task_45434;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addingANewWord = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addingANewWord);
        dictionaryProcessor.processWord("мир", "world", addingANewWord);
        dictionaryProcessor.processWord("программирование", "programming", addingANewWord);

        System.out.println("Словарь: " + dictionary);
    }
}
