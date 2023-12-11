package faang.school.godbless.google_translater;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {

    private static Map<String, String> dictionary = new HashMap<>();

    public static void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        dictionary.put(word, translate);
    }

    public static void main(String[] args) {
        BiConsumer<String, String> consumer = (word, translate) -> dictionary.put(word, translate);

        processWord("кот", "cat", consumer);
        processWord("яблоко", "apple", consumer);
        processWord("инженер", "engineer", consumer);
        processWord("машина", "car", consumer);
        processWord("ракета", "rocket", consumer);
        processWord("яйцо", "egg", consumer);

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
