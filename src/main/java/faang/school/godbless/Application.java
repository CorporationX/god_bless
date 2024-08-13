package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Application {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionaryProcessor) {
        dictionaryProcessor.accept(word, translation);
    }
    public static void main(String[] args) {
        Application dictionaryProcessor = new Application();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
