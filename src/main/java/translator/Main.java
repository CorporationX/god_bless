package translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static final DictionaryProcessor processor = new DictionaryProcessor();
    private static final Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        BiConsumer<String, String> handler = dictionary::put;

        processor.processWord("Нить", "Thread", handler);
        processor.processWord("Земля", "Earth", handler);
        processor.processWord("Камень", "Stone", handler);

        System.out.println("Великие буковы: " + dictionary);
    }
}
