package faang.school.godbless.BJS2_20642;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        DictionaryProcess dictionaryProcess = new DictionaryProcess();
        dictionaryProcess.processWord("hello", "hola", (word, translation) -> dictionary.put(word, translation));
        dictionaryProcess.processWord("bye", "adios", (word, translation) -> dictionary.put(word, translation));
        printDictionary();
    }

    public static void printDictionary() {
        dictionary.forEach((word, translation) -> System.out.println("Word: " + word + ", Translation: " + translation));
    }
}
