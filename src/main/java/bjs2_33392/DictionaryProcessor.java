package bjs2_33392;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String originalWord, String translatedWord,
                                   BiConsumer<String, String> biConsumer) {
        biConsumer.accept(originalWord, translatedWord);
    }
}
