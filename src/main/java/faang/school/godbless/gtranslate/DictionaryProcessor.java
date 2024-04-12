package faang.school.godbless.gtranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> process) {
        process.accept(word, translation);
    }
}
