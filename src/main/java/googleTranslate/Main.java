package googleTranslate;

import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addToDictionary = dictionaryProcessor::addWord;

        dictionaryProcessor.processWord("привет", "hello", addToDictionary);
        dictionaryProcessor.processWord("мир", "world", addToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addToDictionary);

        dictionaryProcessor.processWord("привет", "hello", (word, translate) -> {
            dictionaryProcessor.removeWord(word);
        });

        System.out.println("Словарь: " + dictionaryProcessor.getDictionary());
    }
}
