package googleTranslate_804;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {

    public static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWord = (nameEng, nameRus) -> dictionary.put(nameEng, nameRus);
        dictionaryProcessor.processWord("Cat", "Кот", addWord);
        dictionaryProcessor.processWord("Dog", "Собака", addWord);

        System.out.println(dictionary);
    }
}