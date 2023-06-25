package sprint3.lambda.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    private static final DictionaryProcessor PROCESSOR = new DictionaryProcessor();
    private static final Map<String, String> DICTIONARY = new HashMap<>();

    public static void main(String[] args) {
        BiConsumer<String, String> handler = DICTIONARY::put;

        PROCESSOR.processWord("����", "Thread", handler);
        PROCESSOR.processWord("�����", "Earth", handler);
        PROCESSOR.processWord("������", "Stone", handler);

        System.out.println("������� ������: " + DICTIONARY);
    }
}
