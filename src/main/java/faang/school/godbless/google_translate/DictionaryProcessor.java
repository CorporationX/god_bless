package faang.school.godbless.google_translate;

import java.util.function.BiConsumer;


public class DictionaryProcessor {
    public void processWord(String word, String translatedWord, BiConsumer<String, String> vocabulary) {
        vocabulary.accept(word, translatedWord);
    }
}
