package faang.school.godbless.BJS2_25810;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String originalWord, String translationWord,
                            BiConsumer<String, String> processBiConsumer) {
        processBiConsumer.accept(originalWord, translationWord);
    }
}
