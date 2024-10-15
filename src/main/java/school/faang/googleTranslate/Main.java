package school.faang.googleTranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();

        String word1 = "Hi";
        String translation1 = "Privet";

        String word2 = "Bye";
        String translation2 = "Poka";

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> {
            dictionary.put(word, translation);
        };

        dictionaryProcessor.processWord(word1, translation1, addWordToDictionary);
        dictionaryProcessor.processWord(word2, translation2, addWordToDictionary);
        System.out.println(dictionary);
    }
}
