package faang.school.godbless.translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer processor) {
        processor.accept(word, translation);
    }
}
