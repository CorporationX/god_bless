package faang.school.godbless.googleTranslater;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translatedWord, BiConsumer<String, String> entryAdder) {
        entryAdder.accept(word, translatedWord);
    }
}
