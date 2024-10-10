package school.faang.task218.dictionary;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String word, String translatedWord, BiConsumer<String, String> mapPut) {
        mapPut.accept(word, translatedWord);
    }
}
