package school.faang.bjs2_79897;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    private static final Map<String, String> DICTIONARY = new HashMap<>();
    private static final BiConsumer<String, String> ADD_WORD_TO_DICTIONARY = (word, translation)
            -> DICTIONARY.put(word, translation);

    public static void main(String[] args) {

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("Elephant", "Слон", ADD_WORD_TO_DICTIONARY);
        dictionaryProcessor.processWord("Peace", "Мир", ADD_WORD_TO_DICTIONARY);
        dictionaryProcessor.processWord("Build", "Постройка", ADD_WORD_TO_DICTIONARY);
        System.out.println("Словарь: " + DICTIONARY);
    }
}
