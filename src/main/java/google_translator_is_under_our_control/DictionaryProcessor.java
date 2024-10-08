package google_translator_is_under_our_control;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String originWord, String translatedWord, BiConsumer<String, String> add) {
        add.accept(translatedWord, originWord);
    }
}
