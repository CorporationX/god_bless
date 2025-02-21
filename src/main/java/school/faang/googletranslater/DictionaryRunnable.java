package school.faang.googletranslater;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Slf4j
public class DictionaryRunnable {
    public static void main(String[] args) {
        DictionaryProcessor processor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> putWordAtDictionary = dictionary::put;
        String word = "word";
        String translation = "слово";
        processor.processWord(word, translation, putWordAtDictionary);

        log.info("Словарь: {}", dictionary);
    }
}
