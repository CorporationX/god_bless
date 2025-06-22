package school.faang.bjs2_79897;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String russianWord, BiConsumer<String, String> duoWords) {
        duoWords.accept(word, russianWord);
    }
}
