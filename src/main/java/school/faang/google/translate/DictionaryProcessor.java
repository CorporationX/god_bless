package school.faang.google.translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String word, String translation, BiConsumer<String, String> addTranslation) {
        addTranslation.accept(word, translation);
    }
}
