package school.faang.googletranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translationOfTheWord,
                            BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translationOfTheWord);
    }
}
