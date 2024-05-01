package faang.school.godbless.BJS2_6209;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translatedWord, BiConsumer<String, String> dictionaryHandler) {
        dictionaryHandler.accept(word, translatedWord);
    }
}
