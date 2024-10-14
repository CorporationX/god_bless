package school.faang.googleTranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translatedWord, BiConsumer<String, String> consumer) {
        consumer.accept(word, translatedWord);
    }
}
