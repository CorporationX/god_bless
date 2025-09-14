package school.faang.lambda.bjs2_87304;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class App {

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary =
                (word, translatedWord) -> dictionary.put(word, translatedWord);

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("One", "Один", addWordToDictionary);
        dictionaryProcessor.processWord("Door", "Дверь", addWordToDictionary);
        dictionaryProcessor.processWord("Cat", "Кошка", addWordToDictionary);

        System.out.println(dictionary);
    }
}