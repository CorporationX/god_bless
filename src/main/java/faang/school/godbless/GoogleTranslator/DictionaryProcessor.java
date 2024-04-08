package faang.school.godbless.GoogleTranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> savingProcess) {
        if (word == null || translation == null || savingProcess == null) {
            return;
        }
        savingProcess.accept(word, translation);
    }
}
