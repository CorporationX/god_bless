package school.faang.task_45416;

import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = (word, translation) ->
                dictionaryProcessor.dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionaryProcessor.dictionary.toString());
    }
}
