package school.faang.task45417;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> translatedWords = new HashMap<>();

        dictionaryProcessor.processWord("cat", "кошка",
                (word, translate) -> translatedWords.putIfAbsent(word, translate));

        System.out.println(translatedWords);
    }
}
