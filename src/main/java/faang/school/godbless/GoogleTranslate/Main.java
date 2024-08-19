package faang.school.godbless.GoogleTranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDict = dictionary::put;

        dictionaryProcessor.processWord("book", "Учебник", addWordToDict);
        dictionaryProcessor.processWord("table", "стол", addWordToDict);
        dictionaryProcessor.processWord("nice", "хорошо", addWordToDict);

        System.out.println("Словарь: " + dictionary);
    }
}
