package faang.school.godbless.googleTranslator;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Dictionary {
    static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWord = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("Hi", "Привет", addWord);
        dictionaryProcessor.processWord("Bye", "Пока", addWord);
        dictionaryProcessor.processWord("Hello", "Здравствуйте", addWord);

        System.out.println(dictionary);
    }
}
