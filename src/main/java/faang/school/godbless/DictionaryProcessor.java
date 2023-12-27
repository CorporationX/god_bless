package faang.school.godbless;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String wordRu, String wordEn, BiConsumer<String, String> cons) {
        cons.accept(wordRu, wordEn);
    }
}
