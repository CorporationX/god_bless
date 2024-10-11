package school.faang.Lambda.BJS2_33466;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    private static final Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        BiConsumer<String, String> addWordToDictionary= dictionary::put;

        fillDictionary("Я", "Me", addWordToDictionary);
        fillDictionary("Ты", "You", addWordToDictionary);
        fillDictionary("Мы", "We", addWordToDictionary);

        dictionary.forEach((key, value) -> System.out.println("Слово: " + key + " Перевод: " + value));
    }

    private static void fillDictionary(String word, String translationWord, BiConsumer<String, String> addWord) {
        DictionaryProcessor.processWord(word, translationWord, addWord);
    }
}
