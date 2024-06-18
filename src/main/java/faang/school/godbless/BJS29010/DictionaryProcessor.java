package faang.school.godbless.BJS29010;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> processor) {
        processor.accept(word, translation);
    }
}
