package faang.school.godbless.BJS2_20577;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer biConsumer) {
        biConsumer.accept(word, wordTranslation);
    }
}
