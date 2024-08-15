package faang.school.godbless.translator;

import java.util.function.BiConsumer;

public class DictionaryProcesssor {
    public void processWord(String word, String translation, BiConsumer<String, String> translationHandler) {
        translationHandler.accept(word, translation);
    }
}
