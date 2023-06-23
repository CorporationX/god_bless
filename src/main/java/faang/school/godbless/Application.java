package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Application {
    public static void main(String... args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> biConsumer = dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", biConsumer);
        dictionaryProcessor.processWord("мир", "world", biConsumer);
        dictionaryProcessor.processWord("программирование", "programming", biConsumer);

        System.out.println("Словарь: " + dictionary);
    }
}

