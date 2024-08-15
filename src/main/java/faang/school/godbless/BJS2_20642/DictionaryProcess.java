package faang.school.godbless.BJS2_20642;

import java.util.function.BiConsumer;

public class DictionaryProcess {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionaryHandler) {
        dictionaryHandler.accept(word, translation);
    }
}
