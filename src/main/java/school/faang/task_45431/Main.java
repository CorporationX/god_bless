package school.faang.task_45431;

import java.beans.BeanInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addToDictionary = (word, translate) -> dictionary.put(word, translate);

        dictionaryProcessor.processWord("Привет", "Hello", addToDictionary);
        dictionaryProcessor.processWord("Мир", "Hello", addToDictionary);
        dictionaryProcessor.processWord("Правда", "True", addToDictionary);
        dictionaryProcessor.processWord("Ложь", "False", addToDictionary);
        System.out.println("Dictionary\n" + dictionary);

    }
}
