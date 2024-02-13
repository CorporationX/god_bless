package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main4 {
    public static void main(String args[]){
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addToTheDictionary = (word, translatedWord) -> dictionary.put(word, translatedWord);

        dictionaryProcessor.processWord("Hello", "Привет", addToTheDictionary);
        dictionaryProcessor.processWord("World", "Мир", addToTheDictionary);
        dictionaryProcessor.processWord("Cat", "Кошка", addToTheDictionary);

        System.out.println("Словарь: " + dictionary);

    }
}
