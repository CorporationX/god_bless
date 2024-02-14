package faang.school.godbless.googletranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
        //BiConsumer<String, String> addWordToDictionary = dictionary::put;

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);
        dictionaryProcessor.processWord("Книга", "Book", addWordToDictionary);

        for (var entry : dictionary.entrySet()){
            System.out.println(entry. getKey() + " - " + entry.getValue());
        }
    }


}
