package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictinory = dictionary::put;
        dictionaryProcessor.processWord("Apple", "Яблоко", addWordToDictinory);
        dictionaryProcessor.processWord("Key", "Ключ", addWordToDictinory);
        dictionaryProcessor.processWord("Moon", "Луна", addWordToDictinory);

        dictionary.forEach((word, translation) -> System.out.println(word + "-" + translation));
    }
}
