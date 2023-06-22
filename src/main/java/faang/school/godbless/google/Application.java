package faang.school.godbless.google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Application {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        dictionary.forEach((key, value) -> System.out.printf("Русский: %s, English: %s\n", key, value));
    }
}
