package school.faang.dictionary;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;


public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> addWordToDictionary) {
        if ((word != null || !word.isEmpty()) && (translation != null || !translation.isEmpty()))
            addWordToDictionary.accept(word, translation);
    }
}