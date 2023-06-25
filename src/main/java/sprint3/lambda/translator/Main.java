package sprint3.lambda.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    private static final DictionaryProcessor PROCESSOR = new DictionaryProcessor();
    private static final Map<String, String> DICTIONARY = new HashMap<>();

    public static void main(String[] args) {
        BiConsumer<String, String> handler = DICTIONARY::put;

        PROCESSOR.processWord("Нить", "Thread", handler);
        PROCESSOR.processWord("Земля", "Earth", handler);
        PROCESSOR.processWord("Камень", "Stone", handler);

        System.out.println("Великие буковы: " + DICTIONARY);
    }
}
