package faang.school.godbless.module1.sprint2.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dp = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;


        dp.processWord("привет", "hello", addWordToDictionary);
        dp.processWord("мир", "world", addWordToDictionary);
        dp.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
