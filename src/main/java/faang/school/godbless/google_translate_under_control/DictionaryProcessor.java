package faang.school.godbless.google_translate_under_control;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord (String word, String wordTranslation, BiConsumer<String, String> wordSaver) {
        if (word == null || word.isBlank() || wordTranslation == null || wordTranslation.isBlank()) {
            throw new IllegalArgumentException("Incorrect data!");
        }
        wordSaver.accept(word, wordTranslation);
    }

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("пиво", "beer", addWordToDictionary);
        dictionaryProcessor.processWord("сосиски", "sausages", addWordToDictionary);
        dictionaryProcessor.processWord("", "sausages", addWordToDictionary);

        System.out.println(dictionary);
    }
}
