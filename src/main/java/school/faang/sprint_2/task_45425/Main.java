package school.faang.sprint_2.task_45425;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new LinkedHashMap<>();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.translateWord("привет ", " Hello", addWordToDictionary);
        dictionaryProcessor.translateWord("мир ", " world!, ", addWordToDictionary);
        dictionaryProcessor.translateWord("я ", " i am", addWordToDictionary);
        dictionaryProcessor.translateWord("люблю ", " love", addWordToDictionary);
        dictionaryProcessor.translateWord("программирование ", " programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
