package faang.school.godbless.functionalInterfaces.google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> englishRussianDictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToEnglishRussianDictionary = englishRussianDictionary::put;

        dictionaryProcessor.processWord("programming", "программирование", addWordToEnglishRussianDictionary);
        dictionaryProcessor.processWord("database", "база данных", addWordToEnglishRussianDictionary);
        dictionaryProcessor.processWord("code", "код", addWordToEnglishRussianDictionary);
        dictionaryProcessor.processWord("server", "сервер", addWordToEnglishRussianDictionary);
        dictionaryProcessor.processWord("network", "сеть", addWordToEnglishRussianDictionary);

        System.out.println("Words stored in english-russian dictionary:");
        englishRussianDictionary.forEach((word, translation) -> {
            System.out.println(word + " = " + translation);
        });
    }
}
