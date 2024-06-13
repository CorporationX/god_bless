package faang.school.godbless.google_translator;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("hello", "привет", dictionary::put);
        dictionaryProcessor.processWord("world", "мир", dictionary::put);
        dictionaryProcessor.processWord("window", "окно", dictionary::put);

        for (Map.Entry<String, String> dictionaryWords : dictionary.entrySet()) {
            System.out.println(dictionaryWords.getKey() + " - " + dictionaryWords.getValue());
        }
    }
}
