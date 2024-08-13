package faang.school.godbless.Google_Translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translation);
    }

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
        dictionaryProcessor.processWord("Слово", "Word", addWordToDictionary);
        dictionaryProcessor.processWord("Жизнь", "Life", addWordToDictionary);
        dictionaryProcessor.processWord("Смерть", "Death", addWordToDictionary);
    }
}
