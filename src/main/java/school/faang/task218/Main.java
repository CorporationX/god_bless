package school.faang.task218;

import school.faang.task218.dictionary.DictionaryProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> translateConsumer = dictionary::put;

        DictionaryProcessor.processWord("Привет", "Hello", translateConsumer);
        DictionaryProcessor.processWord("Пока", "Bye", translateConsumer);
        DictionaryProcessor.processWord("Стул", "Chair", translateConsumer);

        dictionary.forEach((key, value) -> System.out.println(key + " переводится как " + value));
    }
}
